package src.test;

import org.junit.jupiter.api.Test;
import src.main.Board;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    void boardCanBeCreatedWithSpecifiedSize() {
        Board board = new Board(3, 3);
        assertEquals(3, board.getRows());
        assertEquals(3, board.getCols());
    }

}