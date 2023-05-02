public class SuperRotationSystem {
    GamePanel gamePanel;

    SuperRotationSystem(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }


//    public void SRS(int typeOfBlock, int blockDirection, boolean clockwise) {
//        switch (typeOfBlock) {
//            case 0 -> {
//                // 1 2 3 4
//                //   = =
//                //   = =
//                //
//            }
//            case 1 -> {
//                // 1 2 3 4
//                //
//                // + = = =
//                //
//                //
//                switch (blockDirection) {
//                    case 0 -> {
//                        //NORTH
//                        if (clockwise) {
//                            boolean collision = false;
//                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                            if (collision) {
//                                gamePanel.moveLeft(2);
//                                collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                if (collision) {
//                                    gamePanel.moveRight(3);
//                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                    if (collision) {
//                                        gamePanel.moveLeft(3);
//                                        gamePanel.moveDown(1);
//                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                        if (collision) {
//                                            gamePanel.moveRight(3);
//                                            gamePanel.moveUp(3);
//                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                            if (collision) {
//                                                gamePanel.moveLeft(1);
//                                                gamePanel.moveDown(2);
//                                                gamePanel.switchBlockDirectionCounterClockwise();
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        } else {
//                            boolean collision = false;
//                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                            if (collision) {
//                                gamePanel.moveLeft(1);
//                                collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                if (collision) {
//                                    gamePanel.moveRight(3);
//                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                    if (collision) {
//                                        gamePanel.moveLeft(3);
//                                        gamePanel.moveUp(2);
//                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                        if (collision) {
//                                            gamePanel.moveRight(3);
//                                            gamePanel.moveDown(3);
//                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                            if (collision) {
//                                                gamePanel.moveLeft(2);
//                                                gamePanel.moveUp(1);
//                                                gamePanel.switchBlockDirectionClockwise();
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    case 1 -> {
//                        //EAST
//                        if (clockwise) {
//                            boolean collision = false;
//                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                            if (collision) {
//                                gamePanel.moveLeft(1);
//                                collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                if (collision) {
//                                    gamePanel.moveRight(3);
//                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                    if (collision) {
//                                        gamePanel.moveLeft(3);
//                                        gamePanel.moveUp(2);
//                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                        if (collision) {
//                                            gamePanel.moveRight(3);
//                                            gamePanel.moveDown(3);
//                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                            if (collision) {
//                                                gamePanel.moveLeft(2);
//                                                gamePanel.moveUp(1);
//                                                gamePanel.switchBlockDirectionCounterClockwise();
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        } else {
//                            boolean collision = false;
//                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                            if (collision) {
//                                gamePanel.moveRight(2);
//                                collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                if (collision) {
//                                    gamePanel.moveLeft(3);
//                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                    if (collision) {
//                                        gamePanel.moveRight(3);
//                                        gamePanel.moveUp(1);
//                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                        if (collision) {
//                                            gamePanel.moveLeft(3);
//                                            gamePanel.moveDown(3);
//                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                            if (collision) {
//                                                gamePanel.moveRight(1);
//                                                gamePanel.moveUp(2);
//                                                gamePanel.switchBlockDirectionClockwise();
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    case 2 -> {
//                        //SOUTH
//                        if (clockwise) {
//                            boolean collision = false;
//                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                            if (collision) {
//                                gamePanel.moveRight(2);
//                                collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                if (collision) {
//                                    gamePanel.moveLeft(3);
//                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                    if (collision) {
//                                        gamePanel.moveRight(3);
//                                        gamePanel.moveUp(1);
//                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                        if (collision) {
//                                            gamePanel.moveLeft(3);
//                                            gamePanel.moveDown(3);
//                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                            if (collision) {
//                                                gamePanel.moveRight(1);
//                                                gamePanel.moveUp(2);
//                                                gamePanel.switchBlockDirectionCounterClockwise();
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        } else {
//                            boolean collision = false;
//                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                            if (collision) {
//                                gamePanel.moveRight(1);
//                                collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                if (collision) {
//                                    gamePanel.moveLeft(3);
//                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                    if (collision) {
//                                        gamePanel.moveRight(3);
//                                        gamePanel.moveDown(2);
//                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                        if (collision) {
//                                            gamePanel.moveLeft(3);
//                                            gamePanel.moveUp(3);
//                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                            if (collision) {
//                                                gamePanel.moveRight(2);
//                                                gamePanel.moveDown(1);
//                                                gamePanel.switchBlockDirectionClockwise();
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    case 3 -> {
//                        //WEST
//                        if (clockwise) {
//                            boolean collision = false;
//                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                            if (collision) {
//                                gamePanel.moveRight(1);
//                                collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                if (collision) {
//                                    gamePanel.moveLeft(3);
//                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                    if (collision) {
//                                        gamePanel.moveRight(3);
//                                        gamePanel.moveDown(2);
//                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                        if (collision) {
//                                            gamePanel.moveLeft(3);
//                                            gamePanel.moveUp(3);
//                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                            if (collision) {
//                                                gamePanel.moveRight(2);
//                                                gamePanel.moveDown(1);
//                                                gamePanel.switchBlockDirectionCounterClockwise();
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        } else {
//                            boolean collision = false;
//                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                            if (collision) {
//                                gamePanel.moveLeft(2);
//                                collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                if (collision) {
//                                    gamePanel.moveRight(3);
//                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                    if (collision) {
//                                        gamePanel.moveLeft(3);
//                                        gamePanel.moveDown(1);
//                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                        if (collision) {
//                                            gamePanel.moveRight(3);
//                                            gamePanel.moveUp(3);
//                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();
//
//                                            if (collision) {
//                                                gamePanel.moveLeft(1);
//                                                gamePanel.moveDown(2);
//                                                gamePanel.switchBlockDirectionClockwise();
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }


    public void SRS(int typeOfBlock, int blockDirection, boolean clockwise) {
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
                        //EAST
                        if (clockwise) {
                            boolean collision = false;
                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

                            if (collision) {
                                gamePanel.moveLeft(2);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                if (collision) {
                                    gamePanel.moveRight(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                    if (collision) {
                                        gamePanel.moveLeft(3);
                                        gamePanel.moveDown(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                        if (collision) {
                                            gamePanel.moveRight(3);
                                            gamePanel.moveUp(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

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
                            //WEST
                            boolean collision = false;
                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

                            if (collision) {
                                gamePanel.moveLeft(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                if (collision) {
                                    gamePanel.moveRight(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                    if (collision) {
                                        gamePanel.moveLeft(3);
                                        gamePanel.moveUp(2);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                        if (collision) {
                                            gamePanel.moveRight(3);
                                            gamePanel.moveDown(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

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
                        //SOUTH
                        if (clockwise) {
                            boolean collision = false;
                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

                            if (collision) {
                                gamePanel.moveLeft(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                if (collision) {
                                    gamePanel.moveRight(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                    if (collision) {
                                        gamePanel.moveLeft(3);
                                        gamePanel.moveUp(2);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                        if (collision) {
                                            gamePanel.moveRight(3);
                                            gamePanel.moveDown(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

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
                            //NORTH
                            boolean collision = false;
                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

                            if (collision) {
                                gamePanel.moveRight(2);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                if (collision) {
                                    gamePanel.moveLeft(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                    if (collision) {
                                        gamePanel.moveRight(3);
                                        gamePanel.moveUp(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                        if (collision) {
                                            gamePanel.moveLeft(3);
                                            gamePanel.moveDown(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

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
                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

                            if (collision) {
                                gamePanel.moveRight(2);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                if (collision) {
                                    gamePanel.moveLeft(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                    if (collision) {
                                        gamePanel.moveRight(3);
                                        gamePanel.moveUp(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                        if (collision) {
                                            gamePanel.moveLeft(3);
                                            gamePanel.moveDown(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

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
                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

                            if (collision) {
                                gamePanel.moveRight(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                if (collision) {
                                    gamePanel.moveLeft(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                    if (collision) {
                                        gamePanel.moveRight(3);
                                        gamePanel.moveDown(2);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                        if (collision) {
                                            gamePanel.moveLeft(3);
                                            gamePanel.moveUp(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

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
                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

                            if (collision) {
                                gamePanel.moveRight(1);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                if (collision) {
                                    gamePanel.moveLeft(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                    if (collision) {
                                        gamePanel.moveRight(3);
                                        gamePanel.moveDown(2);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                        if (collision) {
                                            gamePanel.moveLeft(3);
                                            gamePanel.moveUp(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

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
                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

                            if (collision) {
                                gamePanel.moveLeft(2);
                                collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                if (collision) {
                                    gamePanel.moveRight(3);
                                    collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                    if (collision) {
                                        gamePanel.moveLeft(3);
                                        gamePanel.moveDown(1);
                                        collision = gamePanel.checkCollisionWithBlocksAndWalls();

                                        if (collision) {
                                            gamePanel.moveRight(3);
                                            gamePanel.moveUp(3);
                                            collision = gamePanel.checkCollisionWithBlocksAndWalls();

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
        }
    }


}
