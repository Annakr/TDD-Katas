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
        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for (int cellIndex = 0; cellIndex < grid[rowIndex].length; cellIndex++) {
                int numberOfAliveNeighbours = calculateNumberOfAliveNeighbours(rowIndex, cellIndex);
                if (numberOfAliveNeighbours < 2 || numberOfAliveNeighbours > 3)
                    setCellDead(rowIndex, cellIndex);
            }
        }
    }

    private void setCellDead(int row, int cell) {
        grid[row][cell] = false;
    }

    private int calculateNumberOfAliveNeighbours(int row, int column) {
        int numberOfAliveNeighbours = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i != row || j != column) {
                    if (isAlive(i, j))
                        numberOfAliveNeighbours++;
                }
            }
        }
        return numberOfAliveNeighbours;
    }

}
