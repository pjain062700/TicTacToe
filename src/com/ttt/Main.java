package com.idklol;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player("X", "Player X");
        Player player2 = new Player("O", "Player O");

        int turn = 0;
        while(!board.checkWinner()){
            if(turn % 2 == 0){ player1.takeTurn(board); }
            else{ player2.takeTurn(board); }
            turn++;
        }
        board.declareWinner();
    }
}
