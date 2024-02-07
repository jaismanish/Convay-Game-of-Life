package src.test;

import org.junit.jupiter.api.Test;
import src.main.Cell;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    void testCellCreated() {
        Cell cell = new Cell();
        assertNotNull(cell);
    }

    @Test
    void testIsCellAlive_ShouldReturnTrue() {
        Cell cell = new Cell();
        cell.setAlive(true);
        assertTrue(cell.isAlive());
    }

    @Test
    void testIsCellDead_ShouldReturnFalse() {
        Cell cell = new Cell();
        assertFalse(cell.isAlive());
    }

    @Test
    void testMarkingDeadCell_0_AndLiveCell_1() {
        Cell cell = new Cell();
        assertEquals("0", cell.toString());
        cell.setAlive(true);
        assertEquals("1", cell.toString());
    }
}