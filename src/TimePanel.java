import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class TimePanel extends JPanel {
    GamePanel gamePanel;
    MainPanel mainPanel;
    final String time = "TIME";
    int timePanel_width;
    int timePanel_height;
    int timePanel_x;
    int timePanel_y;
    int seconds;
    int minutes;
    int hours;
    int timeString_x;
    int timeString_y;
    long elapsedTime;
    long startTime;
    JTextField timeField = new JTextField("0:00");
    Timer timer;
    final DecimalFormat df = new DecimalFormat("00");

    TimePanel(GamePanel gamePanel, MainPanel mainPanel) {
        this.gamePanel = gamePanel;
        this.mainPanel = mainPanel;

        timePanel_width = gamePanel.getGAME_PANEL_WIDTH() / 2;
        timePanel_height = gamePanel.getGAME_PANEL_HEIGHT() / 12;
        timePanel_x = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getPANELS_DISTANCE() * 2;
        timePanel_y = gamePanel.getGAME_PANEL_HEIGHT() - gamePanel.getPANELS_DISTANCE() * 16 + gamePanel.getPANELS_DISTANCE();
        timeString_x = 0;
        timeString_y = mainPanel.getFontSizeForString();

        timeField.setHorizontalAlignment(SwingConstants.LEFT);
        timeField.setFont(mainPanel.getFontForValue());
        timeField.setDisabledTextColor(new Color(130, 200, 200));
        timeField.setBackground(gamePanel.mainPanelColor);
        timeField.setBorder(null);
        timeField.setEditable(false);
        timeField.setEnabled(false);
        timeField.setBounds(0, mainPanel.getFontSizeForString(), timePanel_width, mainPanel.getFontSizeForString() * 2 - mainPanel.getFontSizeForString() / 3);

        this.setBackground(gamePanel.mainPanelColor);
        this.setBounds(timePanel_x, timePanel_y, timePanel_width, timePanel_height);
        this.setLayout(null);
        this.add(timeField);

        timer = new Timer(1000, e ->{
            if(gamePanel.isRunning()) timerUpdate();
        });
        startTime = System.currentTimeMillis();
        timer.start();
    }

    public void timerUpdate() {
        elapsedTime = System.currentTimeMillis() - startTime;

        seconds = (int) (elapsedTime / 1000) % 60;
        minutes = (int) (elapsedTime / 60000) % 60;
        hours = (int) (elapsedTime / 3600000);

        if (hours < 1) {
            timeField.setText(minutes + ":" + df.format(seconds));
        } else {
            if (hours == 10) {
                timer.stop();
            } else {
                timeField.setText(hours + ":" + df.format(minutes) + ":" + df.format(seconds));
            }
        }
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setFont(mainPanel.getFontForString());
        g2d.setPaint(mainPanel.getFontColor());
        g2d.drawString(time, timeString_x, timeString_y);
    }
}
