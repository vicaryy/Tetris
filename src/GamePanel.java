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

    void collisionWall() {
        for (int i = 0; i < block_y.length; i++) {
            if (block_y[i] == GAME_PANEL_HEIGHT) {
                collision = true;
                addBlockToBoard();
                newBlock();
            }
        }
    }

    void collisionBlocksOnBoard() {
        int x1 = ((block_y[0] * 10) + block_x[0]) / 40;
        int x2 = ((block_y[1] * 10) + block_x[1]) / 40;
        int x3 = ((block_y[2] * 10) + block_x[2]) / 40;
        int x4 = ((block_y[3] * 10) + block_x[3]) / 40;
        if (boardBlocks[x1] ||
                boardBlocks[x2] ||
                boardBlocks[x3] ||
                boardBlocks[x4]) {
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
        typeOfBlock = random.nextInt(0,1);
        blocks.newBlock(typeOfBlock, typeOfBlockDirection, FRAME_SIZE);
    }

    void moveBlock() {
        if (System.currentTimeMillis() - currentTime > 1000) {
            for (int i = 0; i < block_y.length; i++) {
                block_y[i] += FRAME_SIZE;
            }
            currentTime = System.currentTimeMillis();
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

        ui.drawNet(g2d);

        ui.drawMobileBlock(g2d, block_x, block_y);

        ui.drawBoardBlock(g2d, boardBlocks);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        moveBlock();
        collisionWall();
        collisionBlocksOnBoard();
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
