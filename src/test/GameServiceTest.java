package src.test;

import org.junit.jupiter.api.Test;
import src.main.Board;
import src.main.Cell;
import src.main.GameService;

import static org.junit.jupiter.api.Assertions.*;


public class GameServiceTest {

    @Test
    void evolveUpdatesBoardAccordingToRules() {
        Board board = new Board(3, 3);
        GameService gameService = new GameService(board);

        gameService.evolve();
        assertNotNull(gameService);
    }

    @Test
    void evolveDoesNotModifyOriginalBoard() {
        Board board = new Board(3, 3);
        GameService gameService = new GameService(board);

        boolean[][] originalState = new boolean[board.getRows()][board.getCols()];
        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getCols(); col++) {
                originalState[row][col] = board.getCell(row, col).isAlive();
            }
        }

        gameService.evolve();

        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getCols(); col++) {
                assertEquals(originalState[row][col], board.getCell(row, col).isAlive());
            }
        }
    }

}
