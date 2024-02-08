package src.main;

import java.util.Random;

public class Board {
    private Cell[][] cells;
    private final int rows;
    private final int cols;

    public Board(int rows, int cols, double seedPercentage){
        if(rows <= 0 || cols <= 0) throw new IllegalArgumentException("Please provide valid board size");
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
        initializeCells();
        seedLiveCells(seedPercentage);
    }

    public void evolve() {
        Cell[][] newCells = new Cell[this.rows][this.cols];

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                int liveNeighbours = this.countLiveNeighbours(i, j);

                newCells[i][j] = new Cell();
                newCells[i][j].state(liveNeighbours);
            }
        }

        this.cells = newCells;
    }

    private void seedLiveCells(double seedPercent) {
        if (seedPercent <= 0.0){
            throw new IllegalArgumentException("Seed percentage can't be negative or zero");
        }
        Random random = new Random();

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (random.nextDouble(0, 1) < seedPercent) {
                    this.cells[i][j] = Cell.createAliveCell();
                } else {
                    this.cells[i][j] = new Cell();
                }
            }
        }
    }

    private void initializeCells() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                this.cells[row][col] = new Cell();
            }
        }
    }

    private int countLiveNeighbours(int row, int column) {
        int liveNeighbours = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int neighborRow = row + i;
                int neighborColumn = column + j;

                if (i == 0 && j == 0) {
                    continue;
                }
                if (neighborRow >= 0 & neighborColumn < this.rows && neighborColumn >= 0 && neighborColumn < this.cols) {
                    if (this.cells[neighborRow][neighborColumn].isAlive()) {
                        ++liveNeighbours;
                    }
                }
            }
        }

        return liveNeighbours;
    }



    public void print() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                System.out.print(" " + cell.toString() + " ");
            }
            System.out.println();
        }
    }

    public Cell[][] cells() {
        return this.cells;
    }

}
