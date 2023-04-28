import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GamePanel extends JPanel implements ActionListener {
    private UI ui;
    private Blocks blocks;
    private KeyboardListener keyboardListener;
    private MainPanel mainPanel;
    private NextBlockPanel nextBlockPanel;
    private ScorePanel scorePanel;
    private LevelPanel levelPanel;
    private LinePanel linePanel;
    private TimePanel timePanel;
    private AdditionalFeatures additionalFeatures;
    private int GAME_PANEL_WIDTH = 400;
    private final int GAME_PANEL_HEIGHT = GAME_PANEL_WIDTH * 2;
    private final int FRAME_AMOUNT = 400;
    private final int FRAME_SIZE = GAME_PANEL_WIDTH / 10;
    private final int PANELS_DISTANCE = GAME_PANEL_WIDTH / 20;
    private int PANELS_DISTANCE_X = GAME_PANEL_WIDTH / 20;
    private int PANELS_DISTANCE_Y = GAME_PANEL_WIDTH / 20;
    private int [] typeOfBlocks = {-1,-1};
    private int typeOfBlockDirection = 0;
    private int score;
    private int level;
    private int line;
    private double gameSpeed = 1000;
    private long currentTime;
    int[] block_x = new int[4];
    int[] block_y = new int[4];
    int[] invisibleBlock_x = new int[4];
    int[] invisibleBlock_y = new int[4];
    private final boolean[] boardBlocks = new boolean[FRAME_AMOUNT];
    private boolean isRunning;
    private boolean collision;
    boolean pauseForTetris;
    boolean pushRightWall;
    boolean pushLeftWall;
    boolean pushBottomWall;
    boolean pushBottomWallForTetris;
    int rectangle_x = PANELS_DISTANCE - 2;
    int rectangle_y = PANELS_DISTANCE - 2;
    int rectangle_width = GAME_PANEL_WIDTH + 4;
    int rectangle_height = GAME_PANEL_HEIGHT + 4;
    List<Integer> tetrisBlocks = new ArrayList<>();
    List<Integer> tetrisRows = new ArrayList<>();
    Color backgroundColor = new Color(10, 20, 20);
    Color mainPanelColor = new Color(24,23,23);
    Timer timer;


    GamePanel() {
        ui = new UI(this);
        blocks = new Blocks(this);
        keyboardListener = new KeyboardListener(this);
        nextBlockPanel = new NextBlockPanel(this);
        mainPanel = new MainPanel(this);
        scorePanel = new ScorePanel(this);
        levelPanel = new LevelPanel(this);
        linePanel = new LinePanel(this);
        additionalFeatures = new AdditionalFeatures(this, mainPanel);

        //        boardBlocks[190] = true;
//        boardBlocks[191] = true;
//        boardBlocks[192] = true;
//        boardBlocks[193] = true;
//        boardBlocks[194] = true;
//        boardBlocks[195] = true;
//        boardBlocks[196] = true;
//        boardBlocks[197] = true;
//        boardBlocks[198] = true;
//
//        boardBlocks[182] = true;
//        boardBlocks[183] = true;
//        boardBlocks[184] = true;
//
//        boardBlocks[170] = true;
//        boardBlocks[171] = true;
//        boardBlocks[172] = true;
//        boardBlocks[173] = true;
//        boardBlocks[174] = true;
//        boardBlocks[175] = true;
//        boardBlocks[176] = true;
//        boardBlocks[177] = true;
//        boardBlocks[178] = true;
//
//        boardBlocks[160] = true;
//        boardBlocks[161] = true;
//        boardBlocks[162] = true;
//        boardBlocks[163] = true;
//        boardBlocks[164] = true;
//        boardBlocks[165] = true;
//        boardBlocks[166] = true;
//        boardBlocks[167] = true;
//        boardBlocks[168] = true;


        this.setBackground(backgroundColor);
        this.setBounds(PANELS_DISTANCE_X, PANELS_DISTANCE_Y, GAME_PANEL_WIDTH, GAME_PANEL_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(keyboardListener);

        timer = new Timer(5, this);
        startGame();
    }

    void startGame() {
        newBlock();
        currentTime = System.currentTimeMillis();
        checkingLevelAndSpeed();
        timer.start();
        isRunning = true;
    }


    void collisionToRightWall(boolean upKey) {
        for (int i = 0; i < block_x.length; i++) {
            if (block_x[i] == GAME_PANEL_WIDTH) {
                for (int k = 0; k < block_x.length; k++) {
                    block_x[k] -= FRAME_SIZE;
                    if (typeOfBlocks[0] == 0 && typeOfBlockDirection == 0 && upKey) {
                        block_x[k] -= FRAME_SIZE;
                    }
                }
                pushRightWall = true;
                break;
            }
        }
    }

    void collisionToLeftWall(boolean upKey) {
        for (int i = 0; i < block_x.length; i++) {
            if (block_x[i] == -FRAME_SIZE) {
                for (int k = 0; k < block_x.length; k++) {
                    block_x[k] += FRAME_SIZE;
                    if (typeOfBlocks[0] == 0 && typeOfBlockDirection == 2 && upKey) {
                        block_x[k] += FRAME_SIZE;
                    }
                }
                pushLeftWall = true;
                break;
            }
        }
    }

    void collisionToDownWall(boolean upKey) {
        for (int j : block_y) {
            if (j == GAME_PANEL_HEIGHT) {
                collision = true;
                addBlockToBoard();
                newBlock();
                break;
            }
        }
    }

    void collisionForInvisibleBlock() {
        for (int i = 0; i < block_y.length; i++) {
            invisibleBlock_x[i] = block_x[i];
            invisibleBlock_y[i] = block_y[i];
        }

        boolean invisibleBlockCollision = false;
        do {

            for (int i = 0; i < block_y.length; i++) {
                if (invisibleBlock_y[i] == GAME_PANEL_HEIGHT) {
                    invisibleBlockCollision = true;
                    break;
                }
            }

            if (!invisibleBlockCollision) {
                int x1 = ((invisibleBlock_y[0] * 10) + invisibleBlock_x[0]) / FRAME_SIZE;
                int x2 = ((invisibleBlock_y[1] * 10) + invisibleBlock_x[1]) / FRAME_SIZE;
                int x3 = ((invisibleBlock_y[2] * 10) + invisibleBlock_x[2]) / FRAME_SIZE;
                int x4 = ((invisibleBlock_y[3] * 10) + invisibleBlock_x[3]) / FRAME_SIZE;
                if (boardBlocks[x1]
                        || boardBlocks[x2]
                        || boardBlocks[x3]
                        || boardBlocks[x4]) {
                    invisibleBlockCollision = true;
                }
            }

            for (int i = 0; i < block_y.length; i++) {
                invisibleBlock_y[i] += FRAME_SIZE;
            }

        } while (!invisibleBlockCollision);

        for (int i = 0; i < block_y.length; i++) {
            invisibleBlock_y[i] -= FRAME_SIZE * 2;
        }
    }

    void collisionToDownWallWhenSwitching() {
        for (int i = 0; i < block_y.length; i++) {
            if (block_y[i] == GAME_PANEL_HEIGHT) {
                for (int k = 0; k < block_y.length; k++) {
                    block_y[k] -= FRAME_SIZE;
                    if (typeOfBlocks[0] == 0 && typeOfBlockDirection == 1) {
                        block_y[k] -= FRAME_SIZE;
                    }
                }
            }
        }
    }

    void collisionWithBlocksOnBoardToRight(boolean upKey) {
        int x1 = ((block_y[0] * 10) + block_x[0]) / FRAME_SIZE;
        int x2 = ((block_y[1] * 10) + block_x[1]) / FRAME_SIZE;
        int x3 = ((block_y[2] * 10) + block_x[2]) / FRAME_SIZE;
        int x4 = ((block_y[3] * 10) + block_x[3]) / FRAME_SIZE;
        if (boardBlocks[x1]
                || boardBlocks[x2]
                || boardBlocks[x3]
                || boardBlocks[x4]) {
            for (int i = 0; i < block_x.length; i++) {
                block_x[i] -= FRAME_SIZE;
                if (typeOfBlocks[0] == 0 && typeOfBlockDirection == 0 && upKey) {
                    block_x[i] -= FRAME_SIZE;
                }
            }
        }
    }

    void collisionWithBlocksOnBoardToLeft(boolean upKey) {
        int x1 = ((block_y[0] * 10) + block_x[0]) / FRAME_SIZE;
        int x2 = ((block_y[1] * 10) + block_x[1]) / FRAME_SIZE;
        int x3 = ((block_y[2] * 10) + block_x[2]) / FRAME_SIZE;
        int x4 = ((block_y[3] * 10) + block_x[3]) / FRAME_SIZE;
        if (boardBlocks[x1]
                || boardBlocks[x2]
                || boardBlocks[x3]
                || boardBlocks[x4]) {
            for (int i = 0; i < block_x.length; i++) {
                block_x[i] += FRAME_SIZE;
                if (typeOfBlocks[0] == 0 && typeOfBlockDirection == 2 && upKey) {
                    block_x[i] += FRAME_SIZE;
                }
            }
        }
    }

    void collisionWithBlocksOnBoardWhenSwitching() {
        int x1 = ((block_y[0] * 10) + block_x[0]) / FRAME_SIZE;
        int x2 = ((block_y[1] * 10) + block_x[1]) / FRAME_SIZE;
        int x3 = ((block_y[2] * 10) + block_x[2]) / FRAME_SIZE;
        int x4 = ((block_y[3] * 10) + block_x[3]) / FRAME_SIZE;
        if (boardBlocks[x1]
                || boardBlocks[x2]
                || boardBlocks[x3]
                || boardBlocks[x4]) {
            for (int i = 0; i < block_x.length; i++) {
                block_x[i] -= FRAME_SIZE;
            }


            x1 = ((block_y[0] * 10) + block_x[0]) / FRAME_SIZE;
            x2 = ((block_y[1] * 10) + block_x[1]) / FRAME_SIZE;
            x3 = ((block_y[2] * 10) + block_x[2]) / FRAME_SIZE;
            x4 = ((block_y[3] * 10) + block_x[3]) / FRAME_SIZE;
            if (boardBlocks[x1]
                    || boardBlocks[x2]
                    || boardBlocks[x3]
                    || boardBlocks[x4]) {
                for (int i = 0; i < block_x.length; i++) {
                    block_x[i] += FRAME_SIZE * 2;
                }


                x1 = ((block_y[0] * 10) + block_x[0]) / FRAME_SIZE;
                x2 = ((block_y[1] * 10) + block_x[1]) / FRAME_SIZE;
                x3 = ((block_y[2] * 10) + block_x[2]) / FRAME_SIZE;
                x4 = ((block_y[3] * 10) + block_x[3]) / FRAME_SIZE;
                if (boardBlocks[x1]
                        || boardBlocks[x2]
                        || boardBlocks[x3]
                        || boardBlocks[x4]) {
                    for (int i = 0; i < block_x.length; i++) {
                        block_x[i] -= FRAME_SIZE;
                        block_y[i] -= FRAME_SIZE;
                    }


                    x1 = ((block_y[0] * 10) + block_x[0]) / FRAME_SIZE;
                    x2 = ((block_y[1] * 10) + block_x[1]) / FRAME_SIZE;
                    x3 = ((block_y[2] * 10) + block_x[2]) / FRAME_SIZE;
                    x4 = ((block_y[3] * 10) + block_x[3]) / FRAME_SIZE;
                    if (boardBlocks[x1]
                            || boardBlocks[x2]
                            || boardBlocks[x3]
                            || boardBlocks[x4]) {
                        for (int i = 0; i < block_x.length; i++) {
                            block_y[i] += FRAME_SIZE;
                            if (i != 0) switchBlockDirection();
                        }
                    }
                }
            }
        }
    }

    void collisionWithBlocksOnBoard() {
        int y1 = ((block_y[0] * 10) + block_x[0]) / FRAME_SIZE;
        int y2 = ((block_y[1] * 10) + block_x[1]) / FRAME_SIZE;
        int y3 = ((block_y[2] * 10) + block_x[2]) / FRAME_SIZE;
        int y4 = ((block_y[3] * 10) + block_x[3]) / FRAME_SIZE;
        if (boardBlocks[y1]
                || boardBlocks[y2]
                || boardBlocks[y3]
                || boardBlocks[y4]) {
            collision = true;
            addBlockToBoard();
            newBlock();
        }
    }

    void addBlockToBoard() {
        for (int i = 0; i < block_y.length; i++) {
            block_y[i] -= FRAME_SIZE;
            boardBlocks[((block_y[i] * 10) + block_x[i]) / FRAME_SIZE] = true;
        }
    }

    void newBlock() {
        generatingBlocksOrder();
        blocks.newBlock(tetrisBlocks.get(0), FRAME_SIZE);
        collisionForInvisibleBlock();
        checkTetris();
    }

    void generatingBlocksOrder() {
        if(tetrisBlocks.size() == 0){}
        else tetrisBlocks.remove(0);

        if(tetrisBlocks.size() < 8){
            List<Integer> temporaryList = new ArrayList<>();
            for(int i = 0; i < 10; i++){
                for(int k = 0; k < 7; k++){
                    temporaryList.add(k);
                }
                Collections.shuffle(temporaryList);
                for(int z = 0; z < 7; z++){
                    tetrisBlocks.add(temporaryList.get(z));
                }
                temporaryList.clear();
            }
        }
    }

    void moveBlock() {
        if (System.currentTimeMillis() - currentTime > gameSpeed) {
            for (int i = 0; i < block_y.length; i++) {
                block_y[i] += FRAME_SIZE;
            }
            currentTime = System.currentTimeMillis();
            collisionToDownWall(false);
            collisionWithBlocksOnBoard();
        }
    }

    void switchBlockDirection() {
        typeOfBlockDirection++;
        blocks.switchBlockDirection(block_x, block_y, tetrisBlocks.get(0), typeOfBlockDirection, FRAME_SIZE);
    }

    void moveRight() {
        for (int i = 0; i < block_x.length; i++) {
            block_x[i] += FRAME_SIZE;
        }
    }

    void moveLeft() {
        for (int i = 0; i < block_x.length; i++) {
            block_x[i] -= FRAME_SIZE;
        }
    }

    void moveDown() {
        for (int i = 0; i < block_y.length; i++) {
            block_y[i] += FRAME_SIZE;
        }
        score++;
    }

    void moveDownInstant() {
        collision = false;
        do {
            moveDown();
            collisionToDownWall(false);
            collisionWithBlocksOnBoard();
        } while (!collision);
        pushBottomWall = true;
    }

    void checkTetris() {
        boolean tetris = false;
        for (int i = 0; i < boardBlocks.length; i += 10) {
            if (boardBlocks[i]
                    && boardBlocks[i + 1]
                    && boardBlocks[i + 2]
                    && boardBlocks[i + 3]
                    && boardBlocks[i + 4]
                    && boardBlocks[i + 5]
                    && boardBlocks[i + 6]
                    && boardBlocks[i + 7]
                    && boardBlocks[i + 8]
                    && boardBlocks[i + 9]) {
                tetrisRows.add(i / 10);
                tetris = true;
                if (tetrisRows.size() == 4) break;
            }
        }
        if (tetris){
            pauseForTetris = true;
            pushBottomWallForTetris = true;
            scoreForTetris();
        }
    }

    void scoreForTetris(){
        int rows = tetrisRows.size();
        int points = rows == 1 ? 40: rows == 2 ? 100 : rows == 3 ? 300 : 1200;
        score += points * level;
        line += rows;
        checkingLevelAndSpeed();
    }

    void checkingLevelAndSpeed() {
        if (line < 10) level = 1;
        else {
            if (level != (line / 10) + 1) {
                level = (line / 10) + 1;
                double defaultGameSpeed = 1000;
                for(int i = 1; i < level; i++){
                    defaultGameSpeed *= 0.9;
                }
                gameSpeed = defaultGameSpeed;
            }
        }
    }

    void runningDownBlocksAfterTetris() {
        for (int i = 0; i < tetrisRows.size(); i++) {
            for (int k = tetrisRows.get(i) * 10; k > 0; k--) {
                if (boardBlocks[k]) {
                    boardBlocks[k] = false;
                    boardBlocks[k + 10] = true;
                }
            }
        }
    }

    void resettingAfterTetris() {
        for (int i = 0; i < tetrisRows.size(); i++) {
            for (int k = 0; k < 10; k++) {
                boardBlocks[(tetrisRows.get(i) * 10) + k] = false;
            }
        }
        runningDownBlocksAfterTetris();
        pauseForTetris = false;
        ui.animation = 0;
        tetrisRows.clear();
        collisionForInvisibleBlock();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;


        //ui.drawNet(g2d);

        if (!pauseForTetris) ui.drawMobileBlock(g2d, block_x, block_y, FRAME_SIZE);

        ui.drawBoardBlock(g2d, boardBlocks, FRAME_SIZE);

        if (!pauseForTetris) ui.drawInvisibleBlock(g2d, invisibleBlock_x, invisibleBlock_y, FRAME_SIZE);

        if (pauseForTetris) ui.drawAnimationForTetris(g2d, tetrisRows, GAME_PANEL_WIDTH, FRAME_SIZE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if (!pauseForTetris) moveBlock();
        if (pushRightWall) additionalFeatures.pushRightWall();
        if (pushLeftWall) additionalFeatures.pushLeftWall();
        if (pushBottomWall && !pushBottomWallForTetris) additionalFeatures.pushBottomWall();
        if (pushBottomWallForTetris) additionalFeatures.pushBottomWallForTetris();
    }


    public int getGAME_PANEL_WIDTH() {
        return GAME_PANEL_WIDTH;
    }

    public int getGAME_PANEL_HEIGHT() {
        return GAME_PANEL_HEIGHT;
    }

    public int getFRAME_SIZE() {
        return FRAME_SIZE;
    }

    public void setTypeOfBlockDirection(int typeOfBlockDirection) {
        this.typeOfBlockDirection = typeOfBlockDirection;
    }

    public int[] getTypeOfBlocks() {
        return typeOfBlocks;
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public int getLine() {
        return line;
    }

    public int getPANELS_DISTANCE() {
        return PANELS_DISTANCE;
    }

    public int getPANELS_DISTANCE_X() {
        return PANELS_DISTANCE_X;
    }

    public void setPANELS_DISTANCE_X(int PANELS_DISTANCE_X) {
        this.PANELS_DISTANCE_X = PANELS_DISTANCE_X;
    }

    public int getPANELS_DISTANCE_Y() {
        return PANELS_DISTANCE_Y;
    }

    public void setPANELS_DISTANCE_Y(int PANELS_DISTANCE_Y) {
        this.PANELS_DISTANCE_Y = PANELS_DISTANCE_Y;
    }

    public List<Integer> getTetrisBlocks() {
        return tetrisBlocks;
    }
    public boolean isRunning() {
        return isRunning;
    }
}
