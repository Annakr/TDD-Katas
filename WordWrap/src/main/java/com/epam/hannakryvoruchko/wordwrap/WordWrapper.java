package com.epam.hannakryvoruchko.wordwrap;

/**
 * Created by Hanna_Kryvoruchko1 on 5/27/2015.
 */
public class WordWrapper {
    public static String wrap(String sentence, int columnLength) {
        if(sentence.length() > columnLength)
            return sentence.substring(0, columnLength) + "\n" + sentence.substring(columnLength);
        else
            return sentence;
    }
}
