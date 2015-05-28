package com.epam.hannakryvoruchko.wordwrap;

/**
 * Created by Hanna_Kryvoruchko1 on 5/27/2015.
 */
public class WordWrapper {

    public static final String LINE_SEPARATOR = "\n";

    public static String wrap(String sentence, int columnLength) {
        if(sentence.length() > columnLength) {
            String firstPartOfSentence;
            if (isSpaceOnBreak(sentence, columnLength)) {
                firstPartOfSentence = sentence.substring(0, columnLength - 1);
            } else {
                firstPartOfSentence = sentence.substring(0, columnLength);
            }
            String restOfSentence = sentence.substring(columnLength);
            return firstPartOfSentence + LINE_SEPARATOR + wrap(restOfSentence, columnLength);
        } else
            return sentence;
    }

    private static boolean isSpaceOnBreak(String sentence, int columnLength) {
        return sentence.charAt(columnLength - 1) == ' ';
    }
}
