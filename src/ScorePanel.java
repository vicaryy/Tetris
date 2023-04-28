import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    GamePanel gamePanel;
    int scorePanel_width;
    int scorePanel_height;
    int scorePanel_x;
    int scorePanel_y;
    int fontSize;
    int fontSizeForScore;
    Timer timer;
    Font timeFont;


    ScorePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        scorePanel_width = gamePanel.getGAME_PANEL_WIDTH() / 2;
        scorePanel_height = gamePanel.getGAME_PANEL_HEIGHT() / 8;
        scorePanel_x = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getPANELS_DISTANCE() * 2;
        scorePanel_y = gamePanel.getGAME_PANEL_HEIGHT() - gamePanel.getPANELS_DISTANCE() * 4;

        fontSize = gamePanel.getGAME_PANEL_WIDTH() / 16;
        fontSizeForScore = gamePanel.getGAME_PANEL_WIDTH() / 8;

        timeFont = new Font("Helvetica Neue", 0, fontSize);


        this.setBackground(gamePanel.mainPanelColor);
        this.setBounds(scorePanel_x, scorePanel_y, scorePanel_width, scorePanel_height);

        timer = new Timer(50, e -> {
            if (gamePanel.isRunning()) repaint();
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;


        g2d.setFont(new Font("Helvetica Neue", 0, fontSize));
        g2d.setPaint(new Color(130, 200, 200));
        g2d.drawString("SCORE", 0, fontSize);

        g2d.setFont(new Font("Helvetica Neue", 0, fontSizeForScore));
        g2d.drawString(String.valueOf(gamePanel.getScore()), 0, fontSize * 3 - fontSize / 5);
    }
}