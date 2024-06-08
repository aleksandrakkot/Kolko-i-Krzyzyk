package kodilla.tictactoe;
import java.util.Scanner;

public class TicTacToeUI {
    private TicTacToeGame game;
    private boolean withComputer;

    // Constructor
    public TicTacToeUI(int size, boolean withComputer) {
        game = new TicTacToeGame(size);
        this.withComputer = withComputer;
    }

    // Gets the current board state from the TicTacToeGame object and prints board using "|"
    public void printBoard() {
        char[][] board = game.getBoard();
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
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

            // Taking move from the player
            while (true) {
                System.out.println("Player " + game.getCurrentPlayer() + ", enter your move (row [1-" + game.getBoard().length + "] and column [1-" + game.getBoard()[0].length + "]): ");
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;

                if (game.placeMove(row, col)) {
                    break;
                } else {
                    System.out.println("This move is not valid");
                }
            }

            // Checking if the current player has won
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

                // The computer's move if it's his turn and game is with computer
                if (withComputer && game.getCurrentPlayer() == 'O') {
                    game.makeComputerMove();

                    //Checking if the computer has won
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
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean withComputer = false;

        //Do-while loop for selecting board size
        do {
            System.out.println("Choose game type: 1 for 3x3, 2 for 10x10");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        } while (choice != 1 && choice != 2);

        int size;
        if (choice == 1) {
            size = 3;
        } else {
            size = 10;
        }

        //Do-while loop for selecting opponent type
        do {
            System.out.println("Play with computer? 1 for Yes, 2 for No");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        } while (choice != 1 && choice != 2);

        if (choice == 1) {
            withComputer = true;
        }

        TicTacToeUI ui = new TicTacToeUI(size, withComputer);
        ui.startGame();
    }
}
