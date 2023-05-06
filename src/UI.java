import java.awt.*;
import java.util.List;

public class UI {
    GamePanel gamePanel;
    int animation = 0;
    int transparencyForHighlightBlock = 255;
    int transparencyForTSpin = 0;
    long currentTime = System.currentTimeMillis();
    long highlightTime = System.currentTimeMillis();
    long tSpinTime = System.currentTimeMillis();
    Color yellow_0, lightBlue_1, purple_2, orange_3, darkBlue_4, green_5, red_6;
    Color yellow_0_tSpin, lightBlue_1_tSpin, purple_2_tSpin, orange_3_tSpin, darkBlue_4_tSpin, green_5_tSpin, red_6_tSpin;
    Color ghostBlockColor;
    Color highlightColor;
    Color tSpinColor;
    BasicStroke defaultStroke;

    boolean tSpinComplete;

    int yellow_r = 255, yellow_g = 255, yellow_b = 255;
    int lightBlue_r = 255, lightBlue_g = 255, lightBlue_b = 255;
    int purple_r = 255, purple_g = 255, purple_b = 255;
    int orange_r = 255, orange_g = 255, orange_b = 255;
    int darkBlue_r = 255, darkBlue_g = 255, darkBlue_b = 255;
    int green_r = 255, green_g = 255, green_b = 255;
    int red_r = 255, red_g = 255, red_b = 255;


    UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        defaultStroke = new BasicStroke((float) gamePanel.getGAME_PANEL_WIDTH() / 200);


        yellow_0 = new Color(255, 215, 0);
        lightBlue_1 = new Color(0, 180, 250);
        purple_2 = new Color(160, 40, 150);
        orange_3 = new Color(255, 145, 0);
        darkBlue_4 = new Color(0, 120, 190);
        green_5 = new Color(115, 200, 55);
        red_6 = new Color(245, 5, 15);

        yellow_0_tSpin = new Color(255, 255, 255);
        lightBlue_1_tSpin = new Color(255, 255, 255);
        purple_2_tSpin = new Color(255, 255, 255);
        orange_3_tSpin = new Color(255, 255, 255);
        darkBlue_4_tSpin = new Color(255, 255, 255);
        green_5_tSpin = new Color(255, 255, 255);
        red_6_tSpin = new Color(255, 255, 255);

        ghostBlockColor = new Color(150, 150, 150);
        highlightColor = new Color(50, 50, 50, transparencyForHighlightBlock);
        tSpinColor = new Color(255, 255, 255, transparencyForTSpin);
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

            //TSPIN
//            g2d.setPaint(Color.CYAN);
//            g2d.drawRect(gamePanel.tSpin_x[i], gamePanel.tSpin_y[i], FRAME_SIZE, FRAME_SIZE);
//            g2d.setFont(new Font("Helvetica Neue", Font.PLAIN,20));
//            g2d.drawString(i==0 ? "A" : i==1 ? "B" : i==2 ? "C" : "D", gamePanel.tSpin_x[i]+13, gamePanel.tSpin_y[i]+28);
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

    public void drawAnimationForTSpin(Graphics2D g2d, int FRAME_SIZE, int[] tSpinBlock_x, int[] tSpinBlock_y) {
        tSpinColor = new Color(250, 250, 250, transparencyForTSpin);
        for (int i = 0; i < tSpinBlock_x.length; i++) {
            g2d.setPaint(tSpinColor);
            g2d.fillRect(tSpinBlock_x[i], tSpinBlock_y[i], FRAME_SIZE, FRAME_SIZE);
            g2d.setPaint(Color.BLACK);
            g2d.drawRect(tSpinBlock_x[i], tSpinBlock_y[i], FRAME_SIZE, FRAME_SIZE);
        }
        if (System.currentTimeMillis() - tSpinTime > 10) {
            tSpinTime = System.currentTimeMillis();
            transparencyForTSpin += 10;
        }
        if (transparencyForTSpin == 250) {
            gamePanel.animationForTSpin = false;
        }
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
            transparencyForHighlightBlock -= 10;
            switch (tetrisBlocks.get(0)) {
                case 0 -> highlightColor = new Color(255, 218, 0, transparencyForHighlightBlock);
                case 1 -> highlightColor = new Color(0, 181, 247, transparencyForHighlightBlock);
                case 2 -> highlightColor = new Color(161, 39, 151, transparencyForHighlightBlock);
                case 3 -> highlightColor = new Color(255, 145, 0, transparencyForHighlightBlock);
                case 4 -> highlightColor = new Color(0, 119, 191, transparencyForHighlightBlock);
                case 5 -> highlightColor = new Color(117, 199, 55, transparencyForHighlightBlock);
                case 6 -> highlightColor = new Color(244, 3, 17, transparencyForHighlightBlock);
            }
        }
    }

    public void drawBlocksForTSpin(Graphics2D g2d, int[] blocksOnBoard, int FRAME_SIZE) {
        g2d.setStroke(defaultStroke);
        int counter = 0;

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
                if (transparencyForTSpin != 255) {
                    tSpinColor = new Color(255, 255, 255, transparencyForTSpin);
                    g2d.setPaint(tSpinColor);
                } else {
                    g2d.setPaint(blocksOnBoard[i] == 0 ? yellow_0_tSpin
                            : blocksOnBoard[i] == 1 ? lightBlue_1_tSpin
                            : blocksOnBoard[i] == 2 ? purple_2_tSpin
                            : blocksOnBoard[i] == 3 ? orange_3_tSpin
                            : blocksOnBoard[i] == 4 ? darkBlue_4_tSpin
                            : blocksOnBoard[i] == 5 ? green_5_tSpin
                            : red_6_tSpin);
                }
                g2d.fillRect(x * FRAME_SIZE, y * FRAME_SIZE, FRAME_SIZE, FRAME_SIZE);
                g2d.setPaint(Color.BLACK);
                g2d.drawRect(x * FRAME_SIZE, y * FRAME_SIZE, FRAME_SIZE, FRAME_SIZE);
            }
        }

        if (System.currentTimeMillis() - tSpinTime > 5 && transparencyForTSpin != 255) {
            tSpinTime = System.currentTimeMillis();
            transparencyForTSpin += 15;
        } else if( System.currentTimeMillis() - tSpinTime > 5 && transparencyForTSpin == 255) {
            tSpinTime = System.currentTimeMillis();
            if (yellow_r != 255) yellow_r--; else counter++;
            if (yellow_g != 215) yellow_g--; else counter++;
            if (yellow_b != 0) yellow_b--; else counter++;

            if (lightBlue_r != 0) lightBlue_r--; else counter++;
            if (lightBlue_g != 180) lightBlue_g--; else counter++;
            if (lightBlue_b != 250) lightBlue_b--; else counter++;

            if (purple_r != 160) purple_r--; else counter++;
            if (purple_g != 40) purple_g--; else counter++;
            if (purple_b != 150) purple_b--; else counter++;

            if (orange_r != 255) orange_r--; else counter++;
            if (orange_g != 145) orange_g--; else counter++;
            if (orange_b != 0) orange_b--; else counter++;

            if (darkBlue_r != 0) darkBlue_r--; else counter++;
            if (darkBlue_g != 120) darkBlue_g--; else counter++;
            if (darkBlue_b != 190) darkBlue_b--; else counter++;

            if (green_r != 115) green_r--; else counter++;
            if (green_g != 200) green_g--; else counter++;
            if (green_b != 55) green_b--; else counter++;

            if (red_r >= 245) red_r--; else counter++;
            if (red_g >= 5) red_g--; else counter++;
            if (red_b >= 15) red_b--; else counter++;

             yellow_0_tSpin = new Color(yellow_r, yellow_g, yellow_b);
             lightBlue_1_tSpin = new Color(lightBlue_r, lightBlue_g, lightBlue_b);
             purple_2_tSpin = new Color(purple_r, purple_g, purple_b);
             orange_3_tSpin = new Color(orange_r, orange_g, orange_b);
             darkBlue_4_tSpin = new Color(darkBlue_r, darkBlue_g, darkBlue_b);
             green_5_tSpin = new Color(green_r, green_g, green_b);
             red_6_tSpin = new Color(red_r, red_g, red_b);

             if(counter == 21) {
                 gamePanel.animationForTSpin = false;
                 yellow_r = 255;
                 yellow_g = 255;
                 yellow_b = 255;
                 lightBlue_r = 255;
                 lightBlue_g = 255;
                 lightBlue_b = 255;
                 purple_r = 255;
                 purple_g = 255;
                 purple_b = 255;
                 orange_r = 255;
                 orange_g = 255;
                 orange_b = 255;
                 darkBlue_r = 255;
                 darkBlue_g = 255;
                 darkBlue_b = 255;
                 green_r = 255;
                 green_g = 255;
                 green_b = 255;
                 red_r = 255;
                 red_g = 255;
                 red_b = 255;
             }
        }
    }
}
//        yellow_0 = new Color(255, 215, 0);
//        lightBlue_1 = new Color(0, 180, 250);
//        purple_2 = new Color(160, 40, 150);
//        orange_3 = new Color(255, 145, 0);
//        darkBlue_4 = new Color(0, 120, 190);
//        green_5 = new Color(115, 200, 55);
//        red_6 = new Color(245, 5, 15);

