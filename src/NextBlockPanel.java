import javax.swing.*;
import java.awt.*;

public class NextBlockPanel extends JPanel {
    int[] nextBlock_x = new int[4];
    int[] nextBlock_y = new int[4];
    int nextBlockPanel_width;
    int nextBlockPanel_height;
    int nextBlockPanel_x;
    int nextBlockPanel_y;
    GamePanel gamePanel;
    Timer timer;

    NextBlockPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        nextBlockPanel_width = gamePanel.getGAME_PANEL_WIDTH() / 2;
        nextBlockPanel_height = gamePanel.getGAME_PANEL_HEIGHT() / 3;
        nextBlockPanel_x = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getPANELS_DISTANCE() * 2;
        nextBlockPanel_y = gamePanel.getPANELS_DISTANCE();

        this.setBackground(gamePanel.mainPanelColor);
        this.setBounds(nextBlockPanel_x, nextBlockPanel_y, nextBlockPanel_width, nextBlockPanel_height);

        timer = new Timer(100, e -> {
            repaint();
            settingNextBlockCords();

        });
        timer.start();
    }

    void settingNextBlockCords() {
        switch (gamePanel.getTypeOfBlocks()[1]) {
            case 0 -> {
                // = = = =
                //
                //
                //
                nextBlock_x[0] = gamePanel.getFRAME_SIZE() * 1 - (gamePanel.getFRAME_SIZE() / 4) * 2;
                nextBlock_x[1] = gamePanel.getFRAME_SIZE() * 2 - (gamePanel.getFRAME_SIZE() / 4) * 2;
                nextBlock_x[2] = gamePanel.getFRAME_SIZE() * 3 - (gamePanel.getFRAME_SIZE() / 4) * 2;
                nextBlock_x[3] = gamePanel.getFRAME_SIZE() * 4 - (gamePanel.getFRAME_SIZE() / 4) * 2;

                nextBlock_y[0] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_y[1] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_y[2] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_y[3] = gamePanel.getFRAME_SIZE() * 2;
            }
            case 1 -> {
                // =
                // = = =
                //
                //
                nextBlock_x[0] = gamePanel.getFRAME_SIZE() * 1;
                nextBlock_x[1] = gamePanel.getFRAME_SIZE() * 1;
                nextBlock_x[2] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[3] = gamePanel.getFRAME_SIZE() * 3;

                nextBlock_y[0] = gamePanel.getFRAME_SIZE() * 1 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[1] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[2] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[3] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
            }
            case 2 -> {
                //     =
                // = = =
                //
                //
                nextBlock_x[0] = gamePanel.getFRAME_SIZE() * 3;
                nextBlock_x[1] = gamePanel.getFRAME_SIZE() * 3;
                nextBlock_x[2] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[3] = gamePanel.getFRAME_SIZE() * 1;

                nextBlock_y[0] = gamePanel.getFRAME_SIZE() * 1 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[1] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[2] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[3] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
            }
            case 3 -> {
                // = =
                // = =
                //
                //
                nextBlock_x[0] = gamePanel.getFRAME_SIZE() * 2 - gamePanel.getFRAME_SIZE() / 2;
                nextBlock_x[1] = gamePanel.getFRAME_SIZE() * 2 - gamePanel.getFRAME_SIZE() / 2;
                nextBlock_x[2] = gamePanel.getFRAME_SIZE() * 3 - gamePanel.getFRAME_SIZE() / 2;
                nextBlock_x[3] = gamePanel.getFRAME_SIZE() * 3 - gamePanel.getFRAME_SIZE() / 2;

                nextBlock_y[0] = gamePanel.getFRAME_SIZE() * 1 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[1] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[2] = gamePanel.getFRAME_SIZE() * 1 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[3] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
            }
            case 4 -> {
                //   = =
                // + =
                //
                //
                nextBlock_x[0] = gamePanel.getFRAME_SIZE() * 1;
                nextBlock_x[1] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[2] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[3] = gamePanel.getFRAME_SIZE() * 3;

                nextBlock_y[0] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[1] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[2] = gamePanel.getFRAME_SIZE() * 1 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[3] = gamePanel.getFRAME_SIZE() * 1 + gamePanel.getFRAME_SIZE()/2;
            }
            case 5 -> {
                //   =
                // = = 4
                //
                //
                nextBlock_x[0] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[1] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[2] = gamePanel.getFRAME_SIZE() * 1;
                nextBlock_x[3] = gamePanel.getFRAME_SIZE() * 3;

                nextBlock_y[0] = gamePanel.getFRAME_SIZE() * 1 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[1] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[2] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[3] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
            }
            case 6 -> {
                // = =
                //   + =
                //
                //
                nextBlock_x[0] = gamePanel.getFRAME_SIZE() * 3;
                nextBlock_x[1] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[2] = gamePanel.getFRAME_SIZE() * 2;
                nextBlock_x[3] = gamePanel.getFRAME_SIZE() * 1;

                nextBlock_y[0] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[1] = gamePanel.getFRAME_SIZE() * 2 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[2] = gamePanel.getFRAME_SIZE() * 1 + gamePanel.getFRAME_SIZE()/2;
                nextBlock_y[3] = gamePanel.getFRAME_SIZE() * 1 + gamePanel.getFRAME_SIZE()/2;
            }
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(gamePanel.getGAME_PANEL_WIDTH() / 200));
        for (int i = 0; i < nextBlock_x.length; i++) {
            g2d.setPaint(Color.RED);
            g2d.fillRect(nextBlock_x[i], nextBlock_y[i], gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE());
            g2d.setPaint(Color.BLACK);
            g2d.drawRect(nextBlock_x[i], nextBlock_y[i], gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE());
        }
        g2d.setPaint(new Color(130, 200, 200));
        int fontsize = gamePanel.getGAME_PANEL_WIDTH()/16;
        g2d.setFont(new Font("Helvetica Neue", 0, fontsize));
        g2d.drawString("NEXT", 0, fontsize);
    }
}
