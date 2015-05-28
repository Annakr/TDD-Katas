package com.epam.hannakryvoruchko.wordwrap;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordWrapTest {

    @Test
    public void noWrap() {
        assertEquals("word", WordWrapper.wrap("word", 4));
    }

    @Test
    public void shouldSplitSingleWord() {
        assertEquals("wo\nrd", WordWrapper.wrap("word", 2));
    }

    @Test
    public void shouldSplitWordTwice() {
        assertEquals("lon\ngWo\nrd", WordWrapper.wrap("longWord", 3));
    }

    @Test
    public void shouldSplitTwoWordsWhenSpaceOnBreak(){
        assertEquals("word\nword", WordWrapper.wrap("word word", 5));
    }

    @Test
    public void shouldNotRemoveWhenSpaceAtTheBeginning(){
        assertEquals(" word\nword", WordWrapper.wrap(" word word", 6));
    }

    @Test
    public void shouldSplitTwoWordsWhenSpaceBeforeBreak(){
        assertEquals("word\nword", WordWrapper.wrap("word word", 6));
    }
    @Test
    public void shouldSplitTwoWordsWhenSpaceAfterBreak(){
        assertEquals("word\nword", WordWrapper.wrap("word word", 4));
    }

    @Test
    public void shouldSplitThreeWordsWhenColumnLengthIsFive(){
        assertEquals("dolor\nsit\namet", WordWrapper.wrap("dolor sit amet", 5));
    }

    @Test
    public void shouldSplitThreeWordsWhenColumnLengthIsSix(){
        assertEquals("dolor\nsit\namet", WordWrapper.wrap("dolor sit amet", 6));
    }

    @Test
    public void shouldSplitThreeWordsWhenFirstLongerThanLengthOfColumn(){
        assertEquals("dolo\nr\nsit\namet", WordWrapper.wrap("dolor sit amet", 4));
    }

    @Test
    public void shouldSplitInTwoLinesWhenTwoWordsFitColumn(){
        assertEquals("dolor sit\namet", WordWrapper.wrap("dolor sit amet", 9));
    }

    @Test
    public void shouldSplitInFourLinesWhenWordsDontFitColumn(){
        assertEquals("wor\nd\nwor\nd", WordWrapper.wrap("word word", 3));
    }
}
