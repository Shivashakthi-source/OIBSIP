import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {

        setTitle("🎯 Number Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new GamePanel());

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}