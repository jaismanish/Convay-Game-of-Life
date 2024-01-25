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
                    }
                }
            }
        }

        grid = nextGrid;
    }

    private int countLiveNeighbors(int row, int col) {
        return 2;
    }

    public int[][] getGrid() {
        return grid;
    }

}
