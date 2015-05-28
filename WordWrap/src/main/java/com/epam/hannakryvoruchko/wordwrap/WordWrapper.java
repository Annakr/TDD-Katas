package com.epam.hannakryvoruchko.wordwrap;

public class WordWrapper {

    public static final String LINE_SEPARATOR = "\n";
    public static final String SPACE_SYMBOL = " ";

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
                if (breaksWordAndContainsSpaceBefore(firstPartOfSentence, restOfSentence)) {
                    int indexOfSpace = getIndexOfLastSpace(firstPartOfSentence);
                    firstPartOfSentence = sentence.substring(0, indexOfSpace);
                    restOfSentence = sentence.substring(indexOfSpace + 1);
                }
                if(restOfSentence.startsWith(SPACE_SYMBOL))
                    restOfSentence = removeSpaceAtTheBeginning(restOfSentence);
            }
            return firstPartOfSentence + LINE_SEPARATOR + wrap(restOfSentence, columnLength);
        } else
            return sentence;
    }

    private static String removeSpaceAtTheBeginning(String restOfSentence) {
        return restOfSentence.substring(1);
    }

    private static boolean breaksWordAndContainsSpaceBefore(String firstPartOfSentence, String restOfSentence) {
        return sentenceContainsSpaceBeforeBreak(firstPartOfSentence) && breaksWord(restOfSentence);
    }

    private static boolean breaksWord(String restOfSentence) {
        return !restOfSentence.startsWith(SPACE_SYMBOL);
    }

    private static int getIndexOfLastSpace(String firstPartOfSentence) {
        return firstPartOfSentence.lastIndexOf(SPACE_SYMBOL);
    }

    private static boolean sentenceContainsSpaceBeforeBreak(String sentence) {
        return getIndexOfLastSpace(sentence) != -1;
    }

    private static boolean isSpaceOnBreak(String sentence, int columnLength) {
        return sentence.charAt(columnLength - 1) == ' ';
    }
}
