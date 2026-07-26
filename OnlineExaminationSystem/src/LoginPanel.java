import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private MainFrame mainFrame;

    private JTextField txtUsername;
    private JPasswordField txtPassword;

    // Demo Users
    private User[] users;

    public LoginPanel(MainFrame mainFrame) {

        this.mainFrame = mainFrame;

        users = new User[]{
                new User("student1", "1234", "Shivashakthi", "IT24001"),
                new User("student2", "1234", "Rahul", "IT24002"),
                new User("student3", "1234", "Priya", "IT24003")
        };

        initializeUI();
    }

    private void initializeUI() {

        setLayout(new BorderLayout());
        setBackground(new Color(240, 248, 255));

        //---------------------------
        // Title
        //---------------------------

        JLabel lblTitle = new JLabel(
                "ONLINE EXAMINATION SYSTEM",
                SwingConstants.CENTER);

        lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));

        add(lblTitle, BorderLayout.NORTH);

        //---------------------------
        // Login Panel
        //---------------------------

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblUser = new JLabel("Username");
        lblUser.setFont(new Font("Arial", Font.PLAIN,16));

        JLabel lblPass = new JLabel("Password");
        lblPass.setFont(new Font("Arial", Font.PLAIN,16));

        txtUsername = new JTextField(20);
        txtUsername.setFont(new Font("Arial", Font.PLAIN,16));

        txtPassword = new JPasswordField(20);
        txtPassword.setFont(new Font("Arial", Font.PLAIN,16));

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Arial", Font.BOLD,16));

        gbc.gridx=0;
        gbc.gridy=0;
        form.add(lblUser,gbc);

        gbc.gridx=1;
        form.add(txtUsername,gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        form.add(lblPass,gbc);

        gbc.gridx=1;
        form.add(txtPassword,gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=2;

        form.add(btnLogin,gbc);

        add(form,BorderLayout.CENTER);

        //---------------------------
        // Footer
        //---------------------------

        JLabel footer = new JLabel(
                "Demo Login : student1 / 1234",
                SwingConstants.CENTER);

        footer.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));

        add(footer,BorderLayout.SOUTH);

        //---------------------------
        // Button Action
        //---------------------------

        btnLogin.addActionListener(e -> login());

    }

    //====================================

    private void login() {

        String username = txtUsername.getText().trim();

        String password = String.valueOf(txtPassword.getPassword());

        for(User user : users){

            if(user.validate(username,password)){

                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful!"
                );

                mainFrame.login(user);

                return;
            }

        }

        JOptionPane.showMessageDialog(
                this,
                "Invalid Username or Password",
                "Login Failed",
                JOptionPane.ERROR_MESSAGE
        );

    }

}