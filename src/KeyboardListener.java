import java.awt.event.*;

public class KeyboardListener extends KeyAdapter {
    GamePanel gamePanel;

    KeyboardListener(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!gamePanel.pauseForTetris) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT -> {
                    gamePanel.moveRight();
                    gamePanel.collisionToRightWall(false);
                    gamePanel.collisionWithBlocksOnBoardToRight(false);
                    gamePanel.collisionForInvisibleBlock();
                }
                case KeyEvent.VK_LEFT -> {
                    gamePanel.moveLeft();
                    gamePanel.collisionToLeftWall(false);
                    gamePanel.collisionWithBlocksOnBoardToLeft(false);
                    gamePanel.collisionForInvisibleBlock();
                }
                case KeyEvent.VK_DOWN -> {
                    gamePanel.moveDown();
                    gamePanel.collisionToDownWall(false);
                    gamePanel.collisionWithBlocksOnBoard();
                }
                case KeyEvent.VK_UP -> {
                    gamePanel.switchBlockDirection();
                    gamePanel.collisionToRightWall(true);
                    gamePanel.collisionToLeftWall(true);
                    gamePanel.collisionToDownWallWhenSwitching();
                    gamePanel.collisionWithBlocksOnBoardWhenSwitching();
                    gamePanel.collisionForInvisibleBlock();
                }
                case KeyEvent.VK_SPACE -> gamePanel.moveDownInstant();
            }
        }
    }
}
