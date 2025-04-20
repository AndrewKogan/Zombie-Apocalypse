import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel{
    private JPanel MainPanel;
    private JButton startButton;
    private JButton quitButton;

    public MainMenu() {
        this.setPreferredSize(new Dimension(600, 600));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GamePanel gamePanel = new GamePanel();

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
