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

    @Test
    void cellCanBeInitializedAsDead() {
        Cell cell = new Cell(false);
        assertFalse(cell.isAlive());
    }

    @Test
    void cellStateCanBeChanged() {
        Cell cell = new Cell(true);
        cell.setAlive(false);
        assertFalse(cell.isAlive());
    }

}