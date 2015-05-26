package com.epam.hannakryvoruchko.gameoflife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Hanna_Kryvoruchko1 on 5/26/2015.
 */
public class GameOfLifeTest {

    private GameOfLife game;

    @Before
    public void setUp() {
        game = new GameOfLife();
    }

    @Test
    public void testSetGrid() {
        game.setGrid(createGrid(3, 3));
    }

    @Test
    public void testGetCellStateIsDead() {
        game.setGrid(createGrid(3, 3));
        boolean isCellAlive = game.isAlive(0, 0);
        Assert.assertFalse(isCellAlive);
    }

    @Test
    public void testGetCellStateIsAlive() {
        //given
        boolean[][] grid = createGrid(3, 3);
        grid[0][0] = true;
        game.setGrid(grid);

        //when
        boolean isCellAlive = game.isAlive(0, 0);

        //then
        Assert.assertTrue(isCellAlive);
    }

    @Test
    public void testCalculateNextGeneration() {
        //given
        boolean[][] grid = createGrid(3, 3);
        game.setGrid(grid);

        //when
        game.calculateNextGeneration();

    }

    private boolean[][] createGrid(int numberOfRows, int numberOfColumns) {
        return new boolean[numberOfRows][numberOfColumns];
    }





}
