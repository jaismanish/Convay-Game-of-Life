package src.main;

public class Board {
    private Cell[][] cells;
    private final int rows;
    private final int cols;

    public Board(int rows, int cols){
        if(rows <= 0 || cols <= 0) throw new IllegalArgumentException("Please provide valid board size");
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
    }

}
