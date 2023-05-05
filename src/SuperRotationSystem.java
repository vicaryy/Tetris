import java.util.List;

public class SuperRotationSystem {
    GamePanel gamePanel;

    SuperRotationSystem(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }


    public void SRS(int typeOfBlock, int blockDirection, boolean clockwise) {
        if (clockwise) gamePanel.switchBlockDirectionClockwise();
        else gamePanel.switchBlockDirectionCounterClockwise();

        switch (typeOfBlock) {
            case 0 -> {
                // 1 2 3 4
                //   = =
                //   = =
                //
            }
            case 1 -> {
                // 1 2 3 4
                //
                // + = = =
                //
                //
                switch (blockDirection) {
                    case 0 -> {
                        //NORTH
                        if (clockwise) {
                            boolean collision = false;
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveLeft(2);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    gamePanel.moveRight(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        gamePanel.moveLeft(3);
                                        gamePanel.moveDown(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            gamePanel.moveRight(3);
                                            gamePanel.moveUp(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                            if (collision) {
                                                gamePanel.moveLeft(1);
                                                gamePanel.moveDown(2);
                                                gamePanel.switchBlockDirectionCounterClockwise();
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            boolean collision = false;
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveLeft(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    gamePanel.moveRight(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        gamePanel.moveLeft(3);
                                        gamePanel.moveUp(2);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            gamePanel.moveRight(3);
                                            gamePanel.moveDown(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                            if (collision) {
                                                gamePanel.moveLeft(2);
                                                gamePanel.moveUp(1);
                                                gamePanel.switchBlockDirectionClockwise();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    case 1 -> {
                        //EAST
                        if (clockwise) {
                            boolean collision = false;
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveLeft(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    gamePanel.moveRight(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        gamePanel.moveLeft(3);
                                        gamePanel.moveUp(2);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            gamePanel.moveRight(3);
                                            gamePanel.moveDown(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                            if (collision) {
                                                gamePanel.moveLeft(2);
                                                gamePanel.moveUp(1);
                                                gamePanel.switchBlockDirectionCounterClockwise();
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            boolean collision = false;
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveRight(2);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    gamePanel.moveLeft(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        gamePanel.moveRight(3);
                                        gamePanel.moveUp(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            gamePanel.moveLeft(3);
                                            gamePanel.moveDown(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                            if (collision) {
                                                gamePanel.moveRight(1);
                                                gamePanel.moveUp(2);
                                                gamePanel.switchBlockDirectionClockwise();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    case 2 -> {
                        //SOUTH
                        if (clockwise) {
                            boolean collision = false;
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveRight(2);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    gamePanel.moveLeft(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        gamePanel.moveRight(3);
                                        gamePanel.moveUp(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            gamePanel.moveLeft(3);
                                            gamePanel.moveDown(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                            if (collision) {
                                                gamePanel.moveRight(1);
                                                gamePanel.moveUp(2);
                                                gamePanel.switchBlockDirectionCounterClockwise();
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            boolean collision = false;
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveRight(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    gamePanel.moveLeft(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        gamePanel.moveRight(3);
                                        gamePanel.moveDown(2);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            gamePanel.moveLeft(3);
                                            gamePanel.moveUp(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                            if (collision) {
                                                gamePanel.moveRight(2);
                                                gamePanel.moveDown(1);
                                                gamePanel.switchBlockDirectionClockwise();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    case 3 -> {
                        //WEST
                        if (clockwise) {
                            boolean collision = false;
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveRight(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    gamePanel.moveLeft(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        gamePanel.moveRight(3);
                                        gamePanel.moveDown(2);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            gamePanel.moveLeft(3);
                                            gamePanel.moveUp(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                            if (collision) {
                                                gamePanel.moveRight(2);
                                                gamePanel.moveDown(1);
                                                gamePanel.switchBlockDirectionCounterClockwise();
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            boolean collision = false;
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveLeft(2);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    gamePanel.moveRight(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        gamePanel.moveLeft(3);
                                        gamePanel.moveDown(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            gamePanel.moveRight(3);
                                            gamePanel.moveUp(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                            if (collision) {
                                                gamePanel.moveLeft(1);
                                                gamePanel.moveDown(2);
                                                gamePanel.switchBlockDirectionClockwise();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            case 2 -> {
                // 1 2 3
                //   =
                // = = 4
                //
                boolean checkTSpin = true;
                switch (blockDirection) {
                    case 0 -> {
                        //NORTH
                        boolean collision = false;
                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                        if (collision) {
                            if (clockwise) gamePanel.moveLeft(1);
                            else gamePanel.moveRight(1);
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveUp(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    gamePanel.moveDown(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        if (clockwise) gamePanel.moveRight(1);
                                        else gamePanel.moveLeft(1);
                                        gamePanel.moveUp(2);
                                        if (clockwise) gamePanel.switchBlockDirectionCounterClockwise();
                                        else gamePanel.switchBlockDirectionClockwise();
                                        checkTSpin = false;
                                    }
                                }
                            }
                        }
                        if(checkTSpin) gamePanel.tSpinCollision();
                    }

                    case 1 -> {
                        //EAST
                        boolean collision = false;
                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                        if (collision) {
                            gamePanel.moveRight(1);
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveDown(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    gamePanel.moveLeft(1);
                                    gamePanel.moveUp(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        gamePanel.moveRight(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            gamePanel.moveLeft(1);
                                            gamePanel.moveDown(2);
                                            if (clockwise) gamePanel.switchBlockDirectionCounterClockwise();
                                            else gamePanel.switchBlockDirectionClockwise();
                                            checkTSpin = false;
                                        }
                                    }
                                }
                            }
                        }
                        if(checkTSpin) gamePanel.tSpinCollision();
                    }

                    case 2 -> {
                        //SOUTH
                        boolean collision = false;
                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                        if (collision) {
                            if (clockwise) gamePanel.moveRight(1);
                            else gamePanel.moveLeft(1);
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                if (clockwise) gamePanel.moveLeft(1);
                                else gamePanel.moveRight(1);
                                gamePanel.moveDown(2);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    if (clockwise) gamePanel.moveRight(1);
                                    else gamePanel.moveLeft(1);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        if (clockwise) gamePanel.moveLeft(1);
                                        else gamePanel.moveRight(1);
                                        gamePanel.moveUp(2);
                                        if (clockwise) gamePanel.switchBlockDirectionCounterClockwise();
                                        else gamePanel.switchBlockDirectionClockwise();
                                        checkTSpin = false;
                                    }
                                }
                            }
                        }
                        if(checkTSpin) gamePanel.tSpinCollision();
                    }

                    case 3 -> {
                        //WEST
                        boolean collision = false;
                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                        if (collision) {
                            gamePanel.moveLeft(1);
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveDown(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    gamePanel.moveRight(1);
                                    gamePanel.moveUp(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        gamePanel.moveLeft(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            gamePanel.moveRight(1);
                                            gamePanel.moveDown(2);
                                            if (clockwise) gamePanel.switchBlockDirectionCounterClockwise();
                                            else gamePanel.switchBlockDirectionClockwise();
                                            checkTSpin = false;
                                        }
                                    }
                                }
                            }
                        }
                        if(checkTSpin) gamePanel.tSpinCollision();
                    }
                }
            }

            case 3, 4 -> {
                // 1 2 3    // 1 2 3
                //     =    // =
                // = = =    // = = =
                //          //
                switch (blockDirection) {
                    case 0 -> {
                        //NORTH
                        boolean collision = false;
                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                        if (collision) {
                            if (clockwise) gamePanel.moveLeft(1);
                            else gamePanel.moveRight(1);
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveUp(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    if (clockwise) gamePanel.moveRight(1);
                                    else gamePanel.moveLeft(1);
                                    gamePanel.moveDown(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        if (clockwise) gamePanel.moveLeft(1);
                                        else gamePanel.moveRight(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            if (clockwise) gamePanel.moveRight(1);
                                            else gamePanel.moveLeft(1);
                                            gamePanel.moveUp(2);
                                            if (clockwise) gamePanel.switchBlockDirectionCounterClockwise();
                                            else gamePanel.switchBlockDirectionClockwise();
                                        }
                                    }
                                }
                            }
                        }
                    }

                    case 1 -> {
                        //EAST
                        boolean collision = false;
                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                        if (collision) {
                            gamePanel.moveRight(1);
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveDown(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    gamePanel.moveLeft(1);
                                    gamePanel.moveUp(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        gamePanel.moveRight(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            gamePanel.moveLeft(1);
                                            gamePanel.moveDown(2);
                                            if (clockwise) gamePanel.switchBlockDirectionCounterClockwise();
                                            else gamePanel.switchBlockDirectionClockwise();
                                        }
                                    }
                                }
                            }
                        }
                    }

                    case 2 -> {
                        //SOUTH
                        boolean collision = false;
                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                        if (collision) {
                            if (clockwise) gamePanel.moveRight(1);
                            else gamePanel.moveLeft(1);
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveUp(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    if (clockwise) gamePanel.moveLeft(1);
                                    else gamePanel.moveRight(1);
                                    gamePanel.moveDown(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        if (clockwise) gamePanel.moveRight(1);
                                        else gamePanel.moveLeft(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            if (clockwise) gamePanel.moveLeft(1);
                                            else gamePanel.moveRight(1);
                                            gamePanel.moveUp(2);
                                            if (clockwise) gamePanel.switchBlockDirectionCounterClockwise();
                                            else gamePanel.switchBlockDirectionClockwise();
                                        }
                                    }
                                }
                            }
                        }
                    }

                    case 3 -> {
                        //WEST
                        boolean collision = false;
                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                        if (collision) {
                            gamePanel.moveLeft(1);
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveDown(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    gamePanel.moveRight(1);
                                    gamePanel.moveUp(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        gamePanel.moveLeft(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            gamePanel.moveRight(1);
                                            gamePanel.moveDown(2);
                                            if (clockwise) gamePanel.switchBlockDirectionCounterClockwise();
                                            else gamePanel.switchBlockDirectionClockwise();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            case 5, 6 -> {
                // 1 2 3    // 1 2 3
                //   = =    // = =
                // + =      //   = +
                //          //
                switch (blockDirection) {
                    case 0 -> {
                        //NORTH
                        boolean collision = false;
                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                        if (collision) {
                            if (clockwise) gamePanel.moveLeft(1);
                            else gamePanel.moveRight(1);
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveUp(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    if (clockwise) gamePanel.moveRight(1);
                                    else gamePanel.moveLeft(1);
                                    gamePanel.moveDown(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        if (clockwise) gamePanel.moveLeft(1);
                                        else gamePanel.moveRight(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            if (clockwise) gamePanel.moveRight(1);
                                            else gamePanel.moveLeft(1);
                                            gamePanel.moveUp(2);
                                            if (clockwise) gamePanel.switchBlockDirectionCounterClockwise();
                                            else gamePanel.switchBlockDirectionClockwise();
                                        }
                                    }
                                }
                            }
                        }
                    }

                    case 1 -> {
                        //EAST
                        boolean collision = false;
                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                        if (collision) {
                            gamePanel.moveRight(1);
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveDown(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    gamePanel.moveLeft(1);
                                    gamePanel.moveUp(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        gamePanel.moveRight(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            gamePanel.moveLeft(1);
                                            gamePanel.moveDown(2);
                                            if (clockwise) gamePanel.switchBlockDirectionCounterClockwise();
                                            else gamePanel.switchBlockDirectionClockwise();
                                        }
                                    }
                                }
                            }
                        }
                    }

                    case 2 -> {
                        //SOUTH
                        boolean collision = false;
                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                        if (collision) {
                            if (clockwise) gamePanel.moveRight(1);
                            else gamePanel.moveLeft(1);
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveUp(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    if (clockwise) gamePanel.moveLeft(1);
                                    else gamePanel.moveRight(1);
                                    gamePanel.moveDown(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        if (clockwise) gamePanel.moveRight(1);
                                        else gamePanel.moveLeft(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            if (clockwise) gamePanel.moveLeft(1);
                                            else gamePanel.moveRight(1);
                                            gamePanel.moveUp(2);
                                            if (clockwise) gamePanel.switchBlockDirectionCounterClockwise();
                                            else gamePanel.switchBlockDirectionClockwise();
                                        }
                                    }
                                }
                            }
                        }
                    }

                    case 3 -> {
                        //WEST
                        boolean collision = false;
                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                        if (collision) {
                            gamePanel.moveLeft(1);
                            collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                            if (collision) {
                                gamePanel.moveDown(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                if (collision) {
                                    gamePanel.moveRight(1);
                                    gamePanel.moveUp(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                    if (collision) {
                                        gamePanel.moveLeft(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls(false);

                                        if (collision) {
                                            gamePanel.moveLeft(1);
                                            gamePanel.moveDown(2);
                                            if (clockwise) gamePanel.switchBlockDirectionCounterClockwise();
                                            else gamePanel.switchBlockDirectionClockwise();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        gamePanel.checkHighlightBlock();
    }
}