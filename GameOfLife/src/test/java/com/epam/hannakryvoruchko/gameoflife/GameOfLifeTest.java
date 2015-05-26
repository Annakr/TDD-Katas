package com.epam.hannakryvoruchko.gameoflife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        assertFalse(isCellAlive);
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
        assertTrue(isCellAlive);
    }

    @Test
    public void testCalculateNextGeneration() {
        //given
        boolean[][] grid = createGrid(3, 3);
        game.setGrid(grid);

        //when
        game.calculateNextGeneration();
    }

    @Test
    public void testCellShouldDieWhenHasZeroNeighbours() {
        //given
        boolean[][] grid = createGrid(3, 3);
        grid[0][0] = true;
        game.setGrid(grid);

        //when
        game.calculateNextGeneration();

        //then
        assertFalse(game.isAlive(0, 0));
    }

    @Test
    public void testCellShouldDieWhenHasOneNeighbour() {
        //given
        boolean[][] grid = createGrid(3, 3);
        grid[0][0] = true;
        grid[0][1] = true;
        game.setGrid(grid);

        //when
        game.calculateNextGeneration();

        //then
        assertFalse(game.isAlive(0, 0));
    }

    @Test
    public void testCellShouldStayAliveWhenHasTwoNeighbours() {
        //given
        boolean[][] grid = createGrid(3, 3);
        grid[0][0] = true;
        grid[0][1] = true;
        grid[1][0] = true;
        game.setGrid(grid);

        //when
        game.calculateNextGeneration();

        //then
        assertTrue(game.isAlive(0, 0));
    }

    @Test
    public void testCellShouldStayAliveWhenHasThreeNeighbours() {
        //given
        boolean[][] grid = createGrid(3, 3);
        grid[0][0] = true;
        grid[0][1] = true;
        grid[1][0] = true;
        grid[1][1] = true;
        game.setGrid(grid);

        //when
        game.calculateNextGeneration();

        //then
        assertTrue(game.isAlive(0, 0));
    }

    @Test
    public void testCellShouldDieWhenHasFourNeighbours() {
        //given
        boolean[][] grid = createGrid(4, 4);
        grid[1][1] = true;
        grid[0][0] = true;
        grid[0][1] = true;
        grid[0][2] = true;
        grid[1][0] = true;
        game.setGrid(grid);

        //when
        game.calculateNextGeneration();

        //then
        assertFalse(game.isAlive(1, 1));
    }

    @Test
    public void testCellShouldStayDiedWhenHasTwoNeighbours() {
        //given
        boolean[][] grid = createGrid(3, 3);
        grid[0][1] = true;
        grid[1][0] = true;
        game.setGrid(grid);

        //when
        game.calculateNextGeneration();

        //then
        assertFalse(game.isAlive(0, 0));
    }

    @Test
    public void testCellShouldBecomeAliveWhenHasThreeNeighbours() {
        //given
        boolean[][] grid = createGrid(3, 3);
        grid[0][1] = true;
        grid[1][0] = true;
        grid[1][1] = true;
        game.setGrid(grid);

        //when
        game.calculateNextGeneration();

        //then
        assertTrue(game.isAlive(0, 0));
    }

    private boolean[][] createGrid(int numberOfRows, int numberOfColumns) {
        return new boolean[numberOfRows][numberOfColumns];
    }





}
