import javax.swing.*;
import java.awt.*;

public class LevelPanel extends JPanel {
    GamePanel gamePanel;
    MainPanel mainPanel;
    final String level = "LEVEL";
    int levelPanel_width;
    int levelPanel_height;
    int levelPanel_x;
    int levelPanel_y;
    int levelString_x;
    int levelString_y;
    int levelValue_x;
    int levelValue_y;
    Timer timer;
    LevelPanel(GamePanel gamePanel, MainPanel mainPanel){
        this.gamePanel = gamePanel;
        this.mainPanel = mainPanel;

        levelPanel_width = gamePanel.getGAME_PANEL_WIDTH()/2;
        levelPanel_height = gamePanel.getGAME_PANEL_HEIGHT()/12;
        levelPanel_x = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getPANELS_DISTANCE() * 2;
        levelPanel_y = gamePanel.getGAME_PANEL_HEIGHT() - gamePanel.getPANELS_DISTANCE() * 8;
        levelString_x = 0;
        levelString_y = mainPanel.getFontSizeForString();
        levelValue_x = 0;
        levelValue_y = mainPanel.getFontSizeForString() * 2 + mainPanel.getFontSizeForString() / 3;

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

        g2d.setFont(mainPanel.getFontForString());
        g2d.setPaint(mainPanel.getFontColor());
        g2d.drawString(level, levelString_x,levelString_y);

        g2d.setFont(mainPanel.getFontForValue());
        g2d.drawString(String.valueOf(gamePanel.getLevel()), levelValue_x, levelValue_y);
    }
}
