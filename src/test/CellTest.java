package src.test;

import org.junit.jupiter.api.Test;
import src.main.Cell;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    void cellCanBeInitializedAsAlive() {
        Cell cell = new Cell(true);
        assertTrue(cell.isAlive());
    }

}