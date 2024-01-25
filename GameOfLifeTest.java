import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameOfLifeTest {

    @Test
    void testInitializeBoard() {
        GameOfLife game = new GameOfLife(5,5);
        int[][] initialBoard = game.getBoard();

        assertNotNull(initialBoard);
    }
}
