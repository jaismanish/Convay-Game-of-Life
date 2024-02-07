package src.test;

import org.junit.jupiter.api.Test;
import src.main.Board;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
