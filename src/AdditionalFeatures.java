public class AdditionalFeatures {
    GamePanel gamePanel;
    MainPanel mainPanel;
    boolean rightWallComplete;
    boolean leftWallComplete;
    boolean bottomWallComplete;
    boolean bottomWallForTetrisComplete;
    int rightWallProgress = 0;
    int leftWallProgress = 0;
    int bottomWallProgress = 0;
    int bottomWallForTetrisProgress = 0;
    int leftRightProgress = 3;
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
            rightWallProgress++;
            rightWallTime = System.currentTimeMillis();

            if (rightWallProgress == gamePanel.getGAME_PANEL_WIDTH() / 80) {
                rightWallComplete = true;
            }
        } else if (rightWallComplete && System.currentTimeMillis() - rightWallTime > 50) {
            gamePanel.setPANELS_DISTANCE_X(gamePanel.getPANELS_DISTANCE_X() - 1);
            gamePanel.rectangle_x--;
            rightWallProgress--;
            rightWallTime = System.currentTimeMillis();

            if (rightWallProgress == 0) {
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
            leftWallProgress--;
            leftWallTime = System.currentTimeMillis();

            if (leftWallProgress == -gamePanel.getGAME_PANEL_WIDTH() / 80) {
                leftWallComplete = true;
            }
        } else if (leftWallComplete && System.currentTimeMillis() - leftWallTime > 50) {
            gamePanel.setPANELS_DISTANCE_X(gamePanel.getPANELS_DISTANCE_X() + 1);
            gamePanel.rectangle_x++;
            leftWallProgress++;
            leftWallTime = System.currentTimeMillis();

            if (leftWallProgress == 0) {
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
            bottomWallProgress++;
            bottomWallTime = System.currentTimeMillis();
            if (bottomWallProgress == gamePanel.getGAME_PANEL_WIDTH() / 80) {
                bottomWallComplete = true;
            }

        } else if (bottomWallComplete && System.currentTimeMillis() - bottomWallTime > 50) {
            gamePanel.setPANELS_DISTANCE_Y(gamePanel.getPANELS_DISTANCE_Y() - 1);
            gamePanel.rectangle_y--;
            bottomWallProgress--;
            bottomWallTime = System.currentTimeMillis();

            if (bottomWallProgress == 0) {
                bottomWallComplete = false;
                gamePanel.pushBottomWall = false;
            }
        }
        gamePanel.setBounds(gamePanel.getPANELS_DISTANCE_X(), gamePanel.getPANELS_DISTANCE_Y(), gamePanel.getGAME_PANEL_WIDTH(), gamePanel.getGAME_PANEL_HEIGHT());
    }

    public void pushBottomWallForTetris() {
        if (!bottomWallForTetrisComplete && System.currentTimeMillis() - bottomWallForTetrisTime > 5) {
            bottomWallForTetrisTime = System.currentTimeMillis();
            gamePanel.setPANELS_DISTANCE_Y(gamePanel.getPANELS_DISTANCE_Y() + 1);
            gamePanel.rectangle_y++;
            bottomWallForTetrisProgress++;

            if (bottomWallForTetrisProgress == gamePanel.getGAME_PANEL_WIDTH() / 24) {
                bottomWallForTetrisComplete = true;
            }

        } else if (bottomWallForTetrisComplete && System.currentTimeMillis() - bottomWallForTetrisTime > 30) {
            gamePanel.setPANELS_DISTANCE_Y(gamePanel.getPANELS_DISTANCE_Y() - 1);
            gamePanel.rectangle_y--;
            bottomWallForTetrisProgress--;
            bottomWallForTetrisTime = System.currentTimeMillis();

            if (bottomWallForTetrisProgress == 0) {
                bottomWallForTetrisComplete = false;
                gamePanel.pushBottomWallForTetris = false;
                gamePanel.pushBottomWall = false;
            }
        }
        gamePanel.setBounds(gamePanel.getPANELS_DISTANCE_X(), gamePanel.getPANELS_DISTANCE_Y(), gamePanel.getGAME_PANEL_WIDTH(), gamePanel.getGAME_PANEL_HEIGHT());
    }

    public void moveWallsByLeftRight(char direction) {
        switch (direction) {
            case 'R' -> {
                if (leftRightProgress < 1) {
                    gamePanel.setPANELS_DISTANCE_X(gamePanel.getPANELS_DISTANCE_X() + 1);
                    gamePanel.rectangle_x++;
                    leftRightProgress++;
                }
            }
            case 'L' -> {
                if (leftRightProgress > -1) {
                    gamePanel.setPANELS_DISTANCE_X(gamePanel.getPANELS_DISTANCE_X() - 1);
                    gamePanel.rectangle_x--;
                    leftRightProgress--;
                }
            }
        }
        gamePanel.setBounds(gamePanel.getPANELS_DISTANCE_X(), gamePanel.getPANELS_DISTANCE_Y(), gamePanel.getGAME_PANEL_WIDTH(), gamePanel.getGAME_PANEL_HEIGHT());
    }
}
