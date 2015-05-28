package com.epam.hannakryvoruchko.wordwrap;

/**
 * Created by Hanna_Kryvoruchko1 on 5/27/2015.
 */
public class WordWrapper {

    public static final String LINE_SEPARATOR = "\n";
    public static final char SPACE_CHAR = ' ';

    public static String wrap(String sentence, int columnLength) {
        if(sentence.length() > columnLength) {
            String firstPartOfSentence;
            String restOfSentence;
            if (isSpaceOnBreak(sentence, columnLength)) {
                firstPartOfSentence = sentence.substring(0, columnLength - 1);
                restOfSentence = sentence.substring(columnLength);
            } else {
                firstPartOfSentence = sentence.substring(0, columnLength);
                restOfSentence = sentence.substring(columnLength);
                if (sentenceContainsSpace(firstPartOfSentence) && !restOfSentence.startsWith(String.valueOf(SPACE_CHAR)) ) {
                    int indexOfSpace = getIndexOfLastSpace(firstPartOfSentence);
                    firstPartOfSentence = sentence.substring(0, indexOfSpace);
                    restOfSentence = sentence.substring(indexOfSpace + 1);
                }
                if(restOfSentence.startsWith(String.valueOf(SPACE_CHAR)))
                    restOfSentence = restOfSentence.substring(1);
            }
            return firstPartOfSentence + LINE_SEPARATOR + wrap(restOfSentence, columnLength);
        } else
            return sentence;
    }

    private static int getIndexOfLastSpace(String firstPartOfSentence) {
        return firstPartOfSentence.lastIndexOf(SPACE_CHAR);
    }

    private static boolean sentenceContainsSpace(String sentence) {
        return getIndexOfLastSpace(sentence) != -1;
    }

    private static boolean isSpaceOnBreak(String sentence, int columnLength) {
        return sentence.charAt(columnLength - 1) == SPACE_CHAR;
    }
}
