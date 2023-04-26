import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    GamePanel gamePanel;
    int scorePanel_width;
    int scorePanel_height;
    int scorePanel_x;
    int scorePanel_y;
    Timer timer;
    ScorePanel(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        scorePanel_width = gamePanel.getGAME_PANEL_WIDTH()/2;
        scorePanel_height = gamePanel.getGAME_PANEL_HEIGHT()/8;
        scorePanel_x = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getPANELS_DISTANCE() * 2;
        scorePanel_y = gamePanel.getGAME_PANEL_HEIGHT() - gamePanel.getPANELS_DISTANCE() * 4;

        this.setBackground(gamePanel.mainPanelColor);
        this.setBounds(scorePanel_x,scorePanel_y,scorePanel_width,scorePanel_height);
        this.addPropertyChangeListener(evt -> {
            revalidate();
            repaint();
        });


//        timer = new Timer(5,e -> repaint());
//        timer.start();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int fontsize = gamePanel.getGAME_PANEL_WIDTH()/16;
        int fontsize1 = gamePanel.getGAME_PANEL_WIDTH()/8;
        g2d.setFont(new Font("Helvetica Neue", 0, fontsize));
        g2d.setPaint(new Color(130, 200, 200));
        g2d.drawString("SCORE", 0,fontsize);

        g2d.setFont(new Font("Helvetica Neue", 0, fontsize1));
        g2d.drawString(String.valueOf(gamePanel.getScore()), 0, fontsize * 3 - fontsize/4);
    }
}
