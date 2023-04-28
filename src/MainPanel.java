import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private int MAIN_PANEL_WIDTH;
    private int MAIN_PANEL_HEIGHT;
    private int rectangle_x;
    private int rectangle_y;
    private int rectangle_width;
    private int rectangle_height;
    GamePanel gamePanel;
    ScorePanel scorePanel;
    NextBlockPanel nextBlockPanel;
    LevelPanel levelPanel;
    LinePanel linePanel;
    TimePanel timePanel;
    Color rectangleColor = new Color(170, 170, 170);
    BasicStroke rectangleStroke;
    Timer timer;

    MainPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        scorePanel = new ScorePanel(gamePanel);
        levelPanel = new LevelPanel(gamePanel);
        linePanel = new LinePanel(gamePanel);
        timePanel = new TimePanel(gamePanel);
        nextBlockPanel = new NextBlockPanel(gamePanel);

        MAIN_PANEL_WIDTH = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getGAME_PANEL_WIDTH() / 2 + gamePanel.getPANELS_DISTANCE() * 3;
        MAIN_PANEL_HEIGHT = gamePanel.getGAME_PANEL_HEIGHT() + gamePanel.getPANELS_DISTANCE() * 2;

        rectangle_x = gamePanel.getPANELS_DISTANCE() - 2;
        rectangle_y = gamePanel.getPANELS_DISTANCE() - 2;
        rectangle_width = gamePanel.getGAME_PANEL_WIDTH() + 4;
        rectangle_height = gamePanel.getGAME_PANEL_HEIGHT() + 4;

        rectangleStroke = new BasicStroke(gamePanel.getGAME_PANEL_WIDTH() / 100);

        this.setPreferredSize(new Dimension(MAIN_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
        this.setLayout(null);
        this.setBackground(gamePanel.mainPanelColor);
        this.add(gamePanel);
        this.add(scorePanel);
        this.add(nextBlockPanel);
        this.add(levelPanel);
        this.add(linePanel);
        this.add(timePanel);

        timer = new Timer(5, e ->{
            if(gamePanel.isRunning()) repaint();
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(rectangleColor);
        g2d.setStroke(rectangleStroke);
        g2d.drawRect(gamePanel.rectangle_x, gamePanel.rectangle_y, gamePanel.rectangle_width, gamePanel.rectangle_height);
    }
}
