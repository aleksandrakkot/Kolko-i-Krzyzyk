package kodilla.tictactoe;

public class TicTacToeBoard {
    private char[][] board;
    private int size;

    public TicTacToeBoard(int size) {
        this.size = size;
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean placeMove(int row, int col, char player) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            if (board[row][col] == ' ') {
                board[row][col] = player;
                return true;
            } else {
                System.out.println("Cell at row " + row + ", column " + col + " is not empty.");
            }
        } else {
            System.out.println("Invalid coordinates: row " + row + ", column " + col);
        }
        throw new IllegalArgumentException("Invalid move");
    }


    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }
}