<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Number Guessing Game</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url("./images/game-bg.jpg");
            margin: 0;
            padding: 0;
        }
        
        h1 {
            text-align: center;
            color: #333;
            margin-top: 50px;
        }
        
        .container {
            max-width: 400px;
            margin: 0 auto;
            margin-top:  5px;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        
        form {
            text-align: center;
            margin-top: 20px;
        }
        
        input[type="submit"] {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4caf50;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            text-transform: uppercase;
            letter-spacing: 1px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        
        input[type="text"] {
            padding: 10px;
            font-size: 16px;
            width: 100%;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-top: 10px;
        }
        
        p {
            text-align: center;
            font-size: 18px;
            margin-top: 20px;
            color: #333;
        }

        p.error {
            color: #ff0000;
            font-weight: bold;
        }

        .animation {
            animation: fadeIn 1s ease;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }
    </style>
</head>
<body>
    
    <div class="container animation">
        <h1>Welcome to the Number Guessing Game!</h1>
        <form action="NumberGuessServlet" method="post">
            <input type="hidden" name="newgame" value="true">
            <input type="submit" value="Start New Game">
        </form>
    </div>
</body>
</html>
