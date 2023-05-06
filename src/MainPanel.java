import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private final GamePanel gamePanel;
    private final ScorePanel scorePanel;
    private final NextBlockPanel nextBlockPanel;
    private final LevelPanel levelPanel;
    private final LinePanel linePanel;
    private final TimePanel timePanel;
    boolean animationForScore;
    long timeForScore;
    private final int MAIN_PANEL_WIDTH;
    private final int MAIN_PANEL_HEIGHT;
    private final int rectangle_x;
    private final int rectangle_y;
    private final int rectangle_width;
    private final int rectangle_height;
    private final int fontSizeForString;
    private final int fontSizeForValue;
    private final int fontSizeForScore;
    private int scoreTransparency = 250;
    int score_x;
    int score_y;
    int animation = 0;
    String score;
    private final Font fontForString;
    private final Font fontForValue;
    private final Font fontForScore;
    private final Color fontColor = new Color(130, 200, 200);
    private final Color rectangleColor = new Color(170, 170, 170);
    Color scoreColor = new Color(0, 240, 0, scoreTransparency);
    private final BasicStroke rectangleStroke;
    private final Timer timer;

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

        score_x = MAIN_PANEL_WIDTH - MAIN_PANEL_WIDTH/3;
        score_y = MAIN_PANEL_HEIGHT - MAIN_PANEL_HEIGHT/2 + MAIN_PANEL_HEIGHT/14;

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

        animationForScore = false;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(rectangleColor);
        g2d.setStroke(rectangleStroke);
        g2d.drawRect(gamePanel.rectangle_x, gamePanel.rectangle_y, gamePanel.rectangle_width, gamePanel.rectangle_height);
        g2d.setPaint(gamePanel.mainPanelColor);
        g2d.drawLine(gamePanel.rectangle_x, gamePanel.rectangle_y, gamePanel.rectangle_width + gamePanel.rectangle_width / 16, gamePanel.rectangle_y);

        if(gamePanel.animationForScoreString){
            setScore();
        }

        if (animationForScore) {
            scoreColor = new Color(0, 240, 0, scoreTransparency);
            g2d.setFont(fontForValue);
            g2d.setPaint(scoreColor);

            g2d.drawString(score, score_x, score_y + animation);
            if (System.currentTimeMillis() - timeForScore > 7) {
                timeForScore = System.currentTimeMillis();
                animation--;
                if (animation < -25) {
                    if (scoreTransparency > 0) scoreTransparency -= 10;
                    else animationForScore = false;
                }
            }
        }
    }
    public void setScore(){
        score = "+" + gamePanel.scoreForAnimation;
        animationForScore = true;
        animation = 0;
        scoreTransparency = 250;
        gamePanel.animationForScoreString = false;
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

    public void setAnimationForScore(boolean animationForScore) {
        this.animationForScore = animationForScore;
    }

    public void setScoreTransparency(int scoreTransparency) {
        this.scoreTransparency = scoreTransparency;
    }

    public void setAnimation(int animation) {
        this.animation = animation;
    }
}
