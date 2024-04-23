import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class NumberGuessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
    
        // Check if a new game needs to be started
        if (request.getParameter("newgame") != null ) {
            session.removeAttribute("numberToGuess");
            session.removeAttribute("attempts");
        }
        // Check if the number to guess is already set
        if (session.getAttribute("numberToGuess") == null) {
            Random random = new Random();
            int numberToGuess = random.nextInt(100) + 1;
            session.setAttribute("numberToGuess", numberToGuess);
            session.setAttribute("attempts", 0);
        }
        
        int numberToGuess = (int) session.getAttribute("numberToGuess");
        int attempts = (int) session.getAttribute("attempts");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if((int) session.getAttribute("attempts")<9 ){
        out.println("<html><head><title>Number Guessing Game</title>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">");
        out.println("</head><body>");
        out.println("<div class=\"container\">");
        out.println("<h1>Welcome to the Number Guessing Game!</h1>");
        out.println("<form action=\"NumberGuessServlet\" method=\"POST\">");
        out.println("Your Guess: <input type=\"text\" name=\"guess\"><br>");
        out.println("<input type=\"submit\" value=\"Submit Guess\">");
        out.println("</form>");
        out.println("</div>");
        out.println("</body></html>");
        }
        
        if (request.getParameter("guess") != null) {
            int userGuess = Integer.parseInt(request.getParameter("guess"));
            attempts++;
            session.setAttribute("attempts", attempts);
            
            if (userGuess == numberToGuess) {
                out.println("<div class=\"container\">");
                out.println("<p>Congratulations! You guessed the correct number!</p>");
                out.println("<p>Number of attempts: " + attempts + "</p>");
                out.println("<form action=\"NumberGuessServlet\" method=\"POST\">");
                out.println("<input type=\"submit\" value=\"Play Again\">");
                out.println("</form>");
                

                session.removeAttribute("numberToGuess");
                session.removeAttribute("attempts");
            } else if (attempts >= 10 ) {
                out.println("<html><head><title>Number Guessing Game</title>");
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">");
                out.println("</head><body>");
                out.println("<div class=\"container\">");
                out.println("<p style=\"color: red; font-size: 24px; text-align: center;\">Sorry, you have reached the maximum number of attempts. The correct number was " + numberToGuess + ".</p>");
                out.println("<marquee><h2 style=\"font-size: 36px; color: blue; text-align: center;\">Game Over</h2></marquee>");
                out.println("<form action=\"NumberGuessServlet\" method=\"POST\">");
                out.println("<input type=\"submit\" value=\"Play Again\" style=\"background-color: #4CAF50; border: none; color: white; padding: 15px 32px; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; margin: 4px 2px; cursor: pointer; border-radius: 10px;\">");
                out.println("</form>");
                out.println("</div>");
                out.println("</body></html>");
                

                session.removeAttribute("numberToGuess");
                session.removeAttribute("attempts");
            } else if (userGuess < numberToGuess) {
                out.println("<div class=\"container\">");
                out.println("<p> Sorry, your guess is too low.</p>");
                out.println("</div>");
            } else {
                out.println("<div class=\"container\">");
                out.println("<p> Sorry, your guess is too high.</p>");
                out.println("</div>");
            }
        }
        
        out.println("</body></html>");
    }
    
}
