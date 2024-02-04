package src.test;

import org.junit.jupiter.api.Test;
import src.main.Board;
import src.main.GameService;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class GameServiceTest {

    @Test
    void evolveUpdatesBoardAccordingToRules() {
        Board board = new Board(3, 3);
        GameService gameService = new GameService(board);

        gameService.evolve();
        assertNotNull(gameService);
    }

}
