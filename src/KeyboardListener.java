import java.awt.event.*;

public class KeyboardListener extends KeyAdapter {
    GamePanel gamePanel;
    SuperRotationSystem superRotationSystem;
    boolean up;
    boolean z;
    boolean space;
    KeyboardListener(GamePanel gamePanel, SuperRotationSystem superRotationSystem) {
        this.gamePanel = gamePanel;
        this.superRotationSystem = superRotationSystem;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!gamePanel.isTetris) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT -> gamePanel.setMoveRight(true);
                case KeyEvent.VK_LEFT -> gamePanel.setMoveLeft(true);
                case KeyEvent.VK_DOWN -> gamePanel.setMoveDown(true);
                case KeyEvent.VK_UP, KeyEvent.VK_X -> {
                    if (!up) {
                        up = true;
                        superRotationSystem.SRS(gamePanel.getTetrisBlocks().get(0), gamePanel.getBlockDirection(), true);
                        gamePanel.setPositionForGhostBlock();
                    }
                }
                case KeyEvent.VK_Z -> {
                    if (!z) {
                        z = true;
                        superRotationSystem.SRS(gamePanel.getTetrisBlocks().get(0), gamePanel.getBlockDirection(), false);
                        gamePanel.setPositionForGhostBlock();
                    }
                }
                case KeyEvent.VK_SPACE -> {
                    if (!space) {
                        space = true;
                        gamePanel.hardDrop();
                    }
                }
                //case KeyEvent.VK_SHIFT -> gamePanel.moveUp(1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE -> space = false;
            case KeyEvent.VK_UP, KeyEvent.VK_X -> up = false;
            case KeyEvent.VK_Z -> z = false;
            case KeyEvent.VK_DOWN -> gamePanel.setMoveDown(false);
            case KeyEvent.VK_RIGHT -> gamePanel.setMoveRight(false);
            case KeyEvent.VK_LEFT -> gamePanel.setMoveLeft(false);
        }
    }
}
