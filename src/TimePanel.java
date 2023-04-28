import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class TimePanel extends JPanel {
    int timePanel_width;
    int timePanel_height;
    int timePanel_x;
    int timePanel_y;
    int fontSize;
    int fontSizeForTime;
    long elapsedTime;
    long startTime;
    JTextField timeField = new JTextField("0");
    Timer timer;
    GamePanel gamePanel;
    private final DecimalFormat df = new DecimalFormat("00");

    TimePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        timePanel_width = gamePanel.getGAME_PANEL_WIDTH() / 2;
        timePanel_height = gamePanel.getGAME_PANEL_HEIGHT() / 12;
        timePanel_x = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getPANELS_DISTANCE() * 2;
        timePanel_y = gamePanel.getGAME_PANEL_HEIGHT() - gamePanel.getPANELS_DISTANCE() * 16 + gamePanel.getPANELS_DISTANCE() / 2;

        fontSize = gamePanel.getGAME_PANEL_WIDTH() / 16;
        fontSizeForTime = gamePanel.getGAME_PANEL_WIDTH() / 12;

        //fontSize = new Font("Helvetica Neue", 0, fontSize);


        timeField.setBounds(128, 110, 95, 60);
        timeField.setHorizontalAlignment(SwingConstants.RIGHT);
        //timeField.setFont(timeFont);
        timeField.setDisabledTextColor(new Color(130, 200, 200));
        timeField.setBackground(Color.DARK_GRAY);
        timeField.setBorder(null);
        timeField.setEditable(false);
        timeField.setEnabled(false);

        this.setBackground(gamePanel.mainPanelColor);
        this.setBounds(timePanel_x, timePanel_y, timePanel_width, timePanel_height);

        timer = new Timer(100, e ->{
            if(gamePanel.isRunning()) timerUpdate();
        });
        startTime = System.currentTimeMillis();
    }

    public void timerUpdate() {
        repaint();
        elapsedTime = System.currentTimeMillis() - startTime;

        int seconds = (int) (elapsedTime / 1000) % 60;
        int minutes = (int) (elapsedTime / 60000) % 60;
        int hours = (int) (elapsedTime / 3600000);


        if (minutes == 0 && hours < 1) {
            timeField.setText(df.format(seconds));
        } else if (minutes >= 1 && hours < 1) {
            timeField.setText(minutes + ":" + df.format(seconds));
        } else if (hours >= 1) {
            if (hours == 10) {
                timer.stop();
            } else {
                timeField.setText(hours + ":" + df.format(minutes) + ":" + df.format(seconds));
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setFont(new Font("Helvetica Neue", 0, fontSize));
        g2d.setPaint(new Color(130, 200, 200));
        g2d.drawString("TIME", 0, fontSize);

        //g2d.setFont(new Font("Helvetica Neue", 0, fontSizeForLine));
        g2d.drawString(String.valueOf(gamePanel.getLine()), 0, fontSize * 2 + fontSize / 3);
    }
}
