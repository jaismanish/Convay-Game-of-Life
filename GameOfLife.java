public class GameOfLife {
    private int[][] grid;

    public GameOfLife(int row, int column){
        this.grid = new int[row][column];
    }

    public void initialize(int[][] initialGrid) {
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(initialGrid[i], 0, grid[i], 0, grid[i].length);
        }
    }

    public void proceed() {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] nextGrid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);
                if (grid[i][j] == 1) {
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        nextGrid[i][j] = 1;
                    } else {
                        nextGrid[i][i] = 0;
                    }
                }
            }
        }

        grid = nextGrid;
    }

    private int countLiveNeighbors(int row, int col) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == row && j == col) {
                    continue;
                }

                if (i >= 0 && i < rows && j >= 0 && j < cols) {
                    count += grid[i][j];
                }
            }
        }
        return count;
    }

    public int[][] getGrid() {
        return grid;
    }

}
