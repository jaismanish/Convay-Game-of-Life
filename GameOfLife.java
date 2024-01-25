public class GameOfLife {
    private final int[][] grid;

    public GameOfLife(int row, int column){
        this.grid = new int[row][column];
    }

    public void initialize(int[][] initialGrid) {
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(initialGrid[i], 0, grid[i], 0, grid[i].length);
        }
    }

    public void proceed() {
        grid[1][1] = 0;
    }

    public int[][] getGrid() {
        return grid;
    }

}
