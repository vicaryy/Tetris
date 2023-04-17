import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {
    int GAME_PANEL_WIDTH = 400;
    int GAME_PANEL_HEIGHT = 800;
    int FRAME_SIZE = 40;
    int[] x = new int[4];
    int[] y = new int[4];
    boolean[] entire = new boolean[200];
    Timer timer;
    GamePanel(){

        entire[82] = true;
        entire[23] = true;
        entire[130] = true;
        entire[199] = true;
        entire[2] = true;
        entire[73] = true;

        this.setBackground(new Color(10,20,20));
        this.setBounds(20,20,GAME_PANEL_WIDTH,GAME_PANEL_HEIGHT);
        x[0] = FRAME_SIZE * 5;
        x[1] = FRAME_SIZE * 6;
        x[2] = FRAME_SIZE * 7;
        x[3] = FRAME_SIZE * 7;

        y[0] = FRAME_SIZE;
        y[1] = FRAME_SIZE;
        y[2] = FRAME_SIZE;
        y[3] = FRAME_SIZE * 2;

        timer = new Timer(1000,this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(1));
        g2d.setPaint(new Color(70,70,70));
        for(int i = FRAME_SIZE; i < GAME_PANEL_HEIGHT; i += FRAME_SIZE){
            g2d.drawLine(i, 0, i, GAME_PANEL_HEIGHT);
            g2d.drawLine(0, i, GAME_PANEL_WIDTH, i);
        }

        g2d.setPaint(Color.RED);
        for(int i = 0; i < x.length; i++){
            g2d.fillRect(x[i], y[i], FRAME_SIZE, FRAME_SIZE);
        }

        for(int i = 0; i < entire.length; i++){
            if(entire[i]){
                int x = i;
                int y;
                if(i>9){
                    x = i % 10;
                }
                if(i<9){
                    y = 0;
                }
                else{
                    y = i / 10;

                }
                g2d.fillRect(x * FRAME_SIZE, y * FRAME_SIZE, FRAME_SIZE, FRAME_SIZE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        for(int i = 0; i < y.length; i++){
            y[i] += FRAME_SIZE;
        }
    }
}
