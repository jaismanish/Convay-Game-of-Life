import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameOfLifeTest {

    @Test
    void testInitializeBoard() {
        GameOfLife game = new GameOfLife(5,6);
        int[][] initialBoard = game.getBoard();

        assertNotNull(initialBoard);
        assertEquals(5, initialBoard.length);
        assertEquals(6, initialBoard[0].length);
    }

    @Test
    public void testLiveCellDiesWithNoNeighbors() {
        GameOfLife game = new GameOfLife(3, 3);
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        game.initialize(grid);

        game.proceed();

        int[][] nextGeneration = game.getGrid();
        assertEquals(0, nextGeneration[1][1]);
    }
}
