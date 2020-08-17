package com.ttt;

class Board{
    String[][] board;
    private String winner;
    Board(){
        board = new String[3][3];
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){ board[r][c] = " "; }
        }
        winner = " ";

        printBoard();
    }

    void changeAndPrint(int row, int col, String piece){
        board[row][col] = piece;
        printBoard();
    }

    private void printBoard(){
        String divider = "---+---+---";
        System.out.println(String.format(" %s | %s | %s ", board[0][0], board[0][1], board[0][2]));
        System.out.println(divider);
        System.out.println(String.format(" %s | %s | %s ", board[1][0], board[1][1], board[1][2]));
        System.out.println(divider);
        System.out.println(String.format(" %s | %s | %s ", board[2][0], board[2][1], board[2][2]));
    }

    boolean checkWinner(){
        return (checkHoriz() || checkVert() || checkDiag());
    }

    void declareWinner(){
        System.out.println(String.format("Congratulations Player %s! You Won!!!", winner));
        endGame();
    }

    private boolean checkHoriz(){
        String topLeft = board[0][0];
        String bottomLeft = board[2][0];
        String middle = board[1][0];

        if(board[0][1].equals(topLeft) && board[0][2].equals(topLeft) && !topLeft.equals(" ")){
            winner = board[0][0];
            return true;
        }
        else if(board[2][1].equals(bottomLeft) && board[2][2].equals(bottomLeft) && !bottomLeft.equals(" ")){
            winner = bottomLeft;
            return true;
        }
        else if(board[1][1].equals(middle) && board[1][2].equals(middle) && !middle.equals(" ")){
            winner = middle;
            return true;
        }
        else{return false;}
    }

    private boolean checkVert(){
        String topLeft = board[0][0];
        String middle = board[0][1];
        String topRight = board[0][2];

        if(board[1][0].equals(topLeft) && board[2][0].equals(topLeft) && !topLeft.equals(" ")){
            winner = topLeft;
            return true;
        }
        else if(board[1][1].equals(middle) && board[2][1].equals(middle) && !middle.equals(" ")){
            winner = middle;
            return true;
        }
        else if(board[1][2].equals(topRight) && board[2][2].equals(topRight) && !topRight.equals(" ")){
            winner = topRight;
            return true;
        }
        else{return false;}
    }

    private boolean checkDiag(){
        String topLeft = board[0][0];
        String topRight = board[0][2];

        if(board[1][1].equals(topLeft) && board[2][2].equals(topLeft) && !topLeft.equals(" ")){
            winner = topLeft;
            return true;
        }
        else if(board[1][1].equals(topRight) && board[2][0].equals(topRight) && !topRight.equals(" ")){
            winner = topRight;
            return true;
        }
        else{return false;}
    }

    private void endGame(){
        System.exit(0);
    }
}

/*
  - | - | -
 ---+---+---
  - | - | -
 ---+---+---
  - | - | -
 */
