package src.main;

import java.util.Random;

public class Board {
    private Cell[][] cells;

    public Board(int rows, int cols) {
        cells = new Cell[rows][cols];
        initializeBoard();
    }

    private void initializeBoard() {
        Random random = new Random();

        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                boolean isAlive = random.nextBoolean();
                cells[row][col] = new Cell(isAlive);
            }
        }
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public int getRows() {
        return cells.length;
    }

    public int getCols() {
        return cells[0].length;
    }

}
