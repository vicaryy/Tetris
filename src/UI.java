import java.awt.*;

public class UI {
    GamePanel gamePanel;
    UI(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void drawMobileBlock(Graphics2D g2d, int[] block_x, int[] block_y){
        g2d.setStroke(new BasicStroke(3));
        for(int i = 0; i < block_x.length; i++){
            g2d.setPaint(Color.BLACK);
            g2d.drawRect(block_x[i], block_y[i], gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE());
            g2d.setPaint(Color.RED);
            g2d.fillRect(block_x[i], block_y[i], gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE());
        }
    }

    public void drawNet(Graphics2D g2d){
        g2d.setStroke(new BasicStroke(1));
        g2d.setPaint(new Color(70,70,70));
        for(int i = gamePanel.getFRAME_SIZE(); i < gamePanel.getGAME_PANEL_HEIGHT(); i += gamePanel.getFRAME_SIZE()){
            g2d.drawLine(i, 0, i, gamePanel.getGAME_PANEL_HEIGHT());
            g2d.drawLine(0, i, gamePanel.getGAME_PANEL_WIDTH(), i);
        }
    }

    public void drawBoardBlock(Graphics2D g2d, boolean[] boardBlocks){
        for (int i = 0; i < boardBlocks.length; i++) {
            if (boardBlocks[i]) {
                int x;
                int y;
                if (i > 9) {
                    x = i % 10;
                    y = i / 10;
                }
                else {
                    y = 0;
                    x = i;
                }
                g2d.setPaint(Color.BLACK);
                g2d.drawRect(x * gamePanel.getFRAME_SIZE(), y * gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE());
                g2d.setPaint(Color.RED);
                g2d.fillRect(x * gamePanel.getFRAME_SIZE(), y * gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE());
            }
        }
    }
}
