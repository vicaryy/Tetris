import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    private SuperRotationSystem superRotationSystem;
    private int GAME_PANEL_WIDTH = 400;
    private final int GAME_PANEL_HEIGHT = GAME_PANEL_WIDTH * 2;
    private final int FRAME_AMOUNT = 400;
    private final int FRAME_SIZE = GAME_PANEL_WIDTH / 10;
    private final int PANELS_DISTANCE = GAME_PANEL_WIDTH / 20;
    private int PANELS_DISTANCE_X = GAME_PANEL_WIDTH / 20;
    private int PANELS_DISTANCE_Y = GAME_PANEL_WIDTH / 20;
    private int blockDirection = 0;
    private int score;
    private int level;
    private int line;
    private double gameSpeed = 1000;
    private long automaticMoveDownTime;
    private long softDropTime;
    private long moveRightTime;
    private long moveLeftTime;
    int[] mobileBlock_x = new int[4];
    int[] mobileBlock_y = new int[4];
    int[] ghostBlock_x = new int[4];
    int[] ghostBlock_y = new int[4];
    int[] blocksOnBoard = new int[FRAME_AMOUNT];
    private boolean isRunning;
    private boolean isCollision;
    private boolean moveDown;
    private boolean moveRight;
    private boolean moveLeft;
    boolean pushRightWall;
    boolean pushLeftWall;
    boolean pushBottomWall;
    boolean pushBottomWallForTetris;
    boolean highlightBlock;
    boolean isTSpin;
    boolean isMiniTSpin;
    boolean animationForTSpin;
    boolean isTetris;
    boolean animationForTetris;
    int rectangle_x = PANELS_DISTANCE - 2;
    int rectangle_y = PANELS_DISTANCE - 2;
    int rectangle_width = GAME_PANEL_WIDTH + 4;
    int rectangle_height = GAME_PANEL_HEIGHT + 4;
    List<Integer> tetrisBlocks = new ArrayList<>();
    List<Integer> tetrisRows = new ArrayList<>();
    Color backgroundColor = new Color(10, 20, 20);
    Color mainPanelColor = new Color(24, 23, 23);
    Timer timer;

    int[] tSpin_x = new int[4];
    int[] tSpin_y = new int[4];


    GamePanel() {
        ui = new UI(this);
        blocks = new Blocks(this);
        mainPanel = new MainPanel(this);
        superRotationSystem = new SuperRotationSystem(this);
        nextBlockPanel = new NextBlockPanel(this, mainPanel);
        scorePanel = new ScorePanel(this, mainPanel);
        levelPanel = new LevelPanel(this, mainPanel);
        linePanel = new LinePanel(this, mainPanel);
        additionalFeatures = new AdditionalFeatures(this, mainPanel);
        keyboardListener = new KeyboardListener(this, superRotationSystem);


        this.setBackground(backgroundColor);
        this.setBounds(PANELS_DISTANCE_X, PANELS_DISTANCE_Y, GAME_PANEL_WIDTH, GAME_PANEL_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(keyboardListener);

        timer = new Timer(5, this);
        startGame();
    }

    void startGame() {
        Arrays.fill(blocksOnBoard, -1);
        automaticMoveDownTime = System.currentTimeMillis();
        setLevelAndSpeed();
        newBlock();
        timer.start();
        isRunning = true;

//        //T-Spin / E-S (CLOCKWISE)  - dziala
//

        //T-SPIN / S-W (CLOCKWISE) - DZIALA
//        blocksOnBoard[190] = 0;
//        blocksOnBoard[191] = 0;
//        blocksOnBoard[192] = 0;
//        blocksOnBoard[193] = 0;
//
//        blocksOnBoard[180] = 0;
//        blocksOnBoard[181] = 0;
//        blocksOnBoard[182] = 0;
//
//        blocksOnBoard[170] = 0;
//        blocksOnBoard[171] = 0;
//        blocksOnBoard[172] = 0;
//        blocksOnBoard[173] = 0;
//        blocksOnBoard[174] = -1;
//        blocksOnBoard[175] = 0;
//
//        blocksOnBoard[160] = 0;
//        blocksOnBoard[161] = 0;
//        blocksOnBoard[162] = 0;
//        blocksOnBoard[163] = 0;
//        blocksOnBoard[164] = 0;
//        blocksOnBoard[165] = 0;

        //T-SPIN / N-W (COUNTERCLOCKWISE) - dziala
//        blocksOnBoard[190] = -1;
//        blocksOnBoard[191] = -1;
//        blocksOnBoard[192] = 0;
//        blocksOnBoard[193] = 0;
//        blocksOnBoard[194] = 0;
//        blocksOnBoard[195] = 0;
//        blocksOnBoard[196] = -1;
//        blocksOnBoard[197] = 0;
//        blocksOnBoard[198] = -1;
//
//        blocksOnBoard[183] = 0;
//        blocksOnBoard[184] = 0;
//        blocksOnBoard[187] = 0;
//
//        blocksOnBoard[174] = 0;
//        blocksOnBoard[175] = 0;
//        blocksOnBoard[177] = 0;
//        blocksOnBoard[178] = 0;
//
//        blocksOnBoard[167] = 0;
//        blocksOnBoard[168] = 0;
//
//        blocksOnBoard[156] = 0;
//        blocksOnBoard[157] = 0;



          //TRIPLE T-SPIN ROTATION - dziala
//        blocksOnBoard[190] = 4;
//        blocksOnBoard[191] = 4;
//        blocksOnBoard[192] = 4;
//        blocksOnBoard[193] = -1;
//        blocksOnBoard[194] = 4;
//        blocksOnBoard[195] = 4;
//        blocksOnBoard[196] = 4;
//        blocksOnBoard[197] = 4;
//        blocksOnBoard[198] = 4;
//        blocksOnBoard[199] = 4;
//
//        blocksOnBoard[180] = 4;
//        blocksOnBoard[181] = 4;
//        blocksOnBoard[182] = 4;
//        blocksOnBoard[183] = -1;
//        blocksOnBoard[184] = -1;
//        blocksOnBoard[185] = 4;
//        blocksOnBoard[186] = 4;
//        blocksOnBoard[187] = 4;
//        blocksOnBoard[188] = 4;
//        blocksOnBoard[189] = 4;
//
//        blocksOnBoard[170] = 4;
//        blocksOnBoard[171] = 4;
//        blocksOnBoard[172] = 4;
//        blocksOnBoard[173] = -1;
//        blocksOnBoard[174] = 4;
//        blocksOnBoard[175] = 4;
//        blocksOnBoard[176] = 4;
//        blocksOnBoard[177] = 4;
//        blocksOnBoard[178] = 4;
//        blocksOnBoard[179] = 4;
//
//        blocksOnBoard[160] = -1;
//        blocksOnBoard[161] = 3;
//        blocksOnBoard[162] = 5;
//        blocksOnBoard[167] = 1;
//
//        blocksOnBoard[150] = -1;
//        blocksOnBoard[151] = -1;
//        blocksOnBoard[152] = 2;
//        blocksOnBoard[153] = 2;

        //MINI T-SPIN
//        blocksOnBoard[191] = 0;
//        blocksOnBoard[192] = 0;
//        blocksOnBoard[193] = 0;
//        blocksOnBoard[194] = 0;
//        blocksOnBoard[195] = 0;
//        blocksOnBoard[196] = 0;
//        blocksOnBoard[197] = 0;
//        blocksOnBoard[198] = 0;

        //MINI T-SPIN SINGLE
        blocksOnBoard[190] = 0;
        blocksOnBoard[191] = -1;
        blocksOnBoard[192] = -1;
        blocksOnBoard[193] = -1;
        blocksOnBoard[194] = 0;
        blocksOnBoard[195] = 0;
        blocksOnBoard[196] = 0;
        blocksOnBoard[197] = 0;
        blocksOnBoard[198] = 0;
        blocksOnBoard[199] = 0;

        blocksOnBoard[180] = 0;
        blocksOnBoard[181] = 0;
        blocksOnBoard[182] = -1;
        blocksOnBoard[183] = -1;
        blocksOnBoard[184] = 1;
    }

    void tSpinCollision() {
        // A = B
        // = = =
        // C   D
        boolean A, B, C, D;

        switch (blockDirection) {
            case 0 -> {
                tSpin_x[0] = mobileBlock_x[0] - FRAME_SIZE;
                tSpin_x[1] = mobileBlock_x[0] + FRAME_SIZE;
                tSpin_x[2] = mobileBlock_x[0] - FRAME_SIZE;
                tSpin_x[3] = mobileBlock_x[0] + FRAME_SIZE;

                tSpin_y[0] = mobileBlock_y[0];
                tSpin_y[1] = mobileBlock_y[0];
                tSpin_y[2] = mobileBlock_y[0] + FRAME_SIZE * 2;
                tSpin_y[3] = mobileBlock_y[0] + FRAME_SIZE * 2;
            }
            case 1 -> {
                tSpin_x[0] = mobileBlock_x[0];
                tSpin_x[1] = mobileBlock_x[0];
                tSpin_x[2] = mobileBlock_x[0] - FRAME_SIZE * 2;
                tSpin_x[3] = mobileBlock_x[0] - FRAME_SIZE * 2;

                tSpin_y[0] = mobileBlock_y[0] - FRAME_SIZE;
                tSpin_y[1] = mobileBlock_y[0] + FRAME_SIZE;
                tSpin_y[2] = mobileBlock_y[0] - FRAME_SIZE;
                tSpin_y[3] = mobileBlock_y[0] + FRAME_SIZE;
            }
            case 2 -> {
                tSpin_x[0] = mobileBlock_x[0] + FRAME_SIZE;
                tSpin_x[1] = mobileBlock_x[0] - FRAME_SIZE;
                tSpin_x[2] = mobileBlock_x[0] + FRAME_SIZE;
                tSpin_x[3] = mobileBlock_x[0] - FRAME_SIZE;

                tSpin_y[0] = mobileBlock_y[0];
                tSpin_y[1] = mobileBlock_y[0];
                tSpin_y[2] = mobileBlock_y[0] - FRAME_SIZE * 2;
                tSpin_y[3] = mobileBlock_y[0] - FRAME_SIZE * 2;
            }
            case 3 -> {
                tSpin_x[0] = mobileBlock_x[0];
                tSpin_x[1] = mobileBlock_x[0];
                tSpin_x[2] = mobileBlock_x[0] + FRAME_SIZE * 2;
                tSpin_x[3] = mobileBlock_x[0] + FRAME_SIZE * 2;

                tSpin_y[0] = mobileBlock_y[0] + FRAME_SIZE;
                tSpin_y[1] = mobileBlock_y[0] - FRAME_SIZE;
                tSpin_y[2] = mobileBlock_y[0] + FRAME_SIZE;
                tSpin_y[3] = mobileBlock_y[0] - FRAME_SIZE;
            }
        }
        A = checkCollisionForTSpin(tSpin_x[0], tSpin_y[0], 'A');
        B = checkCollisionForTSpin(tSpin_x[1], tSpin_y[1], 'B');
        C = checkCollisionForTSpin(tSpin_x[2], tSpin_y[2], 'C');
        D = checkCollisionForTSpin(tSpin_x[3], tSpin_y[3], 'D');

        if ((A && B) && (C || D)) {
            isTSpin = true;
        } else if ((C && D) && (A || B)) {
            isMiniTSpin = true;
        } else {
            isTSpin = false;
            isMiniTSpin = false;
        }
    }
    boolean checkCollisionForTSpin(int x, int y, char whichLetter) {
            if (x == -FRAME_SIZE
                    || x == GAME_PANEL_WIDTH
                    || y == GAME_PANEL_HEIGHT) {
                return true;
            }
            int letter = whichLetter == 'A' ? 0 : whichLetter == 'B' ? 1 : whichLetter == 'C' ? 2 : 3;
            int x1 = ((tSpin_y[letter] * 10) + tSpin_x[letter]) / FRAME_SIZE;

        if (blocksOnBoard[x1] != -1) {
            return true;
        }
        return false;
    }

    void newBlock() {
        setLevelAndSpeed();
        highlightBlock = false;
        generatingBagOfBlocks();
        blocks.newBlock(tetrisBlocks.get(0), FRAME_SIZE);
        setPositionForGhostBlock();
    }
    void addBlockToBoard() {
        for (int i = 0; i < mobileBlock_y.length; i++) {
            mobileBlock_y[i] -= FRAME_SIZE;
            blocksOnBoard[((mobileBlock_y[i] * 10) + mobileBlock_x[i]) / FRAME_SIZE] = tetrisBlocks.get(0);
        }
        setScore();
    }
    void switchBlockDirectionClockwise() {
        blockDirection++;
        if (blockDirection == 4) blockDirection = 0;
        blocks.switchBlockDirection(mobileBlock_x, mobileBlock_y, tetrisBlocks.get(0), blockDirection, FRAME_SIZE, true);
    }
    void switchBlockDirectionCounterClockwise() {
        blockDirection--;
        if (blockDirection == -1) blockDirection = 3;
        blocks.switchBlockDirection(mobileBlock_x, mobileBlock_y, tetrisBlocks.get(0), blockDirection, FRAME_SIZE, false);
    }

    void generatingBagOfBlocks() {
        if (tetrisBlocks.size() != 0)
            tetrisBlocks.remove(0);
        if (tetrisBlocks.size() < 8) {
            List<Integer> temporaryList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                for (int k = 0; k < 7; k++) {
                    temporaryList.add(k);
                }
                Collections.shuffle(temporaryList);
                for (int z = 0; z < 7; z++) {
                    tetrisBlocks.add(temporaryList.get(z));
                }
                temporaryList.clear();
            }
            Collections.fill(tetrisBlocks, 2);
        }
    }


    void setScore() {
        isTetris = checkTetris();
        int rows = tetrisRows.size();

        if (isTSpin) {
            if (isTetris) {
                int lineForRows = rows == 1 ? 8 : rows == 2 ? 12 : 16;
                score += (400 * (rows + 1)) * level;
                line += lineForRows;
                System.out.println("T-SPIN " + rows);
            } else {
                score += 400 * level;
                line += 4;
                System.out.println("Zwykły T-SPIN");
            }
        } else if (isMiniTSpin) {
            if (isTetris) {
                score += 200 * level;
                line += 2;
                System.out.println("Mini T-SPIN SINGLE");
            } else {
                score += 100 * level;
                line += 1;
                System.out.println("Mini T-SPIN");
            }
        } else if (isTetris) {
            int points = rows == 1 ? 100 : rows == 2 ? 300 : rows == 3 ? 500 : 800;
            int lineForRows = rows == 1 ? 1 : rows == 2 ? 3 : rows == 3 ? 5 : 8;
            score += points * level;
            line += lineForRows;
        }
        setLevelAndSpeed();
        if(isTetris) animationForTetris = true;
        if(isTSpin || isMiniTSpin) animationForTSpin = true;
        isTetris = false;
        isTSpin = false;
        isMiniTSpin = false;
    }

    boolean checkTetris() {
        boolean tetris = false;
        for (int i = 0; i < blocksOnBoard.length; i += 10) {
            if (blocksOnBoard[i] != -1
                    && blocksOnBoard[i + 1] != -1
                    && blocksOnBoard[i + 2] != -1
                    && blocksOnBoard[i + 3] != -1
                    && blocksOnBoard[i + 4] != -1
                    && blocksOnBoard[i + 5] != -1
                    && blocksOnBoard[i + 6] != -1
                    && blocksOnBoard[i + 7] != -1
                    && blocksOnBoard[i + 8] != -1
                    && blocksOnBoard[i + 9] != -1) {
                tetrisRows.add(i / 10);
                tetris = true;
                if (tetrisRows.size() == 4) break;
            }
        }
        return tetris;
    }
    void runningDownBlocksAfterTetris() {
        for (int i = 0; i < tetrisRows.size(); i++) {
            for (int k = tetrisRows.get(i) * 10; k > 0; k--) {
                if (blocksOnBoard[k] != -1) {
                    blocksOnBoard[k + 10] = blocksOnBoard[k];
                    blocksOnBoard[k] = -1;
                }
            }
        }
    }
    void resettingAfterTetris() {
        for (int i = 0; i < tetrisRows.size(); i++) {
            for (int k = 0; k < 10; k++) {
                blocksOnBoard[(tetrisRows.get(i) * 10) + k] = -1;
            }
        }
        runningDownBlocksAfterTetris();
        animationForTetris = false;
        ui.animation = 0;
        tetrisRows.clear();
        setPositionForGhostBlock();
    }


    void setPositionForGhostBlock() {
        for (int i = 0; i < mobileBlock_y.length; i++) {
            ghostBlock_x[i] = mobileBlock_x[i];
            ghostBlock_y[i] = mobileBlock_y[i];
        }

        boolean ghostBlockCollision = false;
        do {
            for (int i = 0; i < mobileBlock_y.length; i++) {
                if (ghostBlock_y[i] == GAME_PANEL_HEIGHT) {
                    ghostBlockCollision = true;
                    break;
                }
            }
            if (!ghostBlockCollision) {
                int x1 = ((ghostBlock_y[0] * 10) + ghostBlock_x[0]) / FRAME_SIZE;
                int x2 = ((ghostBlock_y[1] * 10) + ghostBlock_x[1]) / FRAME_SIZE;
                int x3 = ((ghostBlock_y[2] * 10) + ghostBlock_x[2]) / FRAME_SIZE;
                int x4 = ((ghostBlock_y[3] * 10) + ghostBlock_x[3]) / FRAME_SIZE;
                if (blocksOnBoard[x1] != -1
                        || blocksOnBoard[x2] != -1
                        || blocksOnBoard[x3] != -1
                        || blocksOnBoard[x4] != -1) {
                    ghostBlockCollision = true;
                }
            }
            for (int i = 0; i < mobileBlock_y.length; i++) {
                ghostBlock_y[i] += FRAME_SIZE;
            }

        } while (!ghostBlockCollision);

        for (int i = 0; i < mobileBlock_y.length; i++) {
            ghostBlock_y[i] -= FRAME_SIZE * 2;
        }
    }
    void checkHighlightBlock() {
        moveDown(1);
        boolean touchWallOrBlock = checkCollisionWithBlocksAndWalls(false);
        if (!highlightBlock) {
            setHighlightBlock(true);
        }
        if (!touchWallOrBlock) {
            highlightBlock = false;
        }
        moveUp(1);
    }
    void setLevelAndSpeed() {
        int[] linesForLevel = {0, 5, 15, 30, 50, 75, 105, 140, 180, 225, 275, 330, 390, 455, 525, 600};
        for(int i = 0; i < linesForLevel.length; i++){
            if(line >= linesForLevel[i]){
                level = i + 1;
            }
        }
        gameSpeed = Math.pow(((0.8 - ((level - 1) * 0.007))), (level - 1));
        gameSpeed *= 1000;
    }

    boolean checkCollisionWithBlocksAndWalls(boolean movingByKey) {
        for (int i = 0; i < mobileBlock_y.length; i++) {
            if (mobileBlock_x[i] == -FRAME_SIZE
                    || mobileBlock_x[i] == GAME_PANEL_WIDTH
                    || mobileBlock_y[i] == GAME_PANEL_HEIGHT) {
                if (movingByKey && mobileBlock_x[i] == -FRAME_SIZE) pushLeftWall = true;
                else if (movingByKey && mobileBlock_x[i] == GAME_PANEL_WIDTH) pushRightWall = true;
                return true;
            }
        }
        int x1 = ((mobileBlock_y[0] * 10) + mobileBlock_x[0]) / FRAME_SIZE;
        int x2 = ((mobileBlock_y[1] * 10) + mobileBlock_x[1]) / FRAME_SIZE;
        int x3 = ((mobileBlock_y[2] * 10) + mobileBlock_x[2]) / FRAME_SIZE;
        int x4 = ((mobileBlock_y[3] * 10) + mobileBlock_x[3]) / FRAME_SIZE;

        if (blocksOnBoard[x1] != -1
                || blocksOnBoard[x2] != -1
                || blocksOnBoard[x3] != -1
                || blocksOnBoard[x4] != -1) {
            return true;
        }
        return false;
    }

    void collisionWithBlocksAndWalls(char direction) {
        boolean collisionWithBlocksAndWalls = checkCollisionWithBlocksAndWalls(true);
        if (collisionWithBlocksAndWalls) {
            switch (direction) {
                case 'R' -> moveLeft(1);
                case 'L' -> moveRight(1);
                case 'D' -> {
                    isCollision = true;
                    addBlockToBoard();
                    newBlock();
                }
            }
        }
    }


    void automaticMoveBlockDown() {
        if (System.currentTimeMillis() - automaticMoveDownTime > gameSpeed) {
            checkHighlightBlock();
            automaticMoveDownTime = System.currentTimeMillis();
            moveDown(1);
            collisionWithBlocksAndWalls('D');
        }
    }
    void softDrop() {
        checkHighlightBlock();
        if (System.currentTimeMillis() - softDropTime > gameSpeed / 20) {
            softDropTime = System.currentTimeMillis();
            moveDown(1);
            boolean collisionWithBlockOrWalls = checkCollisionWithBlocksAndWalls(false);
            if (!collisionWithBlockOrWalls) {
                score++;
                automaticMoveDownTime = System.currentTimeMillis();
            } else {
                moveUp(1);
            }
        }
    }
    void hardDrop() {
        isCollision = false;
        do {
            moveDown(1);
            collisionWithBlocksAndWalls('D');
            score += 2;
        } while (!isCollision);
        pushBottomWall = true;
    }
    void moveRightByKey(){
        if(System.currentTimeMillis() - moveRightTime > 130) {
            moveRightTime = System.currentTimeMillis();
            moveRight(1);
            collisionWithBlocksAndWalls('R');
            setPositionForGhostBlock();
            checkHighlightBlock();
            additionalFeatures.moveWallsByLeftRight('R');

        }
    }
    void moveLeftByKey(){
        if(System.currentTimeMillis() - moveLeftTime > 130) {
            moveLeftTime = System.currentTimeMillis();
            moveLeft(1);
            collisionWithBlocksAndWalls('L');
            setPositionForGhostBlock();
            checkHighlightBlock();
            additionalFeatures.moveWallsByLeftRight('L');
        }
    }
    void moveRight(int howManyTimes) {
        for (int i = 0; i < mobileBlock_x.length; i++) {
            mobileBlock_x[i] += FRAME_SIZE * howManyTimes;
        }
    }
    void moveLeft(int howManyTimes) {
        for (int i = 0; i < mobileBlock_x.length; i++) {
            mobileBlock_x[i] -= FRAME_SIZE * howManyTimes;
        }
    }
    void moveUp(int howManyTimes) {
        for(int i = 0; i < mobileBlock_y.length; i++){
            mobileBlock_y[i] -= FRAME_SIZE * howManyTimes;
        }
    }
    void moveDown(int howManyTimes){
        for (int i = 0; i < mobileBlock_y.length; i++) {
            mobileBlock_y[i] += FRAME_SIZE * howManyTimes;
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //ui.drawNet(g2d);
        if (highlightBlock && !animationForTetris && !animationForTSpin)
            ui.drawHighlightMobileBlock(g2d, mobileBlock_x, mobileBlock_y, FRAME_SIZE, tetrisBlocks);

        if (!animationForTetris && !animationForTSpin) ui.drawMobileBlock(g2d, mobileBlock_x, mobileBlock_y, FRAME_SIZE, tetrisBlocks);

        ui.drawBlocksOnBoard(g2d, blocksOnBoard, FRAME_SIZE);

        if (!animationForTetris && !animationForTSpin) ui.drawGhostBlock(g2d, ghostBlock_x, ghostBlock_y, FRAME_SIZE);

        if (animationForTetris) ui.drawAnimationForTetris(g2d, tetrisRows, GAME_PANEL_WIDTH, FRAME_SIZE);

        if (animationForTSpin) ui.drawAnimationForTSpin(g2d, FRAME_SIZE, mobileBlock_x, mobileBlock_y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if (!animationForTetris && !animationForTSpin) automaticMoveBlockDown();
        if (pushRightWall) additionalFeatures.pushRightWall();
        if (pushLeftWall) additionalFeatures.pushLeftWall();
        if (pushBottomWall && !pushBottomWallForTetris) additionalFeatures.pushBottomWall();
        if (pushBottomWallForTetris) additionalFeatures.pushBottomWallForTetris();
        if (moveDown && !animationForTetris && !animationForTSpin) softDrop();
        if (moveRight && !animationForTetris && !animationForTSpin) moveRightByKey();
        if (moveLeft && !animationForTetris && !animationForTSpin) moveLeftByKey();
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

    public void setBlockDirection(int blockDirection) {
        this.blockDirection = blockDirection;
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

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void setHighlightBlock(boolean highlightBlock) {
        this.highlightBlock = highlightBlock;
        ui.transparencyForHighlightBlock = 255;
    }

    public boolean isHighlightBlock() {
        return highlightBlock;
    }

    public double getGameSpeed() {
        return gameSpeed;
    }

    public int getBlockDirection() {
        return blockDirection;
    }
}
