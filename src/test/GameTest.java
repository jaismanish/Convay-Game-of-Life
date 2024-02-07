package src.test;

import org.junit.jupiter.api.Test;
import src.main.Board;
import src.main.Game;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameTest {
    @Test
    void testInitializedGame() {
        Board board = new Board(8,8);
        Game game = new Game(board);

        assertNotNull(game);
    }
}
