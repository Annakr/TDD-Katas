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
        try {
            return grid[row][column];
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public void calculateNextGeneration() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int numberOfAliveNeighbours = calculateNumberOfAliveNeighbours(i, j);
                if (numberOfAliveNeighbours < 2)
                    setCellDead(i, j);
            }
        }
    }

    private void setCellDead(int row, int cell) {
        grid[row][cell] = false;
    }

    private int calculateNumberOfAliveNeighbours(int row, int column) {
        int numberOfAliveNeighbours = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j < column + 1; j++) {
                if (i != row && j != column) {
                    if (isAlive(i, j))
                        numberOfAliveNeighbours++;
                }
            }

        }
        return numberOfAliveNeighbours;
    }


}
