import javax.swing.*;
import java.awt.*;

public class LevelPanel extends JPanel {
    GamePanel gamePanel;
    int levelPanel_width;
    int levelPanel_height;
    int levelPanel_x;
    int levelPanel_y;
    int fontSize;
    int fontSizeForLevel;
    Timer timer;
    LevelPanel(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        levelPanel_width = gamePanel.getGAME_PANEL_WIDTH()/2;
        levelPanel_height = gamePanel.getGAME_PANEL_HEIGHT()/12;
        levelPanel_x = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getPANELS_DISTANCE() * 2;
        levelPanel_y = gamePanel.getGAME_PANEL_HEIGHT() - gamePanel.getPANELS_DISTANCE() * 8;

        fontSize = gamePanel.getGAME_PANEL_WIDTH()/16;
        fontSizeForLevel = gamePanel.getGAME_PANEL_WIDTH()/12;

        this.setBackground(gamePanel.mainPanelColor);
        this.setBounds(levelPanel_x,levelPanel_y,levelPanel_width,levelPanel_height);

        timer = new Timer(100, e ->{
            if(gamePanel.isRunning()) repaint();
        });
        timer.start();

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setFont(new Font("Helvetica Neue", 0, fontSize));
        g2d.setPaint(new Color(130, 200, 200));
        g2d.drawString("LEVEL", 0,fontSize);

        g2d.setFont(new Font("Helvetica Neue", 0, fontSizeForLevel));
        g2d.drawString(String.valueOf(gamePanel.getLevel()), 0, fontSize * 2 + fontSize/3);
    }
}
