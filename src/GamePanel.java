import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    private UI ui = new UI(this);
    private Blocks blocks = new Blocks(this);
    private KeyboardListener keyboardListener = new KeyboardListener(this);
    private final int GAME_PANEL_WIDTH = 400;
    private final int GAME_PANEL_HEIGHT = 800;
    private final int FRAME_AMOUNT = 200;
    private final int FRAME_SIZE = GAME_PANEL_WIDTH / 10;
    private int typeOfBlock;
    private int typeOfBlockDirection = 0;
    private long currentTime;
    int[] block_x = new int[4];
    int[] block_y = new int[4];
    int[] invisibleBlock_x = new int[4];
    int[] invisibleBlock_y = new int[4];
    private final boolean[] boardBlocks = new boolean[FRAME_AMOUNT];
    private boolean collision;
    boolean pause;
    Timer timer;
    Timer tetrisTimer;
    Random random;
    List<Integer> tetrisRows;
    Color backgroundColor;

    GamePanel() {

        boardBlocks[190] = true;
        boardBlocks[191] = true;
        boardBlocks[192] = true;
        boardBlocks[193] = true;
        boardBlocks[194] = true;
        boardBlocks[195] = true;
        boardBlocks[196] = true;
        boardBlocks[197] = true;
        boardBlocks[198] = true;

        boardBlocks[170] = true;
        boardBlocks[171] = true;
        boardBlocks[172] = true;
        boardBlocks[173] = true;
        boardBlocks[174] = true;
        boardBlocks[175] = true;
        boardBlocks[176] = true;
        boardBlocks[177] = true;
        boardBlocks[178] = true;


        random = new Random();
        tetrisRows = new ArrayList<>();
        backgroundColor = new Color(10,20,20);

        this.setBackground(backgroundColor);
        this.setBounds(20, 20, GAME_PANEL_WIDTH, GAME_PANEL_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(keyboardListener);

        timer = new Timer(5, this);
        startGame();
    }

    void startGame() {
        newBlock();
        currentTime = System.currentTimeMillis();
        timer.start();
    }


    void collisionToRightWall(boolean upKey){
        for(int i = 0; i < block_x.length; i++){
            if(block_x[i] == GAME_PANEL_WIDTH){
                for(int k = 0; k < block_x.length; k++){
                    block_x[k] -= FRAME_SIZE;
                    if(typeOfBlock == 0 && typeOfBlockDirection == 0 && upKey){
                        block_x[k] -= FRAME_SIZE;
                    }
                }
                break;
            }
        }
    }

    void collisionToLeftWall(boolean upKey){
        for(int i = 0; i < block_x.length; i++){
            if(block_x[i] == -FRAME_SIZE){
                for(int k = 0; k < block_x.length; k++){
                    block_x[k] += FRAME_SIZE;
                    if(typeOfBlock == 0 && typeOfBlockDirection == 2 && upKey){
                        block_x[k] += FRAME_SIZE;
                    }
                }
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
                    if (typeOfBlock == 0 && typeOfBlockDirection == 1) {
                        block_y[k] -= FRAME_SIZE;
                    }
                }
            }
        }
    }

    void collisionWithBlocksOnBoardToRight(boolean upKey){
        int x1 = ((block_y[0] * 10) + block_x[0]) / FRAME_SIZE;
        int x2 = ((block_y[1] * 10) + block_x[1]) / FRAME_SIZE;
        int x3 = ((block_y[2] * 10) + block_x[2]) / FRAME_SIZE;
        int x4 = ((block_y[3] * 10) + block_x[3]) / FRAME_SIZE;
        if (boardBlocks[x1]
                || boardBlocks[x2]
                || boardBlocks[x3]
                || boardBlocks[x4]) {
            for(int i = 0; i < block_x.length; i++){
                block_x[i] -= FRAME_SIZE;
                if (typeOfBlock == 0 && typeOfBlockDirection == 0 && upKey) {
                    block_x[i] -= FRAME_SIZE;
                }
            }
        }
    }

    void collisionWithBlocksOnBoardToLeft(boolean upKey){
        int x1 = ((block_y[0] * 10) + block_x[0]) / FRAME_SIZE;
        int x2 = ((block_y[1] * 10) + block_x[1]) / FRAME_SIZE;
        int x3 = ((block_y[2] * 10) + block_x[2]) / FRAME_SIZE;
        int x4 = ((block_y[3] * 10) + block_x[3]) / FRAME_SIZE;
        if (boardBlocks[x1]
                || boardBlocks[x2]
                || boardBlocks[x3]
                || boardBlocks[x4]) {
            for(int i = 0; i < block_x.length; i++){
                block_x[i] += FRAME_SIZE;
                if (typeOfBlock == 0 && typeOfBlockDirection == 2 && upKey) {
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
        try {
            for (int i = 0; i < block_y.length; i++) {
                block_y[i] -= FRAME_SIZE;
                boardBlocks[((block_y[i] * 10) + block_x[i]) / FRAME_SIZE] = true;
            }
        }catch(Exception e){
            System.out.println("SKUCHA");
        }
    }

    void newBlock() {
        typeOfBlock = random.nextInt(0,1);
        blocks.newBlock(typeOfBlock, typeOfBlockDirection, FRAME_SIZE);
        collisionForInvisibleBlock();
        checkTetris();
    }

    void moveBlock() {
        if (System.currentTimeMillis() - currentTime > 1000) {
            for (int i = 0; i < block_y.length; i++) {
                block_y[i] += FRAME_SIZE;
            }
            currentTime = System.currentTimeMillis();
            collisionToDownWall(false);
            collisionWithBlocksOnBoard();
        }
    }

    void switchBlockDirection(){
        typeOfBlockDirection++;
        blocks.switchBlockDirection(block_x, block_y, typeOfBlock, typeOfBlockDirection, FRAME_SIZE);
    }

    void moveRight(){
        for (int i = 0; i < block_x.length; i++) {
            block_x[i] += FRAME_SIZE;
        }
    }

    void moveLeft(){
        for (int i = 0; i < block_x.length; i++) {
            block_x[i] -= FRAME_SIZE;
        }
    }

    void moveDown(){
        for (int i = 0; i < block_y.length; i++) {
            block_y[i] += FRAME_SIZE;
        }
    }

    void moveDownInstant() {
        collision = false;
        do {
            moveDown();
            collisionToDownWall(false);
            collisionWithBlocksOnBoard();
        } while (!collision);
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

        if (tetris) {
            timer.stop();
            pause = true;
            tetrisTimer = new Timer(100, e -> {
                repaint();
                if (ui.complete)
                    resettingAfterTetris();
            });
            tetrisTimer.start();
        }
    }

    void resettingAfterTetris(){
        for(int i = 0; i < tetrisRows.size(); i++){
            for(int k = 0; k < 10; k++){
                boardBlocks[(tetrisRows.get(i)*10)+k] = false;
            }
        }
        tetrisTimer.stop();
        timer.start();
        pause = false;
        ui.complete = false;
        ui.animation = 0;
        tetrisRows.clear();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //ui.drawNet(g2d);

        ui.drawMobileBlock(g2d, block_x, block_y);

        ui.drawBoardBlock(g2d, boardBlocks);

        ui.drawInvisibleBlock(g2d, invisibleBlock_x, invisibleBlock_y);

        if (pause) ui.drawAnimationForTetris(g2d, tetrisRows);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        moveBlock();
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
}
