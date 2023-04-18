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
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            gamePanel.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            gamePanel.moveDown();
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP){
            gamePanel.switchBlockDirection();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
