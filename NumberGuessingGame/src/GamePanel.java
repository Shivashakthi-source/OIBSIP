import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private GameLogic game;
    private ScoreManager scoreManager;

    private int round = 1;

    JLabel titleLabel;
    JComboBox<String> difficultyBox;
    JLabel attemptsLabel;
    JLabel hintLabel;
    JTextField guessField;
    JButton guessButton;
    JButton playAgainButton;
    JTextArea scoreArea;

    public GamePanel() {

        game = new GameLogic(Difficulty.MEDIUM);
        scoreManager = new ScoreManager();

        setPreferredSize(new Dimension(500, 500));
        setLayout(new BorderLayout(10,10));

        titleLabel = new JLabel("🎯 Number Guessing Game",SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial",Font.BOLD,24));

        add(titleLabel,BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(7,1,10,10));

        difficultyBox = new JComboBox<>();
        difficultyBox.addItem("Easy");
        difficultyBox.addItem("Medium");
        difficultyBox.addItem("Hard");

        center.add(new JLabel("Difficulty"));

        center.add(difficultyBox);

        guessField = new JTextField();

        center.add(new JLabel("Enter Guess"));

        center.add(guessField);

        guessButton = new JButton("Guess");

        center.add(guessButton);

        attemptsLabel = new JLabel("Attempts Remaining : " + game.getRemainingAttempts());

        center.add(attemptsLabel);

        hintLabel = new JLabel("Game Ready!",SwingConstants.CENTER);

        center.add(hintLabel);

        add(center,BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout());

        scoreArea = new JTextArea(8,25);
        scoreArea.setEditable(false);

        bottom.add(new JScrollPane(scoreArea),BorderLayout.CENTER);

        playAgainButton = new JButton("Play Again");

        bottom.add(playAgainButton,BorderLayout.SOUTH);

        add(bottom,BorderLayout.SOUTH);

        guessButton.addActionListener(e -> makeGuess());

        playAgainButton.addActionListener(e -> newGame());
    }

    private void makeGuess(){

        if(game.isGameOver())
            return;

        try{

            int guess = Integer.parseInt(guessField.getText());

            String result = game.checkGuess(guess);

            hintLabel.setText(result);

            attemptsLabel.setText("Attempts Remaining : " + game.getRemainingAttempts());

            if(result.equals("Correct!")){

                scoreManager.addWin(round,game.getAttempts());

                scoreArea.setText(scoreManager.getHistory());

                round++;

            }

            if(result.startsWith("You Lost")){

                scoreManager.addLoss(round);

                scoreArea.setText(scoreManager.getHistory());

                round++;

            }

            guessField.setText("");

        }catch(Exception ex){

            JOptionPane.showMessageDialog(this,"Enter a valid number.");

        }

    }

    private void newGame(){

        String level=(String)difficultyBox.getSelectedItem();

        Difficulty diff;

        switch(level){

            case "Easy":
                diff=Difficulty.EASY;
                break;

            case "Hard":
                diff=Difficulty.HARD;
                break;

            default:
                diff=Difficulty.MEDIUM;

        }

        game.startNewGame(diff);

        attemptsLabel.setText("Attempts Remaining : " + game.getRemainingAttempts());

        hintLabel.setText("New Game Started!");

        guessField.setText("");

    }

}