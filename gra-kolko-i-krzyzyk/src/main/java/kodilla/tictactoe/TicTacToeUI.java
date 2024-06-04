package kodilla.tictactoe;
import java.util.Scanner;
public class TicTacToeUI {
    private TicTacToeGame game;

    //constructor
    public TicTacToeUI() {
        game = new TicTacToeGame();
    }

    //Gets the current board state from the TicTacToeGame object and print board using "|"
    public void printBoard() {
        char[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println();
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard();
            int row, col;

            // Pobranie ruchu od gracza
            while (true) {
                System.out.println("Player " + game.getCurrentPlayer() + ", enter your move (row [1-3] and column [1-3]): ");
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;

                if (game.placeMove(row, col)) {
                    break;
                } else {
                    System.out.println("This move is not valid");
                }
            }

            // Sprawdzenie, czy obecny gracz wygrał
            if (game.checkWinner()) {
                printBoard();
                System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                gameEnded = true;
            } else if (game.isBoardFull()) {
                printBoard();
                System.out.println("The game is a tie!");
                gameEnded = true;
            } else {
                game.changePlayer();
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToeUI ui = new TicTacToeUI();
        ui.startGame();
    }
}