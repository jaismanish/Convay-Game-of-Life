package src.test;

import org.junit.jupiter.api.Test;
import src.main.Board;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void testBoardCreatedWithValidSize() {
        Board board = new Board(10, 12, 0.3);
        assertNotNull(board);
    }

    @Test
    void testBoardCreatedWithInValidSize(){
        assertThrows(IllegalArgumentException.class, () -> new Board(0, 0, 0.3));
        assertThrows(IllegalArgumentException.class, () -> new Board(0, 8, 0.3));
        assertThrows(IllegalArgumentException.class, () -> new Board(8, 0, 0.3));
        assertThrows(IllegalArgumentException.class, () -> new Board(-8, 8, 0.3));
        assertThrows(IllegalArgumentException.class, () -> new Board(8, -8, 0.3));
    }
    @Test
    void testSeedingWithZeroSeedPercent_ShouldThrowException() {

        assertThrows(IllegalArgumentException.class, () -> new Board(8, 8, 0.0));
    }
    @Test
    void testSeedingWithNegativeSeedPercent_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Board(8, 8, -0.3));
    }
    @Test
    void testSeedPopulation() {
        Board board = new Board(8, 8, 0.3);
        int alive = 0;


        for (int i = 0; i < board.cells().length; i++) {
            for (int j = 0; j < board.cells()[0].length; j++) {
                if(board.cells()[i][j].isAlive()) {
                    ++alive;
                }
            }
        }
        double actual = (double)alive / 64;

        assertTrue(0.1 > actual - 0.3);
    }
}
