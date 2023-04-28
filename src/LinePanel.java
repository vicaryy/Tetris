import javax.swing.*;
import java.awt.*;

public class LinePanel extends JPanel {
    GamePanel gamePanel;
    int linePanel_width;
    int linePanel_height;
    int linePanel_x;
    int linePanel_y;
    int fontSize;
    int fontSizeForLine;
    Timer timer;
    LinePanel(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        linePanel_width = gamePanel.getGAME_PANEL_WIDTH()/2;
        linePanel_height = gamePanel.getGAME_PANEL_HEIGHT()/12;
        linePanel_x = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getPANELS_DISTANCE() * 2;
        linePanel_y = gamePanel.getGAME_PANEL_HEIGHT() - gamePanel.getPANELS_DISTANCE() * 12 + gamePanel.getPANELS_DISTANCE()/2;

        fontSize = gamePanel.getGAME_PANEL_WIDTH()/16;
        fontSizeForLine = gamePanel.getGAME_PANEL_WIDTH()/12;

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

        g2d.setFont(new Font("Helvetica Neue", 0, fontSize));
        g2d.setPaint(new Color(130, 200, 200));
        g2d.drawString("LINE", 0,fontSize);

        g2d.setFont(new Font("Helvetica Neue", 0, fontSizeForLine));
        g2d.drawString(String.valueOf(gamePanel.getLine()), 0, fontSize * 2 + fontSize/3);
    }
}
