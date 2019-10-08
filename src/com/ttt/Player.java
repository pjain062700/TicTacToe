package com.idklol;

import java.util.Scanner;

public class Player {
    private String p;
    private Scanner s;
    private String n;
    private static String[][] b;

    public Player(String piece, String name){
        p = piece;
        s = new Scanner(System.in);
        n = name;
        b = new String[3][3];
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                b[r][c] = " ";
            }
        }
    }

    public void takeTurn(Board board){
        int row = 4;
        int col = 4;
        System.out.println(String.format("%s's turn!", n));
        do {
            try{
                System.out.println("Which row would you like to place your piece in? ");
                row = s.nextInt();
                System.out.println("Which column1 would you like to place your piece in? ");
                col = s.nextInt();
            }
            catch(java.util.InputMismatchException e){ s = new Scanner(System.in); }
        } while(!checkInputs(row, col));
        b[row-1][col-1] = p;
        board.changeAndPrint(row-1, col-1, p);
    }

    private boolean checkInputs(int row, int col){
        boolean result = true;
        if(row > 3 || col > 3 || col <=0 || row <= 0){
            System.out.println("Invalid Move! Try again.");
            return false;
        }

        if(!b[row-1][col-1].equals(" ")){
            System.out.println("Invalid Move! Try again.");
            result = false;
        }
        return result;
    }
}
