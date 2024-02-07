package src.main;

import java.util.Random;

public class Board {
    private Cell[][] cells;
    private final int rows;
    private final int cols;

    public Board(int rows, int cols){
        if(rows <= 0 || cols <= 0) throw new IllegalArgumentException("Please provide valid board size");
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
        initializeCells();
    }

    private void initializeCells() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                this.cells[row][col] = new Cell();
            }
        }
    }

    public void seedPopulation(double seedPercentage) {
        if (seedPercentage <= 0.0) {
            throw new IllegalArgumentException("Please provide valid seed percent");
        }
        Random random = new Random();

        for (Cell[] row : cells) {
            for (Cell cell : row) {
                double seed = random.nextDouble();
                cell.setAlive(seed <= seedPercentage);
            }
        }
    }

    public void print() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                System.out.print(cell.isAlive() ? "O " : ". ");
            }
            System.out.println();
        }
    }

    public Cell[][] cells() {
        return this.cells;
    }

}
