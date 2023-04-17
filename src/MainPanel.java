import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    Frame frame;
    GamePanel gamePanel;
    InterfacePanel interfacePanel;
    MainPanel(Frame frame, GamePanel gamePanel, InterfacePanel interfacePanel){
        this.frame = frame;
        this.gamePanel = gamePanel;
        this.interfacePanel = interfacePanel;

        this.setPreferredSize(new Dimension(800,900));
        this.setLayout(null);
        this.setBackground(frame.getFrameColor());
        this.add(gamePanel);
        this.add(interfacePanel);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new Color(170,170,170));
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRect(18,18,403,803);
    }

}
