package src.test;

import org.junit.jupiter.api.Test;
import src.main.Cell;

import java.lang.reflect.Field;

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
    @Test
    void testCellGetToAliveWith3Neighbors() {
        Cell cell = new Cell();

        cell.state(3);
        boolean actual = cell.isAlive();

        assertTrue(actual);
    }

    @Test
    public void testAliveCellChangesToDeadWith1AliveNeighbour() throws NoSuchFieldException, IllegalAccessException {
        Cell cell = new Cell();
        cell.state(1);
        boolean actual = cell.isAlive();

        assertFalse(actual);
    }

    @Test
    void testAliveCellWithZeroAliveNeighborsChangesToDead() throws NoSuchFieldException, IllegalAccessException {
        Cell cell = new Cell();
        cell.state(0);
        boolean actual = cell.isAlive();

        assertFalse(actual);
    }
    @Test
    void testAliveCellValueIsStar() throws NoSuchFieldException, IllegalAccessException {
        Cell cell = new Cell();
        Field aliveField = Cell.class.getDeclaredField("isAlive");
        aliveField.setAccessible(true);
        aliveField.set(cell, true);

        String actual = cell.toString();

        assertEquals("1", actual);
    }

}