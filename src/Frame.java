import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private final Color frameColor = new Color(24,23,23);
    private final GamePanel gamePanel = new GamePanel();
    private final InterfacePanel interfacePanel = new InterfacePanel();
    private final MainPanel mainPanel = new MainPanel(this, gamePanel, interfacePanel);

    Frame(){
        //FRAME
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("mac")) {
            this.getRootPane().putClientProperty("apple.awt.transparentTitleBar", true);
        }
        this.setDefaultCloseOperation(3);
        this.setBackground(frameColor);
        this.setResizable(true);
        this.add(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public Color getFrameColor() {
        return frameColor;
    }
}
