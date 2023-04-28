public class AdditionalFeatures {
    GamePanel gamePanel;
    MainPanel mainPanel;
    boolean rightWallComplete;
    boolean leftWallComplete;
    boolean bottomWallComplete;
    boolean bottomWallForTetrisComplete;
    long rightWallTime = System.currentTimeMillis();
    long leftWallTime = System.currentTimeMillis();
    long bottomWallTime = System.currentTimeMillis();
    long bottomWallForTetrisTime = System.currentTimeMillis();

    AdditionalFeatures(GamePanel gamePanel, MainPanel mainPanel) {
        this.gamePanel = gamePanel;
        this.mainPanel = mainPanel;
    }

    public void pushRightWall() {
        if (!rightWallComplete && System.currentTimeMillis() - rightWallTime > 5) {
            gamePanel.setPANELS_DISTANCE_X(gamePanel.getPANELS_DISTANCE_X() + 1);
            gamePanel.rectangle_x++;
            rightWallTime = System.currentTimeMillis();

            if (gamePanel.getPANELS_DISTANCE_X() - gamePanel.getPANELS_DISTANCE() == 5) {
                rightWallComplete = true;
            }
        } else if (rightWallComplete && System.currentTimeMillis() - rightWallTime > 50) {
            gamePanel.setPANELS_DISTANCE_X(gamePanel.getPANELS_DISTANCE_X() - 1);
            gamePanel.rectangle_x--;
            rightWallTime = System.currentTimeMillis();

            if (gamePanel.getPANELS_DISTANCE_X() - gamePanel.getPANELS_DISTANCE() == 0) {
                rightWallComplete = false;
                gamePanel.pushRightWall = false;
            }
        }
        gamePanel.setBounds(gamePanel.getPANELS_DISTANCE_X(), gamePanel.getPANELS_DISTANCE_Y(), gamePanel.getGAME_PANEL_WIDTH(), gamePanel.getGAME_PANEL_HEIGHT());
    }

    public void pushLeftWall() {
        if (!leftWallComplete && System.currentTimeMillis() - leftWallTime > 5) {
            gamePanel.setPANELS_DISTANCE_X(gamePanel.getPANELS_DISTANCE_X() - 1);
            gamePanel.rectangle_x--;
            leftWallTime = System.currentTimeMillis();

            if (gamePanel.getPANELS_DISTANCE_X() - gamePanel.getPANELS_DISTANCE() == -5) {
                leftWallComplete = true;
            }
        } else if (leftWallComplete && System.currentTimeMillis() - leftWallTime > 50) {
            gamePanel.setPANELS_DISTANCE_X(gamePanel.getPANELS_DISTANCE_X() + 1);
            gamePanel.rectangle_x++;
            leftWallTime = System.currentTimeMillis();

            if (gamePanel.getPANELS_DISTANCE_X() - gamePanel.getPANELS_DISTANCE() == 0) {
                leftWallComplete = false;
                gamePanel.pushLeftWall = false;
            }
        }
        gamePanel.setBounds(gamePanel.getPANELS_DISTANCE_X(), gamePanel.getPANELS_DISTANCE_Y(), gamePanel.getGAME_PANEL_WIDTH(), gamePanel.getGAME_PANEL_HEIGHT());
    }

    public void pushBottomWall() {
        if (!bottomWallComplete && System.currentTimeMillis() - bottomWallTime > 5) {
            gamePanel.setPANELS_DISTANCE_Y(gamePanel.getPANELS_DISTANCE_Y() + 1);
            gamePanel.rectangle_y++;
            bottomWallTime = System.currentTimeMillis();
            if (gamePanel.getPANELS_DISTANCE_Y() - gamePanel.getPANELS_DISTANCE() == 5) {
                bottomWallComplete = true;
            }

        } else if (bottomWallComplete && System.currentTimeMillis() - bottomWallTime > 50) {
            gamePanel.setPANELS_DISTANCE_Y(gamePanel.getPANELS_DISTANCE_Y() - 1);
            gamePanel.rectangle_y--;
            bottomWallTime = System.currentTimeMillis();

            if (gamePanel.getPANELS_DISTANCE_Y() - gamePanel.getPANELS_DISTANCE() == 0) {
                bottomWallComplete = false;
                gamePanel.pushBottomWall = false;
            }
        }
        gamePanel.setBounds(gamePanel.getPANELS_DISTANCE_X(), gamePanel.getPANELS_DISTANCE_Y(), gamePanel.getGAME_PANEL_WIDTH(), gamePanel.getGAME_PANEL_HEIGHT());
    }

    public void pushBottomWallForTetris() {
        if (!bottomWallForTetrisComplete && System.currentTimeMillis() - bottomWallForTetrisTime > 5) {
            gamePanel.setPANELS_DISTANCE_Y(gamePanel.getPANELS_DISTANCE_Y() + 1);
            gamePanel.rectangle_y++;
            bottomWallForTetrisTime = System.currentTimeMillis();

            if (gamePanel.getPANELS_DISTANCE_Y() - gamePanel.getPANELS_DISTANCE() == 17) {
                bottomWallForTetrisComplete = true;
            }

        } else if (bottomWallForTetrisComplete && System.currentTimeMillis() - bottomWallForTetrisTime > 30) {
            gamePanel.setPANELS_DISTANCE_Y(gamePanel.getPANELS_DISTANCE_Y() - 1);
            gamePanel.rectangle_y--;
            bottomWallForTetrisTime = System.currentTimeMillis();

            if (gamePanel.getPANELS_DISTANCE_Y() - gamePanel.getPANELS_DISTANCE() == 0) {
                bottomWallForTetrisComplete = false;
                gamePanel.pushBottomWallForTetris = false;
                gamePanel.pushBottomWall = false;
            }
        }
        gamePanel.setBounds(gamePanel.getPANELS_DISTANCE_X(), gamePanel.getPANELS_DISTANCE_Y(), gamePanel.getGAME_PANEL_WIDTH(), gamePanel.getGAME_PANEL_HEIGHT());
    }
}
