import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    UI ui = new UI(this);
    Blocks blocks = new Blocks(this);
    KeyboardListener keyboardListener = new KeyboardListener(this);
    private final int GAME_PANEL_WIDTH = 400;
    private final int GAME_PANEL_HEIGHT = 800;
    private final int FRAME_SIZE = 40;
    private int typeOfBlock;
    private int typeOfBlockDirection = 0;
    private long currentTime;
    int[] block_x = new int[4];
    int[] block_y = new int[4];
    private boolean[] boardBlocks = new boolean[200];
    private boolean collision;

    Timer timer;
    Random random;

    GamePanel() {

        random = new Random();

        this.setBackground(new Color(10, 20, 20));
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

//    void collisionToWall(boolean right, boolean left, boolean down, boolean up) {
//        for (int i = 0; i < block_x.length; i++) {
//            if (block_x[i] == GAME_PANEL_WIDTH
//                    || block_x[i] == -FRAME_SIZE
//                    || block_y[i] == GAME_PANEL_HEIGHT) {
//                for (int k = 0; k < block_x.length; k++) {
//                    block_x[k] += right ? -FRAME_SIZE : left ? FRAME_SIZE : 0;
//                    block_y[k] += down ? -FRAME_SIZE : 0;
//                }
//            }
//        }
//    }

    void collisionToRight(boolean up){
        for(int i = 0; i < block_x.length; i++){
            if(block_x[i] == GAME_PANEL_WIDTH){
                for(int k = 0; k < block_x.length; k++){
                    block_x[k] -= FRAME_SIZE;
                    if(typeOfBlock == 0 && typeOfBlockDirection == 0 && up){
                        block_x[k] -= FRAME_SIZE;
                    }
                }
                break;
            }
        }
    }

    void collisionToLeft(boolean up){
        for(int i = 0; i < block_x.length; i++){
            if(block_x[i] == -FRAME_SIZE){
                for(int k = 0; k < block_x.length; k++){
                    block_x[k] += FRAME_SIZE;
                    if(typeOfBlock == 0 && typeOfBlockDirection == 2 && up){
                        block_x[k] += FRAME_SIZE;
                    }
                }
                break;
            }
        }
    }

    void collisionToDown(boolean up) {
        for (int i = 0; i < block_y.length; i++) {
            if (block_y[i] == GAME_PANEL_HEIGHT) {
                collision = true;
                addBlockToBoard();
                newBlock();
                break;
            }
        }
    }

    void collisionBlocksOnBoardToRight(){
        int y1 = ((block_y[0] * 10) + block_x[0]) / 40;
        int y2 = ((block_y[1] * 10) + block_x[1]) / 40;
        int y3 = ((block_y[2] * 10) + block_x[2]) / 40;
        int y4 = ((block_y[3] * 10) + block_x[3]) / 40;
        if (boardBlocks[y1]
                || boardBlocks[y2]
                || boardBlocks[y3]
                || boardBlocks[y4]) {
            for(int i = 0; i < block_x.length; i++){
                block_x[i] -= FRAME_SIZE;
            }
        }
    }

    void collisionBlocksOnBoardToLeft(){
        int y1 = ((block_y[0] * 10) + block_x[0]) / 40;
        int y2 = ((block_y[1] * 10) + block_x[1]) / 40;
        int y3 = ((block_y[2] * 10) + block_x[2]) / 40;
        int y4 = ((block_y[3] * 10) + block_x[3]) / 40;
        if (boardBlocks[y1]
                || boardBlocks[y2]
                || boardBlocks[y3]
                || boardBlocks[y4]) {
            for(int i = 0; i < block_x.length; i++){
                block_x[i] += FRAME_SIZE;
            }
        }
    }

    void collisionBlocksOnBoardToDown(){
        int y1 = ((block_y[0] * 10) + block_x[0]) / 40;
        int y2 = ((block_y[1] * 10) + block_x[1]) / 40;
        int y3 = ((block_y[2] * 10) + block_x[2]) / 40;
        int y4 = ((block_y[3] * 10) + block_x[3]) / 40;
        if (boardBlocks[y1]
                || boardBlocks[y2]
                || boardBlocks[y3]
                || boardBlocks[y4]) {
            for(int i = 0; i < block_y.length; i++){
                block_y[i] -= FRAME_SIZE;
            }
        }
    }

    void collisionBlocksOnBoard() {
        int y1 = ((block_y[0] * 10) + block_x[0]) / 40;
        int y2 = ((block_y[1] * 10) + block_x[1]) / 40;
        int y3 = ((block_y[2] * 10) + block_x[2]) / 40;
        int y4 = ((block_y[3] * 10) + block_x[3]) / 40;
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
        }
        for (int i = 0; i < block_x.length; i++) {
            boardBlocks[((block_y[i] * 10) + block_x[i]) / 40] = true;
        }
    }


    void newBlock() {
        typeOfBlock = random.nextInt(0,7);
        blocks.newBlock(typeOfBlock, typeOfBlockDirection, FRAME_SIZE);
    }

    void moveBlock() {
        if (System.currentTimeMillis() - currentTime > 100000) {
            for (int i = 0; i < block_y.length; i++) {
                block_y[i] += FRAME_SIZE;
            }
            currentTime = System.currentTimeMillis();
            collisionToDown(false);
            collisionBlocksOnBoard();
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //ui.drawNet(g2d);

        ui.drawMobileBlock(g2d, block_x, block_y);

        ui.drawBoardBlock(g2d, boardBlocks);

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
