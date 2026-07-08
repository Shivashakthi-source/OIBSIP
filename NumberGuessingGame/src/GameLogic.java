import java.util.Random;

public class GameLogic {

    private int secretNumber;
    private int attempts;
    private int maxAttempts;
    private int maxNumber;
    private boolean gameOver;

    public GameLogic(Difficulty difficulty) {
        startNewGame(difficulty);
    }

    public void startNewGame(Difficulty difficulty) {

        maxNumber = difficulty.getMaxNumber();
        maxAttempts = difficulty.getMaxAttempts();

        Random random = new Random();
        secretNumber = random.nextInt(maxNumber) + 1;

        attempts = 0;
        gameOver = false;
    }

    public String checkGuess(int guess) {

        if (gameOver) {
            return "Game Over!";
        }

        attempts++;

        if (guess == secretNumber) {
            gameOver = true;
            return "Correct!";
        }

        if (attempts >= maxAttempts) {
            gameOver = true;
            return "You Lost! The number was " + secretNumber;
        }

        if (guess > secretNumber) {
            return "Too High!";
        }

        return "Too Low!";
    }

    public int getAttempts() {
        return attempts;
    }

    public int getRemainingAttempts() {
        return maxAttempts - attempts;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getMaxNumber() {
        return maxNumber;
    }
}