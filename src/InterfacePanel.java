import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfacePanel extends JPanel implements ActionListener {
    Timer timer;
    JPanel scorePanel;
    JLabel scoreLabel;
    JPanel nextBlockPanel;
    JPanel levelPanel;
    JPanel linePanel;
    InterfacePanel(){
        this.setBackground(new Color(10,10,10));
        this.setLayout(null);
        this.setBounds(460,40,250,800);


        timer = new Timer(20,this);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
