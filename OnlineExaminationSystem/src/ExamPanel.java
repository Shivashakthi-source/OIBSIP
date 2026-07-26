import javax.swing.*;
import java.awt.*;

public class ExamPanel extends JPanel {

    private MainFrame mainFrame;
    private ExamManager examManager;

    private JLabel lblQuestionNo;
    private JLabel lblTimer;

    private JTextArea txtQuestion;

    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JRadioButton rb4;

    private ButtonGroup buttonGroup;

    private JButton btnPrevious;
    private JButton btnNext;
    private JButton btnSubmit;

    private Timer timer;
    private int timeLeft = 600; // 10 Minutes

    public ExamPanel(MainFrame mainFrame) {

        this.mainFrame = mainFrame;
        this.examManager = mainFrame.getExamManager();

        initializeUI();
    }

    private void initializeUI() {

        setLayout(new BorderLayout(15,15));
        setBackground(new Color(240,248,255));

        //------------------------
        // Top Panel
        //------------------------

        JPanel topPanel = new JPanel(new BorderLayout());

        lblQuestionNo = new JLabel("Question 1");
        lblQuestionNo.setFont(new Font("Arial",Font.BOLD,22));

        lblTimer = new JLabel("10:00");
        lblTimer.setForeground(Color.RED);
        lblTimer.setFont(new Font("Arial",Font.BOLD,22));

        topPanel.add(lblQuestionNo,BorderLayout.WEST);
        topPanel.add(lblTimer,BorderLayout.EAST);

        add(topPanel,BorderLayout.NORTH);

        //------------------------
        // Center Panel
        //------------------------

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
        center.setBackground(Color.WHITE);
        center.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        txtQuestion = new JTextArea();
        txtQuestion.setEditable(false);
        txtQuestion.setBackground(Color.WHITE);
        txtQuestion.setLineWrap(true);
        txtQuestion.setWrapStyleWord(true);
        txtQuestion.setFont(new Font("Arial",Font.BOLD,18));

        rb1 = new JRadioButton();
        rb2 = new JRadioButton();
        rb3 = new JRadioButton();
        rb4 = new JRadioButton();

        rb1.setBackground(Color.WHITE);
        rb2.setBackground(Color.WHITE);
        rb3.setBackground(Color.WHITE);
        rb4.setBackground(Color.WHITE);

        rb1.setFont(new Font("Arial",Font.PLAIN,17));
        rb2.setFont(new Font("Arial",Font.PLAIN,17));
        rb3.setFont(new Font("Arial",Font.PLAIN,17));
        rb4.setFont(new Font("Arial",Font.PLAIN,17));

        buttonGroup = new ButtonGroup();

        buttonGroup.add(rb1);
        buttonGroup.add(rb2);
        buttonGroup.add(rb3);
        buttonGroup.add(rb4);

        center.add(txtQuestion);
        center.add(Box.createVerticalStrut(20));

        center.add(rb1);
        center.add(Box.createVerticalStrut(10));

        center.add(rb2);
        center.add(Box.createVerticalStrut(10));

        center.add(rb3);
        center.add(Box.createVerticalStrut(10));

        center.add(rb4);

        add(center,BorderLayout.CENTER);

        //------------------------
        // Bottom Panel
        //------------------------

        JPanel bottom = new JPanel();

        btnPrevious = new JButton("Previous");
        btnNext = new JButton("Next");
        btnSubmit = new JButton("Submit");

        btnPrevious.setFont(new Font("Arial",Font.BOLD,16));
        btnNext.setFont(new Font("Arial",Font.BOLD,16));
        btnSubmit.setFont(new Font("Arial",Font.BOLD,16));

        bottom.add(btnPrevious);
        bottom.add(btnNext);
        bottom.add(btnSubmit);

        add(bottom,BorderLayout.SOUTH);

        registerEvents();
    }
            // =========================================
    // Start Exam
    // =========================================

    public void startExam() {

        examManager.resetExam();

        timeLeft = 600;

        startTimer();

        loadQuestion();
    }

    // =========================================
    // Timer
    // =========================================

    private void startTimer() {

        if (timer != null) {
            timer.stop();
        }

        timer = new Timer(1000, e -> {

            timeLeft--;

            int minutes = timeLeft / 60;
            int seconds = timeLeft % 60;

            lblTimer.setText(String.format("%02d:%02d", minutes, seconds));

            if (timeLeft <= 0) {

                timer.stop();

                JOptionPane.showMessageDialog(
                        this,
                        "Time is over!\nExam Submitted Automatically."
                );

                mainFrame.showResult();
            }

        });

        timer.start();
    }

    // =========================================
    // Load Question
    // =========================================

    private void loadQuestion() {

        Question q = examManager.getCurrentQuestion();

        lblQuestionNo.setText(
                "Question "
                + (examManager.getCurrentQuestionIndex() + 1)
                + " / "
                + examManager.getTotalQuestions());

        txtQuestion.setText(q.getQuestion());

        String[] options = q.getOptions();

        rb1.setText(options[0]);
        rb2.setText(options[1]);
        rb3.setText(options[2]);
        rb4.setText(options[3]);

        buttonGroup.clearSelection();

        int answer = examManager.getSavedAnswer();

        switch (answer) {

            case 0:
                rb1.setSelected(true);
                break;

            case 1:
                rb2.setSelected(true);
                break;

            case 2:
                rb3.setSelected(true);
                break;

            case 3:
                rb4.setSelected(true);
                break;

        }

        btnPrevious.setEnabled(
                !examManager.isFirstQuestion());

        btnNext.setEnabled(
                !examManager.isLastQuestion());

    }

    // =========================================
    // Save Current Answer
    // =========================================

    private void saveAnswer() {

        int answer = -1;

        if (rb1.isSelected())
            answer = 0;

        else if (rb2.isSelected())
            answer = 1;

        else if (rb3.isSelected())
            answer = 2;

        else if (rb4.isSelected())
            answer = 3;

        examManager.saveAnswer(answer);

    }
        // =========================================
    // Register Button Events
    // =========================================

    private void registerEvents() {

        // Previous Button
        btnPrevious.addActionListener(e -> {

            saveAnswer();

            examManager.previousQuestion();

            loadQuestion();

        });

        // Next Button
        btnNext.addActionListener(e -> {

            saveAnswer();

            examManager.nextQuestion();

            loadQuestion();

        });

        // Submit Button
        btnSubmit.addActionListener(e -> {

            saveAnswer();

            int option = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to submit the exam?",
                    "Submit Exam",
                    JOptionPane.YES_NO_OPTION
            );

            if (option == JOptionPane.YES_OPTION) {

                if (timer != null) {
                    timer.stop();
                }

                mainFrame.showResult();

            }

        });

    }
        // =========================================
    // Stop Timer
    // =========================================

    public void stopTimer() {

        if (timer != null) {
            timer.stop();
        }

    }

}
