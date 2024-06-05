package kodilla.tictactoe;

import java.util.Random;

import java.util.Random;

public class TicTacToeGame {
    private char[][] board;
    private char currentPlayer;
    private int size;
    private int winCondition;

    // Constructor - initializes the board with given size and sets the current player to X
    public TicTacToeGame(int size) {
        this.size = size;

        if (size == 3) {
            this.winCondition = 3;
        } else {
            this.winCondition = 5;
        }

        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean placeMove(int row, int col) {
        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            return true;
        }
        throw new IllegalArgumentException("Invalid move");
    }

    public boolean checkWinner() {
        // Check rows
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - winCondition; j++) {
                boolean win = true;
                for (int k = 0; k < winCondition; k++) {
                    if (board[i][j + k] != currentPlayer) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }

        // Check columns
        for (int i = 0; i <= size - winCondition; i++) {
            for (int j = 0; j < size; j++) {
                boolean win = true;
                for (int k = 0; k < winCondition; k++) {
                    if (board[i + k][j] != currentPlayer) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }

        // Check diagonals
        for (int i = 0; i <= size - winCondition; i++) {
            for (int j = 0; j <= size - winCondition; j++) {
                boolean win = true;
                for (int k = 0; k < winCondition; k++) {
                    if (board[i + k][j + k] != currentPlayer) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }

        for (int i = 0; i <= size - winCondition; i++) {
            for (int j = winCondition - 1; j < size; j++) {
                boolean win = true;
                for (int k = 0; k < winCondition; k++) {
                    if (board[i + k][j - k] != currentPlayer) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }

        return false;
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
                row = rand.nextInt(size);
                col = rand.nextInt(size);
            } while (board[row][col] != ' ');

            board[row][col] = 'O';
        }
    }
}
