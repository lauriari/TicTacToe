package TicTacToe.domain.model;

import java.util.Arrays;

public class GameBoard {
    private static final int ROWS = 3;
    private static final int COLLS = 3;

    private int[][] board;

    public GameBoard() {
        this.board = new int[ROWS][COLLS];
        for (int[] row : board){
            Arrays.fill(row, 0);
        }

    }

    public GameBoard(GameBoard other) {
        this.board = new int[ROWS][COLLS];
            for (int i = 0; i < ROWS; i++){
                for (int j = 0; j < COLLS; j++){
                    board[i][j] = other.getBoard(i,j);
                }
            }
    }

    public int getBoard(int m, int n) {
        return board[m][n];
    }

    public void setBoard(int m, int n, int date) {
        this.board[m][n] = date;
    }
}
