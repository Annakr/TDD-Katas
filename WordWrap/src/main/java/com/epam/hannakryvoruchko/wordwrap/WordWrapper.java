package com.epam.hannakryvoruchko.wordwrap;

public class WordWrapper {

    public static final String LINE_SEPARATOR = "\n";
    public static final String SPACE_SYMBOL = " ";

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
            String firstPartOfSentence = sentence.substring(0, indexOfBreak);
            String restOfSentence = sentence.substring(indexOfNewLineStart);
            return firstPartOfSentence + LINE_SEPARATOR + wrap(restOfSentence, columnLength);
        } else
            return sentence;
    }

    private static int getIndexOfSpace(String sentence, int columnLength) {
        String firstLine = sentence.substring(0, columnLength);
        return firstLine.lastIndexOf(SPACE_SYMBOL);
    }

    private static String removeSpaceAtTheBeginning(String restOfSentence) {
        return restOfSentence.substring(1);
    }

    private static boolean breaksWord(String restOfSentence) {
        return !restOfSentence.startsWith(SPACE_SYMBOL);
    }

    private static boolean containsSpaceBeforeBreak(String sentence, int columnLength) {
        String firstLine = sentence.substring(0, columnLength);
        return firstLine.lastIndexOf(SPACE_SYMBOL) != -1;
    }

    private static boolean isSpaceRightBeforeBreak(String sentence, int columnLength) {
        return sentence.charAt(columnLength - 1) == ' ';
    }

    private static boolean isSpaceRightAfterBreak(String sentence, int columnLength) {
        return sentence.charAt(columnLength) == ' ';
    }
}
