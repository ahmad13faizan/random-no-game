import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/randomNumber")
public class RandomNumberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final int MAX_ATTEMPTS = 5; // Maximum number of attempts per round

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get or create session
        HttpSession session = request.getSession();

        // Retrieve the generated number from the session or generate a new one
        int randomNumber;
        if (session.getAttribute("randomNumber") == null) {
            randomNumber = generateRandomNumber();
            session.setAttribute("randomNumber", randomNumber);
            session.setAttribute("attempts", 0);
            session.setAttribute("score", 0);
            session.setAttribute("rounds", 0);
        } else {
            randomNumber = (int) session.getAttribute("randomNumber");
        }

        // Get the user's guess from the form
        int userGuess = Integer.parseInt(request.getParameter("guess"));

        // Increment the number of attempts
        int attempts = (int) session.getAttribute("attempts") + 1;
        session.setAttribute("attempts", attempts);

        // Compare the user's guess with the generated number
        if (userGuess == randomNumber) {
            // Correct guess
            int score = (int) session.getAttribute("score") + MAX_ATTEMPTS - attempts + 1;
            session.setAttribute("score", score);
            int rounds = (int) session.getAttribute("rounds") + 1;
            session.setAttribute("rounds", rounds);
            out.println("<h2>Congratulations! You guessed the correct number!</h2>");
        } else if (attempts >= MAX_ATTEMPTS) {
            // Maximum attempts reached
            out.println("<h2>Sorry, you've reached the maximum number of attempts.</h2>");
        } else if (userGuess < randomNumber) {
            // Guess is too low
            out.println("<h2>Your guess is too low. Try again!</h2>");
        } else {
            // Guess is too high
            out.println("<h2>Your guess is too high. Try again!</h2>");
        }

        // Display the user's score
        int score = (int) session.getAttribute("score");
        out.println("<p>Your score: " + score + "</p>");

        // Display option for multiple rounds
        out.println("<p><a href=\"randomNumber\">Play Again</a></p>");
    }

    // Method to generate a random number between 1 and 100
    private int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }
}
