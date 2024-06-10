package kodilla.tictactoe;

public class TicTacToeGame {
    private TicTacToeBoard board;
    private TicTacToePlayer currentPlayer;
    private TicTacToePlayer playerX;
    private TicTacToePlayer playerO;
    private TicTacToeGameLogic gameLogic;
    private boolean withComputer;

    public TicTacToeGame(int size) {
        board = new TicTacToeBoard(size);
        int winCondition = (size == 3) ? 3 : 5;
        gameLogic = new TicTacToeGameLogic(board.getBoard(), winCondition);
        playerX = new TicTacToePlayer('X');
        playerO = new TicTacToePlayer('O');
        currentPlayer = playerX;
    }

    public TicTacToePlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void setWithComputer(boolean withComputer) {
        this.withComputer = withComputer;
        if (withComputer) {
            playerO = new TicTacToeComputerPlayer('O');
        }
    }

    public boolean isWithComputer() {
        return withComputer;
    }

    public boolean placeMove(int row, int col) {
        return board.placeMove(row, col, currentPlayer.getSymbol());
    }

    public boolean checkWinner() {
        return gameLogic.checkWinner(currentPlayer.getSymbol());
    }

    public boolean isBoardFull() {
        return board.isBoardFull();
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public char[][] getBoard() {
        return board.getBoard();
    }

    public void makeComputerMove() {
        if (currentPlayer instanceof TicTacToeComputerPlayer) {
            ((TicTacToeComputerPlayer) currentPlayer).makeMove(board);
        }
    }
}
