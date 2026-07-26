import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {

    private MainFrame mainFrame;

    private JLabel lblScore;
    private JLabel lblCorrect;
    private JLabel lblWrong;
    private JLabel lblUnanswered;

    public ResultPanel(MainFrame mainFrame) {

        this.mainFrame = mainFrame;

        initializeUI();

    }

    private void initializeUI() {

        setLayout(new BorderLayout());
        setBackground(new Color(240,248,255));

        JLabel title = new JLabel(
                "EXAM RESULT",
                SwingConstants.CENTER);

        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        add(title, BorderLayout.NORTH);

        JPanel center = new JPanel();
        center.setBackground(Color.WHITE);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(30,40,30,40));

        lblScore = new JLabel();
        lblCorrect = new JLabel();
        lblWrong = new JLabel();
        lblUnanswered = new JLabel();

        Font font = new Font("Arial", Font.PLAIN, 20);

        lblScore.setFont(font);
        lblCorrect.setFont(font);
        lblWrong.setFont(font);
        lblUnanswered.setFont(font);

        center.add(lblScore);
        center.add(Box.createVerticalStrut(20));

        center.add(lblCorrect);
        center.add(Box.createVerticalStrut(20));

        center.add(lblWrong);
        center.add(Box.createVerticalStrut(20));

        center.add(lblUnanswered);
        center.add(Box.createVerticalStrut(30));

        JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Arial", Font.BOLD, 18));
        btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);

        center.add(btnLogout);

        add(center, BorderLayout.CENTER);

        btnLogout.addActionListener(e -> {

            mainFrame.showLogin();

        });

    }

    public void showResult(int score, int total) {

        ExamManager manager = mainFrame.getExamManager();

        lblScore.setText("Score : " + score + " / " + total);

        lblCorrect.setText(
                "Correct Answers : "
                + manager.getCorrectAnswers());

        lblWrong.setText(
                "Wrong Answers : "
                + manager.getWrongAnswers());

        lblUnanswered.setText(
                "Unanswered : "
                + manager.getUnansweredQuestions());

    }

}