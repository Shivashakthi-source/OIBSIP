import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    private LoginPanel loginPanel;
    private ProfilePanel profilePanel;
    private ExamPanel examPanel;
    private ResultPanel resultPanel;

    private ExamManager examManager;
    private User currentUser;

    public MainFrame() {

        setTitle("Online Examination System");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        examManager = new ExamManager();

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        loginPanel = new LoginPanel(this);
        profilePanel = new ProfilePanel(this);
        examPanel = new ExamPanel(this);
        resultPanel = new ResultPanel(this);

        cardPanel.add(loginPanel, "LOGIN");
        cardPanel.add(profilePanel, "PROFILE");
        cardPanel.add(examPanel, "EXAM");
        cardPanel.add(resultPanel, "RESULT");

        add(cardPanel);

        showLogin();

        setVisible(true);
    }

    // Navigation

    public void showLogin() {
        cardLayout.show(cardPanel, "LOGIN");
    }

    public void showProfile() {
        profilePanel.loadUser(currentUser);
        cardLayout.show(cardPanel, "PROFILE");
    }

    public void startExam() {

        examManager.resetExam();

        examPanel.startExam();

        cardLayout.show(cardPanel, "EXAM");
    }

    public void showResult() {

        int score = examManager.calculateScore();

        resultPanel.showResult(
                score,
                examManager.getTotalQuestions()
        );

        cardLayout.show(cardPanel, "RESULT");
    }

    // Getters

    public ExamManager getExamManager() {
        return examManager;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    // Called after successful login

    public void login(User user) {
        currentUser = user;
        showProfile();
    }

}