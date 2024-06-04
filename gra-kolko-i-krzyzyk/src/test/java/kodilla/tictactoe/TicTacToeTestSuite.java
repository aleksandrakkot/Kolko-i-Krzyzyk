package kodilla.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTestSuite {
    @Test
    public void testWinOInRow(){
        // Given
        TicTacToeGame game = new TicTacToeGame();
        game.changePlayer();

        //When
        game.placeMove(0, 0);
        game.placeMove(1, 0);
        game.placeMove(0, 1);
        game.placeMove(1, 1);
        game.placeMove(0, 2);

        //Then
        assertTrue(game.checkWinner());
    }

    @Test
    public void testWinOInColumn(){
        // Given
        TicTacToeGame game = new TicTacToeGame();
        game.changePlayer();

        //When

        //Then
        assertTrue(game.checkWinner());
    }

    @Test
    public void testWinOCross(){
        // Given
        TicTacToeGame game = new TicTacToeGame();
        game.changePlayer();
        //When

        //Then
        assertTrue(game.checkWinner());
    }

    @Test
    public void testWinXInRow(){
        // Given
        TicTacToeGame game = new TicTacToeGame();
        //When

        //Then
        assertTrue(game.checkWinner());
    }

    @Test
    public void testWinXInColumn(){
        // Given
        TicTacToeGame game = new TicTacToeGame();
        //When

        //Then
        assertTrue(game.checkWinner());
    }

    @Test
    public void testWinXCross(){
        // Given
        TicTacToeGame game = new TicTacToeGame();
        //When

        //Then
        assertTrue(game.checkWinner());
    }


}
