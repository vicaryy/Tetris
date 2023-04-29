public class Blocks {
    GamePanel gamePanel;
    Blocks(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void newBlock(int blockNumber, int FRAME_SIZE){

        switch (blockNumber){
            case 0 -> {
                // = = = =
                //
                //
                //
                gamePanel.mobileBlock_x[0] = FRAME_SIZE * 3;
                gamePanel.mobileBlock_x[1] = FRAME_SIZE * 4;
                gamePanel.mobileBlock_x[2] = FRAME_SIZE * 5;
                gamePanel.mobileBlock_x[3] = FRAME_SIZE * 6;

                gamePanel.mobileBlock_y[0] = FRAME_SIZE;
                gamePanel.mobileBlock_y[1] = FRAME_SIZE;
                gamePanel.mobileBlock_y[2] = FRAME_SIZE;
                gamePanel.mobileBlock_y[3] = FRAME_SIZE;
            }
            case 1 -> {
                // =
                // = = =
                //
                //
                gamePanel.mobileBlock_x[0] = FRAME_SIZE * 3;
                gamePanel.mobileBlock_x[1] = FRAME_SIZE * 3;
                gamePanel.mobileBlock_x[2] = FRAME_SIZE * 4;
                gamePanel.mobileBlock_x[3] = FRAME_SIZE * 5;

                gamePanel.mobileBlock_y[0] = 0;
                gamePanel.mobileBlock_y[1] = FRAME_SIZE;
                gamePanel.mobileBlock_y[2] = FRAME_SIZE;
                gamePanel.mobileBlock_y[3] = FRAME_SIZE;
            }
            case 2 -> {
                //     =
                // = = =
                //
                //
                gamePanel.mobileBlock_x[0] = FRAME_SIZE * 5;
                gamePanel.mobileBlock_x[1] = FRAME_SIZE * 5;
                gamePanel.mobileBlock_x[2] = FRAME_SIZE * 4;
                gamePanel.mobileBlock_x[3] = FRAME_SIZE * 3;

                gamePanel.mobileBlock_y[0] = 0;
                gamePanel.mobileBlock_y[1] = FRAME_SIZE;
                gamePanel.mobileBlock_y[2] = FRAME_SIZE;
                gamePanel.mobileBlock_y[3] = FRAME_SIZE;
            }
            case 3 -> {
                // = =
                // = =
                //
                //
                gamePanel.mobileBlock_x[0] = FRAME_SIZE * 4;
                gamePanel.mobileBlock_x[1] = FRAME_SIZE * 4;
                gamePanel.mobileBlock_x[2] = FRAME_SIZE * 5;
                gamePanel.mobileBlock_x[3] = FRAME_SIZE * 5;

                gamePanel.mobileBlock_y[0] = 0;
                gamePanel.mobileBlock_y[1] = FRAME_SIZE;
                gamePanel.mobileBlock_y[2] = 0;
                gamePanel.mobileBlock_y[3] = FRAME_SIZE;
            }
            case 4 -> {
                //   = =
                // + =
                //
                //
                gamePanel.mobileBlock_x[0] = FRAME_SIZE * 3;
                gamePanel.mobileBlock_x[1] = FRAME_SIZE * 4;
                gamePanel.mobileBlock_x[2] = FRAME_SIZE * 4;
                gamePanel.mobileBlock_x[3] = FRAME_SIZE * 5;

                gamePanel.mobileBlock_y[0] = FRAME_SIZE;
                gamePanel.mobileBlock_y[1] = FRAME_SIZE;
                gamePanel.mobileBlock_y[2] = 0;
                gamePanel.mobileBlock_y[3] = 0;
            }
            case 5 -> {
                //   =
                // = = 4
                //
                //
                gamePanel.mobileBlock_x[0] = FRAME_SIZE * 4;
                gamePanel.mobileBlock_x[1] = FRAME_SIZE * 4;
                gamePanel.mobileBlock_x[2] = FRAME_SIZE * 3;
                gamePanel.mobileBlock_x[3] = FRAME_SIZE * 5;

                gamePanel.mobileBlock_y[0] = 0;
                gamePanel.mobileBlock_y[1] = FRAME_SIZE;
                gamePanel.mobileBlock_y[2] = FRAME_SIZE;
                gamePanel.mobileBlock_y[3] = FRAME_SIZE;
            }
            case 6 -> {
                // = =
                //   + =
                //
                //
                gamePanel.mobileBlock_x[0] = FRAME_SIZE * 5;
                gamePanel.mobileBlock_x[1] = FRAME_SIZE * 4;
                gamePanel.mobileBlock_x[2] = FRAME_SIZE * 4;
                gamePanel.mobileBlock_x[3] = FRAME_SIZE * 3;

                gamePanel.mobileBlock_y[0] = FRAME_SIZE;
                gamePanel.mobileBlock_y[1] = FRAME_SIZE;
                gamePanel.mobileBlock_y[2] = 0;
                gamePanel.mobileBlock_y[3] = 0;
            }
        }
        gamePanel.setBlockDirection(0);
    }

    public void switchBlockDirection(int[] block_x, int[] block_y, int blockNumber, int typeOfBlockDirection, int FRAME_SIZE){
        switch(blockNumber){
            case 0 -> {
                if (typeOfBlockDirection == 0) {
                    // 1 2 3 4
                    //   =
                    //   =
                    //   =
                    //   +


                    // WYJATEK -------------------------------------------------------- w osi X PRAWEJ - FRAMESIZE - DONE
                    // 1 2 3 4
                    //
                    // + = = =
                    //
                    //
                    gamePanel.mobileBlock_x[0] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[1] = block_x[1];
                    gamePanel.mobileBlock_x[2] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[3] += FRAME_SIZE * 2;

                    gamePanel.mobileBlock_y[0] -= FRAME_SIZE * 2;
                    gamePanel.mobileBlock_y[1] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[2] = block_y[2];
                    gamePanel.mobileBlock_y[3] += FRAME_SIZE;
                } else if (typeOfBlockDirection == 1) {

                    // WYJATEK -------------------------------------------------------- w osi Y DOL ( -FRAME * 2) - DONE

                    // 1 2 3 4
                    //     +
                    //     =
                    //     =
                    //     =
                    gamePanel.mobileBlock_x[0] += FRAME_SIZE * 2;
                    gamePanel.mobileBlock_x[1] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[2] = block_x[2];
                    gamePanel.mobileBlock_x[3] -= FRAME_SIZE;

                    gamePanel.mobileBlock_y[0] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[1] = block_y[1];
                    gamePanel.mobileBlock_y[2] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[3] += FRAME_SIZE * 2;
                } else if (typeOfBlockDirection == 2) {

                    // WYJATEK -------------------------------------------------------- w osi X LEWO + FRAMESIZE - DONE

                    // 1 2 3 4
                    //
                    //
                    // = = = +
                    //
                    gamePanel.mobileBlock_x[0] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[1] = block_x[1];
                    gamePanel.mobileBlock_x[2] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[3] -= FRAME_SIZE * 2;

                    gamePanel.mobileBlock_y[0] += FRAME_SIZE * 2;
                    gamePanel.mobileBlock_y[1] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[2] = block_y[2];
                    gamePanel.mobileBlock_y[3] -= FRAME_SIZE;
                } else if (typeOfBlockDirection == 3) {

                    // WYJATEK -------------------------------------------------------- w osi Y dół (- FRAME) - DONE
                    // 1 2 3 4
                    //   =
                    //   =
                    //   =
                    //   +
                    gamePanel.mobileBlock_x[0] -= FRAME_SIZE * 2;
                    gamePanel.mobileBlock_x[1] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[2] = block_x[2];
                    gamePanel.mobileBlock_x[3] += FRAME_SIZE;

                    gamePanel.mobileBlock_y[0] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[1] = block_y[1];
                    gamePanel.mobileBlock_y[2] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[3] -= FRAME_SIZE * 2;

                    gamePanel.setBlockDirection(-1);
                }
            }
            case 1 -> {
                if (typeOfBlockDirection == 0) {
                    // 1 2 3
                    //   =
                    //   =
                    // = =


                    // 1 2 3
                    // =
                    // = = =
                    //
                    gamePanel.mobileBlock_x[0] = block_x[0];
                    gamePanel.mobileBlock_x[1] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[2] = block_x[2];
                    gamePanel.mobileBlock_x[3] += FRAME_SIZE;

                    gamePanel.mobileBlock_y[0] -= FRAME_SIZE * 2;
                    gamePanel.mobileBlock_y[1] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[2] = block_y[2];
                    gamePanel.mobileBlock_y[3] += FRAME_SIZE;
                }
                else if(typeOfBlockDirection == 1){
                    // 1 2 3
                    //   = =
                    //   =
                    //   =
                    gamePanel.mobileBlock_x[0] += FRAME_SIZE * 2;
                    gamePanel.mobileBlock_x[1] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[2] = block_x[2];
                    gamePanel.mobileBlock_x[3] -= FRAME_SIZE;

                    gamePanel.mobileBlock_y[0] = block_y[0];
                    gamePanel.mobileBlock_y[1] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[2] = block_y[2];
                    gamePanel.mobileBlock_y[3] += FRAME_SIZE;
                }
                else if(typeOfBlockDirection == 2){
                    // 1 2 3
                    //
                    // = = =
                    //     =
                    gamePanel.mobileBlock_x[0] = block_x[0];
                    gamePanel.mobileBlock_x[1] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[2] = block_x[2];
                    gamePanel.mobileBlock_x[3] -= FRAME_SIZE;

                    gamePanel.mobileBlock_y[0] += FRAME_SIZE * 2;
                    gamePanel.mobileBlock_y[1] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[2] = block_y[2];
                    gamePanel.mobileBlock_y[3] -= FRAME_SIZE;
                }
                else if(typeOfBlockDirection == 3){
                    // 1 2 3
                    //   =
                    //   =
                    // = =
                    gamePanel.mobileBlock_x[0] -= FRAME_SIZE * 2;
                    gamePanel.mobileBlock_x[1] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[2] = block_x[2];
                    gamePanel.mobileBlock_x[3] += FRAME_SIZE;

                    gamePanel.mobileBlock_y[0] = block_y[0];
                    gamePanel.mobileBlock_y[1] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[2] = block_y[2];
                    gamePanel.mobileBlock_y[3] -= FRAME_SIZE;

                    gamePanel.setBlockDirection(-1);
                }
            }
            case 2 -> {
                if (typeOfBlockDirection == 0) {
                    // 1 2 3
                    // = =
                    //   =
                    //   =


                    // 1 2 3
                    //     =
                    // = = =
                    //
                    gamePanel.mobileBlock_x[0] += FRAME_SIZE * 2;
                    gamePanel.mobileBlock_x[1] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[2] = block_x[2];
                    gamePanel.mobileBlock_x[3] -= FRAME_SIZE;

                    gamePanel.mobileBlock_y[0] = block_y[0];
                    gamePanel.mobileBlock_y[1] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[2] = block_y[2];
                    gamePanel.mobileBlock_y[3] -= FRAME_SIZE;
                }
                else if(typeOfBlockDirection == 1){
                    // 1 2 3
                    //   =
                    //   =
                    //   = =
                    gamePanel.mobileBlock_x[0] = block_x[0];
                    gamePanel.mobileBlock_x[1] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[2] = block_x[2];
                    gamePanel.mobileBlock_x[3] += FRAME_SIZE;

                    gamePanel.mobileBlock_y[0] += FRAME_SIZE * 2;
                    gamePanel.mobileBlock_y[1] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[2] = block_y[2];
                    gamePanel.mobileBlock_y[3] -= FRAME_SIZE;
                }
                else if(typeOfBlockDirection == 2){
                    // 1 2 3
                    //
                    // = = =
                    // =
                    gamePanel.mobileBlock_x[0] -= FRAME_SIZE * 2;
                    gamePanel.mobileBlock_x[1] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[2] = block_x[2];
                    gamePanel.mobileBlock_x[3] += FRAME_SIZE;

                    gamePanel.mobileBlock_y[0] = block_y[0];
                    gamePanel.mobileBlock_y[1] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[2] = block_y[2];
                    gamePanel.mobileBlock_y[3] += FRAME_SIZE;
                }
                else if(typeOfBlockDirection == 3){
                    // 1 2 3
                    // = =
                    //   =
                    //   =
                    gamePanel.mobileBlock_x[0] = block_x[0];
                    gamePanel.mobileBlock_x[1] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[2] = block_x[2];
                    gamePanel.mobileBlock_x[3] -= FRAME_SIZE;

                    gamePanel.mobileBlock_y[0] -= FRAME_SIZE * 2;
                    gamePanel.mobileBlock_y[1] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[2] = block_y[2];
                    gamePanel.mobileBlock_y[3] += FRAME_SIZE;

                    gamePanel.setBlockDirection(-1);
                }
            }
            case 3 -> {
                //
                //  = =
                //  = =
                //
            }
            case 4 -> {
                if (typeOfBlockDirection == 0) {
                    // 1 2 3
                    // =
                    // = =
                    //   +

                    // 1 2 3
                    //   = =
                    // + =
                    //
                    gamePanel.mobileBlock_x[0] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[1] = block_x[1];
                    gamePanel.mobileBlock_x[2] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[3] += FRAME_SIZE * 2;

                    gamePanel.mobileBlock_y[0] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[1] = block_y[1];
                    gamePanel.mobileBlock_y[2] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[3] = block_y[3];
                }
                else if(typeOfBlockDirection == 1){
                    // 1 2 3
                    //   +
                    //   = =
                    //     =
                    gamePanel.mobileBlock_x[0] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[1] = block_x[1];
                    gamePanel.mobileBlock_x[2] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[3] = block_x[3];

                    gamePanel.mobileBlock_y[0] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[1] = block_y[1];
                    gamePanel.mobileBlock_y[2] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[3] += FRAME_SIZE * 2;
                }
                else if(typeOfBlockDirection == 2){
                    // 1 2 3
                    //
                    //   = +
                    // = =
                    gamePanel.mobileBlock_x[0] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[1] = block_x[1];
                    gamePanel.mobileBlock_x[2] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[3] -= FRAME_SIZE * 2;

                    gamePanel.mobileBlock_y[0] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[1] = block_y[1];
                    gamePanel.mobileBlock_y[2] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[3] = block_y[3];
                }
                else if(typeOfBlockDirection == 3){
                    // 1 2 3
                    // =
                    // = =
                    //   +
                    gamePanel.mobileBlock_x[0] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[1] = block_x[1];
                    gamePanel.mobileBlock_x[2] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[3] = block_x[3];

                    gamePanel.mobileBlock_y[0] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[1] = block_y[1];
                    gamePanel.mobileBlock_y[2] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[3] -= FRAME_SIZE * 2;

                    gamePanel.setBlockDirection(-1);
                }
            }
            case 5 -> {
                if (typeOfBlockDirection == 0) {
                    // 1 2 3
                    //   4
                    // = =
                    //   =

                    // 1 2 3
                    //   =
                    // = = 4
                    //
                    gamePanel.mobileBlock_x[0] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[1] = block_x[1];
                    gamePanel.mobileBlock_x[2] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[3] += FRAME_SIZE;

                    gamePanel.mobileBlock_y[0] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[1] = block_y[1];
                    gamePanel.mobileBlock_y[2] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[3] += FRAME_SIZE;
                }
                else if(typeOfBlockDirection == 1){
                    // 1 2 3
                    //   =
                    //   = =
                    //   4
                    gamePanel.mobileBlock_x[0] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[1] = block_x[1];
                    gamePanel.mobileBlock_x[2] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[3] -= FRAME_SIZE;

                    gamePanel.mobileBlock_y[0] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[1] = block_y[1];
                    gamePanel.mobileBlock_y[2] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[3] += FRAME_SIZE;
                }
                else if(typeOfBlockDirection == 2){
                    // 1 2 3
                    //
                    // 4 = =
                    //   =
                    gamePanel.mobileBlock_x[0] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[1] = block_x[1];
                    gamePanel.mobileBlock_x[2] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[3] -= FRAME_SIZE;

                    gamePanel.mobileBlock_y[0] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[1] = block_y[1];
                    gamePanel.mobileBlock_y[2] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[3] -= FRAME_SIZE;
                }
                else if(typeOfBlockDirection == 3){
                    // 1 2 3
                    //   4
                    // = =
                    //   =
                    gamePanel.mobileBlock_x[0] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[1] = block_x[1];
                    gamePanel.mobileBlock_x[2] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[3] += FRAME_SIZE;

                    gamePanel.mobileBlock_y[0] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[1] = block_y[1];
                    gamePanel.mobileBlock_y[2] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[3] -= FRAME_SIZE;

                    gamePanel.setBlockDirection(-1);
                }
            }
            case 6 -> {
                if (typeOfBlockDirection == 0) {
                    // 1 2 3
                    //   =
                    // = +
                    // =

                    // 1 2 3
                    // = =
                    //   + =
                    //
                    gamePanel.mobileBlock_x[0] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[1] = block_x[1];
                    gamePanel.mobileBlock_x[2] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[3] = block_x[3];

                    gamePanel.mobileBlock_y[0] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[1] = block_y[1];
                    gamePanel.mobileBlock_y[2] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[3] -= FRAME_SIZE * 2;
                }
                else if(typeOfBlockDirection == 1){
                    // 1 2 3
                    //     =
                    //   + =
                    //   =
                    gamePanel.mobileBlock_x[0] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[1] = block_x[1];
                    gamePanel.mobileBlock_x[2] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[3] += FRAME_SIZE * 2;

                    gamePanel.mobileBlock_y[0] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[1] = block_y[1];
                    gamePanel.mobileBlock_y[2] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[3] = block_y[3];
                }
                else if(typeOfBlockDirection == 2){
                    // 1 2 3
                    //
                    // = +
                    //   = =
                    gamePanel.mobileBlock_x[0] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[1] = block_x[1];
                    gamePanel.mobileBlock_x[2] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[3] = block_x[3];

                    gamePanel.mobileBlock_y[0] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[1] = block_y[1];
                    gamePanel.mobileBlock_y[2] += FRAME_SIZE;
                    gamePanel.mobileBlock_y[3] += FRAME_SIZE * 2;
                }
                else if(typeOfBlockDirection == 3){
                    // 1 2 3
                    //   =
                    // = +
                    // =
                    gamePanel.mobileBlock_x[0] += FRAME_SIZE;
                    gamePanel.mobileBlock_x[1] = block_x[1];
                    gamePanel.mobileBlock_x[2] -= FRAME_SIZE;
                    gamePanel.mobileBlock_x[3] -= FRAME_SIZE * 2;

                    gamePanel.mobileBlock_y[0] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[1] = block_y[1];
                    gamePanel.mobileBlock_y[2] -= FRAME_SIZE;
                    gamePanel.mobileBlock_y[3] = block_y[3];

                    gamePanel.setBlockDirection(-1);
                }
            }
        }
    }
}
