package kodilla.tictactoe;


import java.util.Random;

public class TicTacToeGame {
    private char[][] board;
    private char currentPlayer;

    //constructor - initializes the board as a 3x3 array, where each cell is removed empty and sets the current player to X
    public TicTacToeGame() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean placeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            return true;
        }
        throw new IllegalArgumentException("Invalid move");
    }

    public boolean checkWinner() {
        // Sprawdzenie wierszy
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }

        // Sprawdzenie kolumn
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == currentPlayer && board[1][j] == currentPlayer && board[2][j] == currentPlayer) {
                return true;
            }
        }

        // Sprawdzenie przekątnych
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char[][] getBoard() {
        return board;
    }

    public void makeComputerMove() {
        if (currentPlayer == 'O') {
            Random rand = new Random();
            int row, col;
            do {
                row = rand.nextInt(3);
                col = rand.nextInt(3);
            } while (board[row][col] != ' ');

            board[row][col] = 'O';
        }
    }
}
