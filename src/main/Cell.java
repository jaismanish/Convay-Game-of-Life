package src.main;

public class Cell {
    private boolean isAlive;

    public Cell() {
        this.isAlive = false;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }
    public boolean isAlive() {
        return this.isAlive;
    }

    public static Cell createAliveCell() {
        Cell cell = new Cell();
        cell.isAlive = true;
        return cell;
    }


    public void state(int aliveNeighbours) {
        if (!this.isAlive() && aliveNeighbours == 3) {
            this.isAlive = true;
        } else if (this.isAlive() && (aliveNeighbours < 2 || aliveNeighbours > 3)) {
            this.isAlive = false;
        }
    }

    @Override
    public String toString() {
        return this.isAlive ? "1" : "0";
    }
}
