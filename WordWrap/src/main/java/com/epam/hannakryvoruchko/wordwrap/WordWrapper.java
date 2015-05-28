package com.epam.hannakryvoruchko.wordwrap;

/**
 * Created by Hanna_Kryvoruchko1 on 5/27/2015.
 */
public class WordWrapper {

    public static final String LINE_SEPARATOR = "\n";

    public static String wrap(String sentence, int columnLength) {
        if(sentence.length() > columnLength) {
            String firstPartOfSentence;
            String restOfSentence;
            if (isSpaceOnBreak(sentence, columnLength)) {
                firstPartOfSentence = sentence.substring(0, columnLength - 1);
                restOfSentence = sentence.substring(columnLength);
            } else {
                firstPartOfSentence = sentence.substring(0, columnLength);
                if (firstPartOfSentence.lastIndexOf(' ') != -1) {
                    int indexOfSpace = firstPartOfSentence.lastIndexOf(' ');
                    firstPartOfSentence = sentence.substring(0, indexOfSpace);
                    restOfSentence = sentence.substring(indexOfSpace + 1);
                } else
                    restOfSentence = sentence.substring(columnLength);
            }
            return firstPartOfSentence + LINE_SEPARATOR + wrap(restOfSentence, columnLength);
        } else
            return sentence;
    }

    private static boolean isSpaceOnBreak(String sentence, int columnLength) {
        return sentence.charAt(columnLength - 1) == ' ';
    }
}
