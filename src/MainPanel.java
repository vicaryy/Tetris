import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private int MAIN_PANEL_WIDTH;
    private int MAIN_PANEL_HEIGHT;
    Frame frame;
    GamePanel gamePanel;
    InterfacePanel interfacePanel;

    MainPanel(Frame frame, GamePanel gamePanel, InterfacePanel interfacePanel) {
        this.frame = frame;
        this.gamePanel = gamePanel;
        this.interfacePanel = interfacePanel;

        MAIN_PANEL_WIDTH = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getGAME_PANEL_WIDTH() / 2 + gamePanel.getPANELS_DISTANCE() * 3;
        MAIN_PANEL_HEIGHT = gamePanel.getGAME_PANEL_HEIGHT() + gamePanel.getPANELS_DISTANCE() * 2;

        this.setPreferredSize(new Dimension(MAIN_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
        this.setLayout(null);
        this.setBackground(frame.getFrameColor());
        this.add(gamePanel);
        this.add(interfacePanel);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new Color(170, 170, 170));
        g2d.setStroke(new BasicStroke(gamePanel.getGAME_PANEL_WIDTH() / 100));
        g2d.drawRect(gamePanel.getPANELS_DISTANCE() - 2, gamePanel.getPANELS_DISTANCE() - 2, gamePanel.getGAME_PANEL_WIDTH() + 4, gamePanel.getGAME_PANEL_HEIGHT() + 4);
        g2d.drawRect(gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getPANELS_DISTANCE() * 2 - 2, gamePanel.getPANELS_DISTANCE() * 8 - 2, interfacePanel.getINTERFACE_PANEL_WIDTH() + 4, interfacePanel.getINTERFACE_PANEL_HEIGHT() + 4);
    }
}
