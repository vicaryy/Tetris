import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    GamePanel gamePanel;
    MainPanel mainPanel;
    final String score = "SCORE";
    int scorePanel_width;
    int scorePanel_height;
    int scorePanel_x;
    int scorePanel_y;
    int score_x;
    int score_y;
    Timer timer;


    ScorePanel(GamePanel gamePanel, MainPanel mainPanel) {
        this.gamePanel = gamePanel;
        this.mainPanel = mainPanel;

        scorePanel_width = gamePanel.getGAME_PANEL_WIDTH() / 2;
        scorePanel_height = gamePanel.getGAME_PANEL_HEIGHT() / 8;
        scorePanel_x = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getPANELS_DISTANCE() * 2;
        scorePanel_y = gamePanel.getGAME_PANEL_HEIGHT() - gamePanel.getPANELS_DISTANCE() * 4;
        score_x = 0;
        score_y = mainPanel.getFontSizeForString() * 3 - mainPanel.getFontSizeForString() / 5;

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

        g2d.setPaint(mainPanel.getFontColor());
        g2d.setFont(mainPanel.getFontForString());
        g2d.drawString(score, score_x, mainPanel.getFontSizeForString());

        g2d.setFont(mainPanel.getFontForScore());
        g2d.drawString(String.valueOf(gamePanel.getScore()), score_x, score_y);
    }
}