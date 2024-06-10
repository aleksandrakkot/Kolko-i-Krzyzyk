package kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeFX extends Application {
    private TicTacToeGame game;
    private Button[][] buttons;

    @Override
    public void start(Stage primaryStage) {
        int size = selectBoardSize();
        boolean withComputer = selectOpponent();

        game = new TicTacToeGame(size);
        game.setWithComputer(withComputer);

        buttons = new Button[size][size];

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Button button = new Button();
                button.setPrefSize(40, 40);
                button.setOnAction(e -> handleButtonAction(button));
                buttons[i][j] = button;
                gridPane.add(button, j, i);
            }
        }

        Scene scene = new Scene(gridPane, 50 + size * 45, 50 + size * 45);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.show();
    }

    private int selectBoardSize() {
        Stage sizeStage = new Stage();
        Label label = new Label("Choose board size:");
        Button size3 = new Button("3x3");
        Button size10 = new Button("10x10");

        int[] selectedSize = new int[1];

        size3.setOnAction(e -> {
            selectedSize[0] = 3;
            sizeStage.close();
        });
        size10.setOnAction(e -> {
            selectedSize[0] = 10;
            sizeStage.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(label, 0, 0);
        gridPane.add(size3, 0, 1);
        gridPane.add(size10, 1, 1);

        Scene scene = new Scene(gridPane, 200, 100);
        sizeStage.setScene(scene);
        sizeStage.setTitle("Select Board Size");
        sizeStage.showAndWait();

        return selectedSize[0];
    }

    private boolean selectOpponent() {
        Stage opponentStage = new Stage();
        Label label = new Label("Play against computer?");
        Button yes = new Button("Yes");
        Button no = new Button("No");

        boolean[] withComputer = new boolean[1];

        yes.setOnAction(e -> {
            withComputer[0] = true;
            opponentStage.close();
        });
        no.setOnAction(e -> {
            withComputer[0] = false;
            opponentStage.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(label, 0, 0);
        gridPane.add(yes, 0, 1);
        gridPane.add(no, 1, 1);

        Scene scene = new Scene(gridPane, 200, 100);
        opponentStage.setScene(scene);
        opponentStage.setTitle("Select Opponent");
        opponentStage.showAndWait();

        return withComputer[0];
    }

    private void handleButtonAction(Button button) {
        if (!game.checkWinner() && !game.isBoardFull()) {
            int row = GridPane.getRowIndex(button);
            int col = GridPane.getColumnIndex(button);
            if (game.getBoard()[row][col] == ' ') {
                if (game.placeMove(row, col)) {
                    button.setText(String.valueOf(game.getCurrentPlayer().getSymbol()));
                    if (game.checkWinner()) {
                        showAlert("Player " + game.getCurrentPlayer().getSymbol() + " wins!");
                    } else if (game.isBoardFull()) {
                        showAlert("The game is a tie!");
                    } else {
                        game.changePlayer();
                        if (game.isWithComputer() && game.getCurrentPlayer().getSymbol() == 'O') {
                            game.makeComputerMove();
                            updateBoard();
                            if (game.checkWinner()) {
                                showAlert("Player " + game.getCurrentPlayer().getSymbol() + " wins!");
                            } else if (game.isBoardFull()) {
                                showAlert("The game is a tie!");
                            } else {
                                game.changePlayer();
                            }
                        }
                    }
                }
            } else {
                System.out.println("Selected cell is not empty.");
            }
        }
    }

    private void updateBoard() {
        char[][] board = game.getBoard();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != ' ' && buttons[i][j].getText().isEmpty()) {
                    buttons[i][j].setText(String.valueOf(board[i][j]));
                }
            }
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
