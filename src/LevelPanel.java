import javax.swing.*;
import java.awt.*;

public class LevelPanel extends JPanel {
    GamePanel gamePanel;
    int levelPanel_width;
    int levelPanel_height;
    int levelPanel_x;
    int levelPanel_y;
    Timer timer;
    LevelPanel(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        levelPanel_width = gamePanel.getGAME_PANEL_WIDTH()/2;
        levelPanel_height = gamePanel.getGAME_PANEL_HEIGHT()/12;
        levelPanel_x = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getPANELS_DISTANCE() * 2;
        levelPanel_y = gamePanel.getGAME_PANEL_HEIGHT() - gamePanel.getPANELS_DISTANCE() * 8;

        this.setBackground(gamePanel.mainPanelColor);
        this.setBounds(levelPanel_x,levelPanel_y,levelPanel_width,levelPanel_height);

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int fontsize = gamePanel.getGAME_PANEL_WIDTH()/16;
        int fontsize1 = gamePanel.getGAME_PANEL_WIDTH()/12;
        g2d.setFont(new Font("Helvetica Neue", 0, fontsize));
        g2d.setPaint(new Color(130, 200, 200));
        g2d.drawString("LEVEL", 0,fontsize);

        g2d.setFont(new Font("Helvetica Neue", 0, fontsize1));
        g2d.drawString(String.valueOf(gamePanel.getLevel()), 0, fontsize * 2 + fontsize/3);
    }
}
