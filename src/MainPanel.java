import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private final GamePanel gamePanel;
    private final ScorePanel scorePanel;
    private final NextBlockPanel nextBlockPanel;
    private final LevelPanel levelPanel;
    private final LinePanel linePanel;
    private final TimePanel timePanel;
    private int MAIN_PANEL_WIDTH;
    private int MAIN_PANEL_HEIGHT;
    private int rectangle_x;
    private int rectangle_y;
    private int rectangle_width;
    private int rectangle_height;
    private int fontSizeForString;
    private int fontSizeForValue;
    private int fontSizeForScore;
    private Font fontForString;
    private Font fontForValue;
    private Font fontForScore;
    private final Color fontColor = new Color(130, 200, 200);
    private final Color rectangleColor = new Color(170, 170, 170);
    private BasicStroke rectangleStroke;
    private Timer timer;

    MainPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        MAIN_PANEL_WIDTH = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getGAME_PANEL_WIDTH() / 2 + gamePanel.getPANELS_DISTANCE() * 3;
        MAIN_PANEL_HEIGHT = gamePanel.getGAME_PANEL_HEIGHT() + gamePanel.getPANELS_DISTANCE() * 2;

        rectangle_x = gamePanel.getPANELS_DISTANCE() - 2;
        rectangle_y = gamePanel.getPANELS_DISTANCE() - 2;
        rectangle_width = gamePanel.getGAME_PANEL_WIDTH() + 4;
        rectangle_height = gamePanel.getGAME_PANEL_HEIGHT() + 4;

        rectangleStroke = new BasicStroke(gamePanel.getGAME_PANEL_WIDTH() / 100);

        fontSizeForString = gamePanel.getGAME_PANEL_WIDTH() / 16;
        fontSizeForValue = gamePanel.getGAME_PANEL_WIDTH() / 12;
        fontSizeForScore = gamePanel.getGAME_PANEL_WIDTH() / 8;

        fontForString = new Font("Helvetica Neue", Font.PLAIN, fontSizeForString);
        fontForValue = new Font("Helvetica Neue", Font.PLAIN, fontSizeForValue);
        fontForScore = new Font("Helvetica Neue", Font.PLAIN, fontSizeForScore);

        scorePanel = new ScorePanel(gamePanel, this);
        levelPanel = new LevelPanel(gamePanel, this);
        linePanel = new LinePanel(gamePanel, this);
        timePanel = new TimePanel(gamePanel, this);
        nextBlockPanel = new NextBlockPanel(gamePanel, this);

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

    public int getFontSizeForString() {
        return fontSizeForString;
    }

    public int getFontSizeForValue() {
        return fontSizeForValue;
    }

    public int getFontSizeForScore() {
        return fontSizeForScore;
    }

    public Font getFontForString() {
        return fontForString;
    }

    public Font getFontForValue() {
        return fontForValue;
    }

    public Font getFontForScore() {
        return fontForScore;
    }

    public Color getFontColor() {
        return fontColor;
    }
}
