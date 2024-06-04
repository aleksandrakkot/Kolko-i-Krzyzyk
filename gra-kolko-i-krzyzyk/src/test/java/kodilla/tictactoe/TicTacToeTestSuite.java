package kodilla.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeTestSuite {
    @Test
    public void testWinOInRow(){
        // Given
        TicTacToeGame game = new TicTacToeGame();
        game.changePlayer();

        //When
        game.placeMove(0, 0);
        game.changePlayer();
        game.placeMove(1, 0);
        game.changePlayer();
        game.placeMove(0, 1);
        game.changePlayer();
        game.placeMove(1, 1);
        game.changePlayer();
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
        game.placeMove(0, 0);
        game.changePlayer();
        game.placeMove(0, 1);
        game.changePlayer();
        game.placeMove(1, 0);
        game.changePlayer();
        game.placeMove(1, 1);
        game.changePlayer();
        game.placeMove(2, 0);

        //Then
        assertTrue(game.checkWinner());
    }

    @Test
    public void testWinOCross(){
        // Given
        TicTacToeGame game = new TicTacToeGame();
        game.changePlayer();

        //When
        game.placeMove(0, 0);
        game.changePlayer();
        game.placeMove(1, 0);
        game.changePlayer();
        game.placeMove(1, 1);
        game.changePlayer();
        game.placeMove(2, 0);
        game.changePlayer();
        game.placeMove(2, 2);

        //Then
        assertTrue(game.checkWinner());
    }

    @Test
    public void testWinXInRow(){
        // Given
        TicTacToeGame game = new TicTacToeGame();

        //When
        game.placeMove(0, 0);
        game.changePlayer();
        game.placeMove(1, 0);
        game.changePlayer();
        game.placeMove(0, 1);
        game.changePlayer();
        game.placeMove(1, 1);
        game.changePlayer();
        game.placeMove(0, 2);

        //Then
        assertTrue(game.checkWinner());
    }

    @Test
    public void testWinXInColumn(){
        // Given
        TicTacToeGame game = new TicTacToeGame();

        //When
        game.placeMove(0, 0);
        game.changePlayer();
        game.placeMove(0, 1);
        game.changePlayer();
        game.placeMove(1, 0);
        game.changePlayer();
        game.placeMove(1, 1);
        game.changePlayer();
        game.placeMove(2, 0);

        //Then
        assertTrue(game.checkWinner());
    }

    @Test
    public void testWinXCross(){
        // Given
        TicTacToeGame game = new TicTacToeGame();

        //When
        game.placeMove(0, 0);
        game.changePlayer();
        game.placeMove(1, 0);
        game.changePlayer();
        game.placeMove(1, 1);
        game.changePlayer();
        game.placeMove(2, 0);
        game.changePlayer();
        game.placeMove(2, 2);

        //Then
        assertTrue(game.checkWinner());
    }

    @Test
    public void testTieGame(){
        // Given
        TicTacToeGame game = new TicTacToeGame();

        //When
        game.placeMove(0, 0);
        game.changePlayer();
        game.placeMove(1, 0);
        game.changePlayer();
        game.placeMove(2, 0);
        game.changePlayer();
        game.placeMove(0, 1);
        game.changePlayer();
        game.placeMove(1, 1);
        game.changePlayer();
        game.placeMove(2, 1);
        game.changePlayer();
        game.placeMove(1, 2);
        game.changePlayer();
        game.placeMove(0, 2);

        //Then
        assertFalse(game.checkWinner());
    }

    @Test
    public void testInvalidMove(){
        // Given
        TicTacToeGame game = new TicTacToeGame();
        //When
        game.placeMove(0, 0);
        //Then
        assertThrows(IllegalArgumentException.class, () -> {
            game.placeMove(0, 0);
        });
    }

}
