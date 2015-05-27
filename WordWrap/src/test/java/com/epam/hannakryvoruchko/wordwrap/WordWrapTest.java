package com.epam.hannakryvoruchko.wordwrap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hanna_Kryvoruchko1 on 5/27/2015.
 */
public class WordWrapTest {

    @Test
    public void noWrap() {
        assertEquals("word", WordWrapper.wrap("word", 4));

    }

}
