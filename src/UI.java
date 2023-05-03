import java.awt.*;
import java.util.List;

public class UI {
    GamePanel gamePanel;
    int animation = 0;
    int transparency = 200;
    long currentTime = System.currentTimeMillis();
    long highlightTime = System.currentTimeMillis();
    Color lightBlue_1;
    Color darkBlue_4;
    Color orange_3;
    Color yellow_0;
    Color green_5;
    Color purple_2;
    Color red_6;
    Color ghostBlockColor;
    Color highlightColor;
    BasicStroke defaultStroke;


    UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        defaultStroke = new BasicStroke((float) gamePanel.getGAME_PANEL_WIDTH() / 200);

        /*
        0 - LIGHT BLUE: (173, 216, 230)
        1 - DARK BLUE: (0, 0, 139)
        2 - ORANGE: (255, 165, 0)
        3 - YELLOW: (255, 255, 0)
        4 - GREEN: (0, 128, 0)
        5 - PURPLE: (128, 0, 128)
        6 - RED: (255, 0, 0)
         */

        yellow_0 = new Color(255, 218, 0);
        lightBlue_1 = new Color(0, 181, 247);
        purple_2 = new Color(161, 39, 151);
        orange_3 = new Color(255, 145, 0);
        darkBlue_4 = new Color(0, 119, 191);
        green_5 = new Color(117, 199, 55);
        red_6 = new Color(244, 3, 17);
        ghostBlockColor = new Color(150, 150, 150);
        highlightColor = new Color(50, 50, 50, transparency);
    }

    public void drawMobileBlock(Graphics2D g2d, int[] mobileBlock_x, int[] mobileBlock_y, int FRAME_SIZE, List<Integer> tetrisBlocks) {
        g2d.setStroke(defaultStroke);
        for (int i = 0; i < mobileBlock_x.length; i++) {
            g2d.setPaint(tetrisBlocks.get(0) == 0 ? yellow_0
                    : tetrisBlocks.get(0) == 1 ? lightBlue_1
                    : tetrisBlocks.get(0) == 2 ? purple_2
                    : tetrisBlocks.get(0) == 3 ? orange_3
                    : tetrisBlocks.get(0) == 4 ? darkBlue_4
                    : tetrisBlocks.get(0) == 5 ? green_5
                    : red_6);

            if (gamePanel.isHighlightBlock()) {
                g2d.setPaint(highlightColor);
            }
            g2d.fillRect(mobileBlock_x[i], mobileBlock_y[i], FRAME_SIZE, FRAME_SIZE);
            g2d.setPaint(Color.BLACK);
            g2d.drawRect(mobileBlock_x[i], mobileBlock_y[i], FRAME_SIZE, FRAME_SIZE);
        }
    }

    public void drawNet(Graphics2D g2d) {
        g2d.setStroke(defaultStroke);
        g2d.setPaint(new Color(70, 70, 70));
        for (int i = gamePanel.getFRAME_SIZE(); i < gamePanel.getGAME_PANEL_HEIGHT(); i += gamePanel.getFRAME_SIZE()) {
            g2d.drawLine(i, 0, i, gamePanel.getGAME_PANEL_HEIGHT());
            g2d.drawLine(0, i, gamePanel.getGAME_PANEL_WIDTH(), i);
        }
    }

    public void drawGhostBlock(Graphics2D g2d, int[] ghostBlock_x, int[] ghostBlock_y, int FRAME_SIZE) {
        g2d.setStroke(defaultStroke);
        g2d.setPaint(ghostBlockColor);
        for (int i = 0; i < ghostBlock_y.length; i++) {
            g2d.drawRect(ghostBlock_x[i], ghostBlock_y[i], FRAME_SIZE, FRAME_SIZE);
        }
    }

    public void drawBlocksOnBoard(Graphics2D g2d, int[] blocksOnBoard, int FRAME_SIZE) {
        g2d.setStroke(defaultStroke);

        for (int i = 0; i < blocksOnBoard.length; i++) {
            if (blocksOnBoard[i] != -1) {
                int x;
                int y;
                if (i > 9) {
                    x = i % 10;
                    y = i / 10;
                } else {
                    y = 0;
                    x = i;
                }

                g2d.setPaint(blocksOnBoard[i] == 0 ? yellow_0
                        : blocksOnBoard[i] == 1 ? lightBlue_1
                        : blocksOnBoard[i] == 2 ? purple_2
                        : blocksOnBoard[i] == 3 ? orange_3
                        : blocksOnBoard[i] == 4 ? darkBlue_4
                        : blocksOnBoard[i] == 5 ? green_5
                        : red_6);

                g2d.fillRect(x * FRAME_SIZE, y * FRAME_SIZE, FRAME_SIZE, FRAME_SIZE);
                g2d.setPaint(Color.BLACK);
                g2d.drawRect(x * FRAME_SIZE, y * FRAME_SIZE, FRAME_SIZE, FRAME_SIZE);
            }
        }
    }

    public void drawAnimationForTetris(Graphics2D g2d, List<Integer> tetrisRows, int GAME_PANEL_WIDTH, int FRAME_SIZE) {
        gamePanel.backgroundColor = tetrisRows.size() == 4 && (animation == FRAME_SIZE || animation == FRAME_SIZE * 3 || animation == FRAME_SIZE * 5) ? new Color(230, 230, 230) : new Color(10, 20, 20);
        gamePanel.setBackground(gamePanel.backgroundColor);
        g2d.setPaint(gamePanel.backgroundColor);

        for (int i = 0; i < tetrisRows.size(); i++) {
            g2d.fillRect((GAME_PANEL_WIDTH / 2) - animation, tetrisRows.get(i) * FRAME_SIZE, animation * 2, FRAME_SIZE);
        }

        if (System.currentTimeMillis() - currentTime > 100) {
            animation += FRAME_SIZE;
            currentTime = System.currentTimeMillis();
        }

        if (animation > (GAME_PANEL_WIDTH / 2) + FRAME_SIZE)
            gamePanel.resettingAfterTetris();
    }

    public void drawNextBlock(Graphics2D g2d, int[] nextBlock_x, int[] nextBlock_y, List<Integer> tetrisBlocks) {
        g2d.setStroke(defaultStroke);
        for (int i = 0; i < nextBlock_x.length; i++) {
            g2d.setPaint(tetrisBlocks.get(1) == 0 ? yellow_0
                    : tetrisBlocks.get(1) == 1 ? lightBlue_1
                    : tetrisBlocks.get(1) == 2 ? purple_2
                    : tetrisBlocks.get(1) == 3 ? orange_3
                    : tetrisBlocks.get(1) == 4 ? darkBlue_4
                    : tetrisBlocks.get(1) == 5 ? green_5
                    : red_6);

            g2d.fillRect(nextBlock_x[i], nextBlock_y[i], gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE());
            g2d.setPaint(Color.BLACK);
            g2d.drawRect(nextBlock_x[i], nextBlock_y[i], gamePanel.getFRAME_SIZE(), gamePanel.getFRAME_SIZE());
        }
    }

    public void drawHighlightMobileBlock(Graphics2D g2d, int[] mobileBlock_x, int[] mobileBlock_y, int FRAME_SIZE, List<Integer> tetrisBlocks) {
        if (System.currentTimeMillis() - highlightTime > gamePanel.getGameSpeed() / 25) {
            highlightTime = System.currentTimeMillis();
            transparency -= 10;
            switch (tetrisBlocks.get(0)) {
                case 0 -> highlightColor = new Color(255, 218, 0, transparency);
                case 1 -> highlightColor = new Color(0, 181, 247, transparency);
                case 2 -> highlightColor = new Color(161, 39, 151, transparency);
                case 3 -> highlightColor = new Color(255, 145, 0, transparency);
                case 4 -> highlightColor = new Color(0, 119, 191, transparency);
                case 5 -> highlightColor = new Color(117, 199, 55, transparency);
                case 6 -> highlightColor = new Color(244, 3, 17, transparency);
            }
        }
    }
}
