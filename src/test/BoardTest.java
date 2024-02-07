package src.test;

import org.junit.jupiter.api.Test;
import src.main.Board;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void testBoardCreatedWithValidSize() {
        Board board = new Board(8, 8);
        assertNotNull(board);
    }

    @Test
    void testBoardCreatedWithInValidSize(){
        assertThrows(IllegalArgumentException.class, () -> new Board(0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Board(0, 8));
        assertThrows(IllegalArgumentException.class, () -> new Board(8, 0));
        assertThrows(IllegalArgumentException.class, () -> new Board(-8, 8));
        assertThrows(IllegalArgumentException.class, () -> new Board(8, -8));
    }
    @Test
    void testSeedingWithZeroSeedPercent_ShouldThrowException() {
        Board board = new Board(8, 8);
        double seedPercentage = 0.0;
        assertThrows(IllegalArgumentException.class, () -> board.seedPopulation(seedPercentage));
    }
    @Test
    void testSeedingWithNegativeSeedPercent_ShouldThrowException() {
        Board board = new Board(8, 8);
        double seedPercentage = -0.3;
        assertThrows(IllegalArgumentException.class, () -> board.seedPopulation(seedPercentage));
    }
    @Test
    void testSeedPopulation() {
        Board board = new Board(8, 8);
        int alive = 0;
        board.seedPopulation(0.3);

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
