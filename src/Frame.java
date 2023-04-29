import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private final Color frameColor = new Color(24, 23, 23);
    private final GamePanel gamePanel;
    private final MainPanel mainPanel;


    Frame() {

        gamePanel = new GamePanel();
        mainPanel = new MainPanel(gamePanel);

        //FRAME
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            this.getRootPane().putClientProperty("apple.awt.transparentTitleBar", true);
        }
        this.setDefaultCloseOperation(3);
        this.setBackground(frameColor);
        this.setResizable(false);
        this.add(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public Color getFrameColor() {
        return frameColor;
    }
}
