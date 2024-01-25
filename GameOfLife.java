public class GameOfLife {
    private int[][] board;

    public GameOfLife(int row, int column){
        this.board = new int[row][column];
    }

    public int[][] getBoard() {
        return board;
    }

}
