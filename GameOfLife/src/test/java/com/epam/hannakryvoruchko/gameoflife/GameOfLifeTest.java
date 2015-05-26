package com.epam.hannakryvoruchko.gameoflife;

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
    public void setGrid() {
        game.setGrid(new boolean[3][3]);
    }

}
