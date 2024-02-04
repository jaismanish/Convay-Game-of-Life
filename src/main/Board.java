package src.main;

public class Board {
    private Cell[][] cells;

    public Board(int rows, int cols) {
        cells = new Cell[rows][cols];
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
