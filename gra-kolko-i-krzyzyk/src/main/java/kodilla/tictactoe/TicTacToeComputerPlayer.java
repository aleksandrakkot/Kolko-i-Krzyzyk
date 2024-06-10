package kodilla.tictactoe;

import java.util.Random;

public class TicTacToeComputerPlayer extends TicTacToePlayer {

    public TicTacToeComputerPlayer(char symbol) {
        super(symbol);
    }

    public void makeMove(TicTacToeBoard board) {
        Random rand = new Random();
        int size = board.getSize();
        int row, col;
        do {
            row = rand.nextInt(size);
            col = rand.nextInt(size);
        } while (board.getBoard()[row][col] != ' ');

        board.placeMove(row, col, getSymbol());
    }
}
