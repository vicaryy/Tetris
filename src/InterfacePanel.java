import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfacePanel extends JPanel implements ActionListener {
    private int INTERFACE_PANEL_WIDTH;
    private int INTERFACE_PANEL_HEIGHT;
    private int INTERFACE_PANEL_X;
    private int INTERFACE_PANEL_Y;
    private int scorePanel_height;
    private int nextBlockPanel_height;
    private int linePanel_height;
    private int levelPanel_height;
    GamePanel gamePanel;
    Timer timer;
    JPanel scorePanel;
    NextBlockPanel nextBlockPanel;
    JPanel linePanel;
    JPanel levelPanel;
    JLabel scoreLabel;
    JLabel nextBlockLabel;
    JLabel lineLabel;
    JLabel levelLabel;
    Font labelFont;
    Font scoreFont;



    InterfacePanel(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        labelFont = new Font("Helvetica Neue", Font.PLAIN, 15);
        scoreFont = new Font("Helvetica Neue", Font.PLAIN, 20);

        INTERFACE_PANEL_WIDTH = gamePanel.getGAME_PANEL_WIDTH()/2;
        INTERFACE_PANEL_HEIGHT = gamePanel.getGAME_PANEL_HEIGHT() - gamePanel.getPANELS_DISTANCE() * 14;

        INTERFACE_PANEL_X = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getPANELS_DISTANCE() * 2;
        INTERFACE_PANEL_Y = gamePanel.getPANELS_DISTANCE() * 8;

        scorePanel_height = INTERFACE_PANEL_HEIGHT/4;
        nextBlockPanel_height = INTERFACE_PANEL_HEIGHT/3 + INTERFACE_PANEL_HEIGHT/8;
        linePanel_height = INTERFACE_PANEL_HEIGHT/6;
        levelPanel_height = INTERFACE_PANEL_HEIGHT/6;


        scoreLabel = new JLabel("SCORE");
        scoreLabel.setFont(labelFont);
        nextBlockLabel = new JLabel("NEXT");
        nextBlockLabel.setFont(labelFont);
        lineLabel = new JLabel("LINE");
        lineLabel.setFont(labelFont);
        levelLabel = new JLabel("LEVEL");
        levelLabel.setFont(labelFont);

        scorePanel = new JPanel();
        scorePanel.setBackground(Color.yellow);
        scorePanel.setBounds(0, 0, INTERFACE_PANEL_WIDTH, scorePanel_height);
        scorePanel.add(scoreLabel);
        scorePanel.setVisible(true);
        scorePanel.setOpaque(true);

        nextBlockPanel = new NextBlockPanel();
        nextBlockPanel.setBackground(Color.RED);
        nextBlockPanel.setBounds(0, scorePanel_height, INTERFACE_PANEL_WIDTH, nextBlockPanel_height);
        nextBlockPanel.add(nextBlockLabel);

        linePanel = new JPanel();
        linePanel.setBackground(Color.CYAN);
        linePanel.setBounds(0, scorePanel_height + nextBlockPanel_height, INTERFACE_PANEL_WIDTH, linePanel_height);
        linePanel.add(lineLabel);

        levelPanel = new JPanel();
        levelPanel.setBackground(Color.GREEN);
        levelPanel.setBounds(0,  scorePanel_height + nextBlockPanel_height + linePanel_height, INTERFACE_PANEL_WIDTH, levelPanel_height);
        levelPanel.add(levelLabel);


        this.setBackground(new Color(10,10,10));
        this.setLayout(null);
        this.add(scorePanel);
        this.add(nextBlockPanel);
        this.add(linePanel);
        this.add(levelPanel);
        this.setBounds(INTERFACE_PANEL_X, INTERFACE_PANEL_Y, INTERFACE_PANEL_WIDTH, INTERFACE_PANEL_HEIGHT);


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

    public int getINTERFACE_PANEL_WIDTH() {
        return INTERFACE_PANEL_WIDTH;
    }

    public int getINTERFACE_PANEL_HEIGHT() {
        return INTERFACE_PANEL_HEIGHT;
    }
}
