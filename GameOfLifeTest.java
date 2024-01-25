import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameOfLifeTest {

    @Test
    void testInitializeBoard() {
        GameOfLife game = new GameOfLife(5,6);
        int[][] initialGrid = game.getGrid();

        assertNotNull(initialGrid);
        assertEquals(5, initialGrid.length);
        assertEquals(6, initialGrid[0].length);
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

    @Test
    public void testLiveCellSurvivesWithTwoOrThreeNeighbors() {
        GameOfLife game = new GameOfLife(3, 3);
        int[][] grid = {
                {1, 1, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        game.initialize(grid);

        game.proceed();

        int[][] nextGeneration = game.getGrid();
        assertEquals(1, nextGeneration[1][1]);
    }

    @Test
    public void testLiveCellDiesWithOverpopulation() {
        GameOfLife game = new GameOfLife(3, 3);
        int[][] grid = {
                {1, 1, 1},
                {1, 1, 0},
                {0, 0, 0}
        };
        game.initialize(grid);

        game.proceed();

        int[][] nextGeneration = game.getGrid();
        assertEquals(0, nextGeneration[1][1]);
    }

}
