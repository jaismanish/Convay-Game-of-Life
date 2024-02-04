package src.test;

import org.junit.jupiter.api.Test;
import src.main.Board;
import src.main.Cell;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    void boardCanBeCreatedWithSpecifiedSize() {
        Board board = new Board(3, 3);
        assertEquals(3, board.getRows());
        assertEquals(3, board.getCols());
    }

    @Test
    void boardCellInitialStateIsRandom() {
        Board board = new Board(3, 3);

        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getCols(); col++) {
                Cell cell = board.getCell(row, col);
                assertNotNull(cell);
            }
        }
    }

}