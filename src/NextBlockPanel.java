import javax.swing.*;
import java.awt.*;

public class NextBlockPanel extends JPanel {
    NextBlockPanel(){
        this.setBackground(Color.WHITE);
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.fillRect(100,50,30,30);
    }
}
