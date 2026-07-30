# OIBSIP
# 🎯 Number Guessing Game

A simple Java-based Number Guessing Game where the player tries to guess a randomly generated number within a limited number of attempts. The game provides hints after each guess and allows players to play multiple rounds while tracking their score.

## 📌 Features

- 🎲 Random number generation
- 🔢 User input for guessing numbers
- 📈 Hints ("Too High" / "Too Low")
- ✅ Displays when the correct number is guessed
- ⏳ Limited number of attempts
- 🏆 Score tracking
- 🔄 Play Again option
- 🎯 Multiple difficulty levels (Easy, Medium, Hard)
- 🖥️ User-friendly Java Swing GUI

## 🛠️ Technologies Used

- Java
- Java Swing (GUI)
- Object-Oriented Programming (OOP)

## 📂 Project Structure

```
NumberGuessingGame/
│
├── Main.java
├── GameFrame.java
├── GamePanel.java
├── GameLogic.java
├── Difficulty.java
├── ScoreManager.java
└── README.md
```

## 🚀 How to Run

1. Clone the repository:

```bash
git clone https://github.com/your-username/NumberGuessingGame.git
```

2. Navigate to the project folder:

```bash
cd NumberGuessingGame
```

3. Compile the Java files:

```bash
javac *.java
```

4. Run the application:

```bash
java Main
```

## 🎮 How to Play

1. Launch the application.
2. Select a difficulty level.
3. Enter your guess in the input box.
4. Click Guess.
5. The game will tell you whether your guess is:
   - Too High
   - Too Low
   - Correct
6. Guess the number before running out of attempts.
7. Choose Play Again to start a new round.

## 📊 Difficulty Levels

| Difficulty | Number Range | Attempts |
|------------|-------------:|---------:|
| Easy | 1 - 50 | 10 |
| Medium | 1 - 100 | 7 |
| Hard | 1 - 200 | 5 |

> The ranges and attempts may vary depending on the implementation.

## 👨‍💻 Author

**Shivashakthi V**

## 📄 License

This project is created for learning purposes as part of the **Oasis Infobyte Java Development Internship**.
