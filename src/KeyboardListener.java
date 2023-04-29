import java.awt.event.*;

public class KeyboardListener extends KeyAdapter {
    GamePanel gamePanel;
    boolean up;
    boolean space;
    KeyboardListener(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!gamePanel.pauseForTetris) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT -> gamePanel.setMoveRight(true);
                case KeyEvent.VK_LEFT -> gamePanel.setMoveLeft(true);
                case KeyEvent.VK_DOWN -> gamePanel.setMoveDown(true);
                case KeyEvent.VK_UP -> {
                    if (!up) {
                        up = true;
                        gamePanel.switchBlockDirection();
                        gamePanel.collisionToRightWall(true);
                        gamePanel.collisionToLeftWall(true);
                        gamePanel.collisionToDownWallWhenSwitching();
                        gamePanel.collisionWithBlocksOnBoardWhenSwitching();
                        gamePanel.setPositionForGhostBlock();
                    }
                }
                case KeyEvent.VK_SPACE -> {
                    if (!space) {
                        space = true;
                        gamePanel.hardDrop();
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE -> space = false;
            case KeyEvent.VK_UP -> up = false;
            case KeyEvent.VK_DOWN -> gamePanel.setMoveDown(false);
            case KeyEvent.VK_RIGHT -> gamePanel.setMoveRight(false);
            case KeyEvent.VK_LEFT -> gamePanel.setMoveLeft(false);
        }
    }
}
