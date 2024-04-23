# Number Guessing Game

Welcome to the Number Guessing Game! This is a web application where players can guess a randomly generated number within a specified range.

## Features

- **Random Number Generation**: The game generates a random number between a specified range for players to guess.
- **Feedback on Guesses**: After each guess, the player receives feedback indicating whether the guess was too high, too low, or correct.
- **Limited Attempts**: Players have a limited number of attempts to guess the correct number.
- **User-friendly Interface**: The game provides a simple and intuitive user interface for an enjoyable experience.

## Technologies Used

- **Java Servlets**: Handles server-side logic and request processing.
- **HTML**: Markup language for creating the structure of web pages.
- **CSS**: Stylesheets for styling the user interface.
- **Apache Maven**: Project management tool for building and managing dependencies.

## Getting Started

To run the Number Guessing Game locally, follow these steps:

1. **Clone the Repository**: 
    ```bash
    git clone https://github.com/ahmad13faizan/random-no-game.git
    ```

2. **Navigate to the Project Directory**: 
    ```bash
    cd random-no-game
    ```

3. **Build the Project**: 
    ```bash
    mvn clean package
    ```

4. **Deploy the Application**:
    - Copy the generated WAR file (`number-guessing-game.war`) to the `webapps` directory of your servlet container (e.g., Apache Tomcat).
    - Start the servlet container.

5. **Access the Application**:
    - Open a web browser and go to `http://localhost:8080/number-guessing-game`.

## Contributing

Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please [open an issue](https://github.com/ahmad13faizan/random-no-game/issues) or [create a pull request](https://github.com/ahmad13faizan/random-no-game/pulls).

## License

This project is licensed under the [MIT License](LICENSE).
