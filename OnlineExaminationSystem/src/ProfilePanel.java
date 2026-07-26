import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {

    private MainFrame mainFrame;

    private JLabel lblName;
    private JLabel lblRegNo;
    private JLabel lblQuestions;
    private JLabel lblDuration;

    private JButton btnStart;

    public ProfilePanel(MainFrame mainFrame) {

        this.mainFrame = mainFrame;

        initializeUI();
    }

    private void initializeUI() {

        setLayout(new BorderLayout());
        setBackground(new Color(240,248,255));

        // ==========================
        // Title
        // ==========================

        JLabel title = new JLabel(
                "Student Profile",
                SwingConstants.CENTER);

        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));

        add(title, BorderLayout.NORTH);

        // ==========================
        // Center Panel
        // ==========================

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        lblName = new JLabel();
        lblRegNo = new JLabel();
        lblQuestions = new JLabel("Total Questions : 10");
        lblDuration = new JLabel("Duration : 10 Minutes");

        lblName.setFont(new Font("Arial", Font.PLAIN,18));
        lblRegNo.setFont(new Font("Arial", Font.PLAIN,18));
        lblQuestions.setFont(new Font("Arial", Font.PLAIN,18));
        lblDuration.setFont(new Font("Arial", Font.PLAIN,18));

        JLabel instructionTitle = new JLabel("Instructions");
        instructionTitle.setFont(new Font("Arial", Font.BOLD,20));

        JTextArea instructions = new JTextArea();

        instructions.setText(
                "• Read all questions carefully.\n\n"
              + "• Each question carries 1 mark.\n\n"
              + "• There is no negative marking.\n\n"
              + "• Use Previous and Next buttons to navigate.\n\n"
              + "• Click Submit to finish the exam.\n\n"
              + "• If the timer reaches zero, your exam\n"
              + "  will be submitted automatically."
        );

        instructions.setEditable(false);
        instructions.setBackground(Color.WHITE);
        instructions.setFont(new Font("Arial", Font.PLAIN,16));
        instructions.setLineWrap(true);
        instructions.setWrapStyleWord(true);

        btnStart = new JButton("Start Examination");
        btnStart.setFont(new Font("Arial", Font.BOLD,18));
        btnStart.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(lblName);
        panel.add(Box.createVerticalStrut(10));

        panel.add(lblRegNo);
        panel.add(Box.createVerticalStrut(10));

        panel.add(lblQuestions);
        panel.add(Box.createVerticalStrut(10));

        panel.add(lblDuration);
        panel.add(Box.createVerticalStrut(20));

        panel.add(instructionTitle);
        panel.add(Box.createVerticalStrut(10));

        panel.add(instructions);
        panel.add(Box.createVerticalStrut(20));

        panel.add(btnStart);

        add(panel, BorderLayout.CENTER);

        // ==========================
        // Button Event
        // ==========================

        btnStart.addActionListener(e -> {

            int option = JOptionPane.showConfirmDialog(
                    this,
                    "Start the examination?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION
            );

            if(option == JOptionPane.YES_OPTION){

                mainFrame.startExam();

            }

        });

    }

    // ==========================
    // Load Logged-in User
    // ==========================

    public void loadUser(User user){

        lblName.setText(
                "Student Name : " + user.getName());

        lblRegNo.setText(
                "Register Number : " + user.getRegisterNumber());

    }

}