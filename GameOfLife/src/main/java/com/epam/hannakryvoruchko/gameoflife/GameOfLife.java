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

    }
}
