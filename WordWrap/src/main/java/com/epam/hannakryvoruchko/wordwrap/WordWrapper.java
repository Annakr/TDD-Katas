package com.epam.hannakryvoruchko.wordwrap;

public class WordWrapper {

    public static final String LINE_SEPARATOR = "\n";
    public static final char SPACE_CHAR = ' ';

    public static String wrap(String sentence, int columnLength) {
        if(sentence.length() > columnLength) {
            int indexOfBreak;
            int indexOfNewLineStart;
            if (isSpaceRightBeforeBreak(sentence, columnLength)) {
                indexOfBreak = columnLength - 1;
                indexOfNewLineStart = columnLength;
            } else if (isSpaceRightAfterBreak(sentence, columnLength)) {
                indexOfBreak = columnLength;
                indexOfNewLineStart = columnLength + 1;
            } else if (containsSpaceBeforeBreak(sentence, columnLength)) {
                int indexOfSpace = getIndexOfSpace(sentence, columnLength);
                indexOfBreak = indexOfSpace;
                indexOfNewLineStart = indexOfSpace + 1;
            } else {
                indexOfBreak = columnLength;
                indexOfNewLineStart = columnLength;
            }
            String firstLineOfSentence = sentence.substring(0, indexOfBreak);
            String restOfSentence = sentence.substring(indexOfNewLineStart);
            return firstLineOfSentence + LINE_SEPARATOR + wrap(restOfSentence, columnLength);
        } else
            return sentence;
    }

    private static boolean isSpaceRightBeforeBreak(String sentence, int columnLength) {
        return sentence.charAt(columnLength - 1) == SPACE_CHAR;
    }

    private static boolean isSpaceRightAfterBreak(String sentence, int columnLength) {
        return sentence.charAt(columnLength) == SPACE_CHAR;
    }

    private static boolean containsSpaceBeforeBreak(String sentence, int columnLength) {
        String firstLine = sentence.substring(0, columnLength);
        return firstLine.lastIndexOf(String.valueOf(SPACE_CHAR)) != -1;
    }

    private static int getIndexOfSpace(String sentence, int columnLength) {
        String firstLine = sentence.substring(0, columnLength);
        return firstLine.lastIndexOf(String.valueOf(SPACE_CHAR));
    }

}
