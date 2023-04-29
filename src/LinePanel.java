import javax.swing.*;
import java.awt.*;

public class LinePanel extends JPanel {
    GamePanel gamePanel;
    MainPanel mainPanel;
    final String line = "LINE";
    int linePanel_width;
    int linePanel_height;
    int linePanel_x;
    int linePanel_y;
    int lineString_x;
    int lineString_y;
    int lineValue_x;
    int lineValue_y;
    Timer timer;
    LinePanel(GamePanel gamePanel, MainPanel mainPanel){
        this.gamePanel = gamePanel;
        this.mainPanel = mainPanel;

        linePanel_width = gamePanel.getGAME_PANEL_WIDTH()/2;
        linePanel_height = gamePanel.getGAME_PANEL_HEIGHT()/12;
        linePanel_x = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getPANELS_DISTANCE() * 2;
        linePanel_y = gamePanel.getGAME_PANEL_HEIGHT() - gamePanel.getPANELS_DISTANCE() * 12 + gamePanel.getPANELS_DISTANCE()/2;
        lineString_x = 0;
        lineString_y = mainPanel.getFontSizeForString();
        lineValue_x = 0;
        lineValue_y = mainPanel.getFontSizeForString() * 2 + mainPanel.getFontSizeForString() / 3;

        this.setBackground(gamePanel.mainPanelColor);
        this.setBounds(linePanel_x, linePanel_y, linePanel_width, linePanel_height);

        timer = new Timer(100, e ->{
            if(gamePanel.isRunning()) repaint();
        });
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(mainPanel.getFontColor());

        g2d.setFont(mainPanel.getFontForString());
        g2d.drawString(line, lineString_x, lineString_y);

        g2d.setFont(mainPanel.getFontForValue());
        g2d.drawString(String.valueOf(gamePanel.getLine()), lineValue_x, lineValue_y);
    }
}
