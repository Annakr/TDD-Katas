package com.epam.hannakryvoruchko.gameoflife;

/**
 * Created by Hanna_Kryvoruchko1 on 5/26/2015.
 */
public class GameOfLife {

    private boolean[][] grid;

    public void setGrid(boolean[][] grid) {
        this.grid = grid;
    }

    public boolean isAlive(int row, int column) {
        return grid[row][column];
    }

    public void calculateNextGeneration() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int numberOfAliveNeighbours = calculateNumberOfAliveNeighbours(i, j);
                if (numberOfAliveNeighbours == 0)
                    setCellDead(i, j);
            }
        }
    }

    private void setCellDead(int row, int cell) {
        grid[row][cell] = false;
    }

    private int calculateNumberOfAliveNeighbours(int row, int cell) {
        return 0;
    }
}
