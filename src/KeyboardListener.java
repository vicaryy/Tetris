import java.awt.event.*;

public class KeyboardListener implements KeyListener {
    GamePanel gamePanel;
    KeyboardListener(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gamePanel.moveRight();
            gamePanel.collisionToRight(false);
            gamePanel.collisionBlocksOnBoardToRight();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            gamePanel.moveLeft();
            gamePanel.collisionToLeft(false);
            gamePanel.collisionBlocksOnBoardToLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            gamePanel.moveDown();
            gamePanel.collisionToDown(false);
            gamePanel.collisionBlocksOnBoard();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            gamePanel.switchBlockDirection();
            gamePanel.collisionToRight(true);
            gamePanel.collisionToLeft(true);
            gamePanel.collisionBlocksOnBoardToDown();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
