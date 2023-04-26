import javax.swing.*;
import javax.swing.border.LineBorder;
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
    private int distanceBetweenPanels;
    private int labelFontSize;
    private int scoreFontSize;
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
    JTextField scoreField;
    JTextField lineField;
    JTextField levelField;
    Font labelFont;
    Font scoreFont;



    InterfacePanel(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        labelFontSize = gamePanel.getGAME_PANEL_WIDTH()/14;
        scoreFontSize = gamePanel.getGAME_PANEL_WIDTH()/8 - gamePanel.getGAME_PANEL_WIDTH()/100;

        INTERFACE_PANEL_WIDTH = gamePanel.getGAME_PANEL_WIDTH()/2;
        INTERFACE_PANEL_HEIGHT = gamePanel.getGAME_PANEL_HEIGHT() - gamePanel.getPANELS_DISTANCE() * 12;

        INTERFACE_PANEL_X = gamePanel.getGAME_PANEL_WIDTH() + gamePanel.getPANELS_DISTANCE() * 2;
        INTERFACE_PANEL_Y = gamePanel.getPANELS_DISTANCE() * 8;

        scorePanel_height = INTERFACE_PANEL_HEIGHT/4;
        nextBlockPanel_height = INTERFACE_PANEL_HEIGHT/3 + INTERFACE_PANEL_HEIGHT/12;
        linePanel_height = INTERFACE_PANEL_HEIGHT/6;
        levelPanel_height = INTERFACE_PANEL_HEIGHT/6;

        distanceBetweenPanels = gamePanel.getPANELS_DISTANCE()/2;

        //FONTS
        labelFont = new Font("Helvetica Neue", 1, labelFontSize);
        scoreFont = new Font("Helvetica Neue", 1, scoreFontSize);


        //LABELS
        scoreLabel = new JLabel("SCORE");
        scoreLabel.setFont(labelFont);
        scoreLabel.setPreferredSize(new Dimension(INTERFACE_PANEL_WIDTH, scorePanel_height/4 - distanceBetweenPanels));
        scoreLabel.setBorder(new LineBorder(Color.BLACK));
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);

        nextBlockLabel = new JLabel("NEXT");
        nextBlockLabel.setFont(labelFont);
        nextBlockLabel.setPreferredSize(new Dimension(INTERFACE_PANEL_WIDTH, nextBlockPanel_height/4 - distanceBetweenPanels));
        nextBlockLabel.setBorder(new LineBorder(Color.BLACK));
        nextBlockLabel.setHorizontalAlignment(JLabel.CENTER);


        lineLabel = new JLabel("LINE");
        lineLabel.setFont(labelFont);
        lineLabel.setPreferredSize(new Dimension(INTERFACE_PANEL_WIDTH, linePanel_height/4 - distanceBetweenPanels));
        lineLabel.setBorder(new LineBorder(Color.BLACK));
        lineLabel.setHorizontalAlignment(JLabel.CENTER);
        lineLabel.setVerticalAlignment(JLabel.CENTER);

        levelLabel = new JLabel("LEVEL");
        levelLabel.setFont(labelFont);
        levelLabel.setPreferredSize(new Dimension(INTERFACE_PANEL_WIDTH, levelPanel_height/4 - distanceBetweenPanels));
        levelLabel.setBorder(new LineBorder(Color.BLACK));
        levelLabel.setHorizontalAlignment(JLabel.CENTER);


        scoreField = new JTextField("9999999");
        scoreField.setFont(scoreFont);

        lineField = new JTextField("40");
        lineField.setFont(labelFont);

        levelField = new JTextField("10");
        levelField.setFont(labelFont);


        //FIELDS
        scoreField.setHorizontalAlignment(JTextField.RIGHT);
        scoreField.setPreferredSize(new Dimension(INTERFACE_PANEL_WIDTH, INTERFACE_PANEL_HEIGHT/6));
        scoreField.setVisible(true);

        lineField.setHorizontalAlignment(JTextField.CENTER);
        lineField.setPreferredSize(new Dimension(INTERFACE_PANEL_WIDTH, linePanel_height/2 - distanceBetweenPanels));
        lineField.setVisible(true);

        levelField.setHorizontalAlignment(JTextField.CENTER);
        levelField.setPreferredSize(new Dimension(INTERFACE_PANEL_WIDTH, levelPanel_height/2 - distanceBetweenPanels));
        levelField.setVisible(true);


        //PANELS
        scorePanel = new JPanel();
        scorePanel.setBackground(Color.yellow);
        scorePanel.setBounds(distanceBetweenPanels, distanceBetweenPanels, INTERFACE_PANEL_WIDTH - distanceBetweenPanels * 2, scorePanel_height - distanceBetweenPanels * 2);
        scorePanel.add(scoreLabel);
        scorePanel.add(scoreField);
        scorePanel.setVisible(true);
        scorePanel.setOpaque(true);

        nextBlockPanel = new NextBlockPanel(gamePanel);
        nextBlockPanel.setBackground(Color.RED);
        nextBlockPanel.setBounds(distanceBetweenPanels, scorePanel_height + distanceBetweenPanels, INTERFACE_PANEL_WIDTH - distanceBetweenPanels * 2, nextBlockPanel_height - distanceBetweenPanels * 2);
        nextBlockPanel.add(nextBlockLabel);

        linePanel = new JPanel();
        linePanel.setBackground(Color.CYAN);
        linePanel.setBounds(distanceBetweenPanels, scorePanel_height + nextBlockPanel_height + distanceBetweenPanels, INTERFACE_PANEL_WIDTH - distanceBetweenPanels * 2, linePanel_height - distanceBetweenPanels * 2);
        linePanel.add(lineLabel);
        linePanel.add(lineField);

        levelPanel = new JPanel();
        levelPanel.setBackground(Color.GREEN);
        levelPanel.setBounds(distanceBetweenPanels,  scorePanel_height + nextBlockPanel_height + linePanel_height + distanceBetweenPanels, INTERFACE_PANEL_WIDTH - distanceBetweenPanels * 2, levelPanel_height - distanceBetweenPanels * 2);
        levelPanel.add(levelLabel);
        levelPanel.add(levelField);


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
