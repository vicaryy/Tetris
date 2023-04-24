import java.awt.*;
import java.util.List;

public class UI {
    GamePanel gamePanel;
    int animation = 0;
    long currentTime = System.currentTimeMillis();

    UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void drawMobileBlock(Graphics2D g2d, int[] block_x, int[] block_y) {
        g2d.setStroke(new BasicStroke(2));
        for (int i = 0; i < block_x.length; i++) {
            g2d.setPaint(Color.RED);
            g2d.fillRect(block_x[i], block_y[i], gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE());
            g2d.setPaint(Color.BLACK);
            g2d.drawRect(block_x[i], block_y[i], gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE());
        }
        g2d.setPaint(null);
    }

    public void drawNet(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(1));
        g2d.setPaint(new Color(70, 70, 70));
        for (int i = gamePanel.getFRAME_SIZE(); i < gamePanel.getGAME_PANEL_HEIGHT(); i += gamePanel.getFRAME_SIZE()) {
            g2d.drawLine(i, 0, i, gamePanel.getGAME_PANEL_HEIGHT());
            g2d.drawLine(0, i, gamePanel.getGAME_PANEL_WIDTH(), i);
        }
    }

    public void drawInvisibleBlock(Graphics2D g2d, int[] invisibleBlock_x, int[] invisibleBlock_y) {
        g2d.setStroke(new BasicStroke(2));
        g2d.setPaint(new Color(150, 150, 150));
        for (int i = 0; i < invisibleBlock_y.length; i++) {
            g2d.drawRect(invisibleBlock_x[i], invisibleBlock_y[i], gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE());
        }
    }

    public void drawBoardBlock(Graphics2D g2d, boolean[] boardBlocks) {
        g2d.setStroke(new BasicStroke(2));
        for (int i = 0; i < boardBlocks.length; i++) {
            if (boardBlocks[i]) {
                int x;
                int y;
                if (i > 9) {
                    x = i % 10;
                    y = i / 10;
                } else {
                    y = 0;
                    x = i;
                }
                g2d.setPaint(Color.RED);
                g2d.fillRect(x * gamePanel.getFRAME_SIZE(), y * gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE());
                g2d.setPaint(Color.BLACK);
                g2d.drawRect(x * gamePanel.getFRAME_SIZE(), y * gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE());
            }
        }
    }

    public void drawAnimationForTetris(Graphics2D g2d, List<Integer> tetrisRows) {
        g2d.setPaint(gamePanel.backgroundColor);

        for (int i = 0; i < tetrisRows.size(); i++) {
            g2d.fillRect((gamePanel.getGAME_PANEL_WIDTH() / 2) - animation, tetrisRows.get(i) * gamePanel.getFRAME_SIZE(), animation * 2, gamePanel.getFRAME_SIZE());
        }

        if (System.currentTimeMillis() - currentTime > 80) {
            animation += gamePanel.getFRAME_SIZE();
            currentTime = System.currentTimeMillis();
            if (tetrisRows.size() == 4 && (animation == gamePanel.getFRAME_SIZE() || animation == gamePanel.getFRAME_SIZE() * 3 || animation == gamePanel.getFRAME_SIZE() * 5))
                gamePanel.backgroundColor = new Color(230, 230, 230);
            else
                gamePanel.backgroundColor = new Color(10, 20, 20);
        }
        if (animation > gamePanel.getGAME_PANEL_WIDTH() / 2)
            gamePanel.resettingAfterTetris();
        gamePanel.setBackground(gamePanel.backgroundColor);
    }
}
