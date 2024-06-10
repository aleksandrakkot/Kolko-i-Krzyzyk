package kodilla.tictactoe;

public class TicTacToeGameLogic {
    private char[][] board;
    private int size;
    private int winCondition;

    public TicTacToeGameLogic(char[][] board, int winCondition) {
        this.board = board;
        this.size = board.length;
        this.winCondition = winCondition;
    }

    public boolean checkWinner(char player) {
        // Check rows
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - winCondition; j++) {
                boolean win = true;
                for (int k = 0; k < winCondition; k++) {
                    if (board[i][j + k] != player) {
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
                    if (board[i + k][j] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }

        // Check diagonals (left-to-right)
        for (int i = 0; i <= size - winCondition; i++) {
            for (int j = 0; j <= size - winCondition; j++) {
                boolean win = true;
                for (int k = 0; k < winCondition; k++) {
                    if (board[i + k][j + k] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }

        // Check diagonals (right-to-left)
        for (int i = 0; i <= size - winCondition; i++) {
            for (int j = winCondition - 1; j < size; j++) {
                boolean win = true;
                for (int k = 0; k < winCondition; k++) {
                    if (board[i + k][j - k] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }

        return false;
    }
}
