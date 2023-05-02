import javax.swing.*;
import java.awt.*;

public class NextBlockPanel extends JPanel {
    private final GamePanel gamePanel;
    private final MainPanel mainPanel;
    private final UI ui;
    private final String next = "NEXT";
    private int[] nextBlock_x = new int[4];
    private int[] nextBlock_y = new int[4];
    private int nextBlockPanel_width;
    private int nextBlockPanel_height;
    private int nextBlockPanel_x;
    private int nextBlockPanel_y;
    private int nextString_x;
    private int nextString_y;
    private Timer timer;

    NextBlockPanel(GamePanel gamePanel, MainPanel mainPanel) {
        this.gamePanel = gamePanel;
        this.mainPanel = mainPanel;

        ui = new UI(gamePanel);

        nextBlockPanel_width = gamePanel.getGAME_PANEL_WIDTH() / 2;
        nextBlockPanel_height = gamePanel.getGAME_PANEL_HEIGHT() / 3;
        nextBlockPanel_x = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getPANELS_DISTANCE() * 2;
        nextBlockPanel_y = gamePanel.getPANELS_DISTANCE();
        nextString_x = 0;
        nextString_y = mainPanel.getFontSizeForString();

        this.setBackground(gamePanel.mainPanelColor);
        this.setBounds(nextBlockPanel_x, nextBlockPanel_y, nextBlockPanel_width, nextBlockPanel_height);

        timer = new Timer(100, e -> {
            if(gamePanel.isRunning()) {
                repaint();
                settingNextBlockCords();
            }
        });
        timer.start();
    }

    void settingNextBlockCords() {
        switch (gamePanel.getTetrisBlocks().get(1)) {
            case 0 -> {
                // = =
                // = =
                //
                //
                nextBlock_x[0] = gamePanel.getFRAME_SIZE() * 2 - gamePanel.getFRAME_SIZE() / 2;
                nextBlock_x[1] = gamePanel.getFRAME_SIZE() * 2 - gamePanel.getFRAME_SIZE() / 2;
                nextBlock_x[2] = gamePanel.getFRAME_SIZE() * 3 - gamePanel.getFRAME_SIZE() / 2;
                nextBlock_x[3] = gamePanel.getFRAME_SIZE() * 3 - gamePanel.getFRAME_SIZE() / 2;

                nextBlock_y[0] = gamePanel.getFRAME_SIZE() + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[1] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[2] = gamePanel.getFRAME_SIZE() + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[3] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
            }
            case 1 -> {
                // = = = =
                //
                //
                //
                nextBlock_x[0] = gamePanel.getFRAME_SIZE() - (gamePanel.getFRAME_SIZE() / 4) * 2;
                nextBlock_x[1] = gamePanel.getFRAME_SIZE() * 2 - (gamePanel.getFRAME_SIZE() / 4) * 2;
                nextBlock_x[2] = gamePanel.getFRAME_SIZE() * 3 - (gamePanel.getFRAME_SIZE() / 4) * 2;
                nextBlock_x[3] = gamePanel.getFRAME_SIZE() * 4 - (gamePanel.getFRAME_SIZE() / 4) * 2;

                nextBlock_y[0] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_y[1] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_y[2] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_y[3] = gamePanel.getFRAME_SIZE() * 2;
            }
            case 2 -> {
                //   =
                // = = 4
                //
                //
                nextBlock_x[0] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[1] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[2] = gamePanel.getFRAME_SIZE();
                nextBlock_x[3] = gamePanel.getFRAME_SIZE() * 3;

                nextBlock_y[0] = gamePanel.getFRAME_SIZE() + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[1] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[2] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[3] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
            }
            case 3 -> {
                //     =
                // = = =
                //
                //
                nextBlock_x[0] = gamePanel.getFRAME_SIZE() * 3;
                nextBlock_x[1] = gamePanel.getFRAME_SIZE() * 3;
                nextBlock_x[2] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[3] = gamePanel.getFRAME_SIZE();

                nextBlock_y[0] = gamePanel.getFRAME_SIZE() + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[1] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[2] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[3] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
            }
            case 4 -> {
                // =
                // = = =
                //
                //
                nextBlock_x[0] = gamePanel.getFRAME_SIZE();
                nextBlock_x[1] = gamePanel.getFRAME_SIZE();
                nextBlock_x[2] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[3] = gamePanel.getFRAME_SIZE() * 3;

                nextBlock_y[0] = gamePanel.getFRAME_SIZE() + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[1] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[2] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[3] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
            }
            case 5 -> {
                //   = =
                // + =
                //
                //
                nextBlock_x[0] = gamePanel.getFRAME_SIZE();
                nextBlock_x[1] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[2] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[3] = gamePanel.getFRAME_SIZE() * 3;

                nextBlock_y[0] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[1] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[2] = gamePanel.getFRAME_SIZE() + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[3] = gamePanel.getFRAME_SIZE() + gamePanel.getFRAME_SIZE()/2;
            }
            case 6 -> {
                // = =
                //   + =
                //
                //
                nextBlock_x[0] = gamePanel.getFRAME_SIZE() * 3;
                nextBlock_x[1] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[2] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[3] = gamePanel.getFRAME_SIZE();

                nextBlock_y[0] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[1] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[2] = gamePanel.getFRAME_SIZE() + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[3] = gamePanel.getFRAME_SIZE() + gamePanel.getFRAME_SIZE()/2;
            }
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        ui.drawNextBlock(g2d, nextBlock_x, nextBlock_y, gamePanel.getTetrisBlocks());

        g2d.setPaint(new Color(130, 200, 200));
        g2d.setFont(mainPanel.getFontForString());
        g2d.drawString(next, nextString_x, nextString_y);
    }
}
