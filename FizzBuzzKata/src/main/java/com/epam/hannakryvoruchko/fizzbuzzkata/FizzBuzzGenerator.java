package com.epam.hannakryvoruchko.fizzbuzzkata;

/**
 * Created by Hanna_Kryvoruchko1 on 5/25/2015.
 */
public class FizzBuzzGenerator {

    public static final String DIVISIBLE_BY_THREE_MARK = "Fizz";
    public static final String DIVISIBLE_BY_FIVE_MARK = "Buzz";
    public static final String DELIMITER = ",";

    public String generate(int sequenceLength) {
        if (sequenceLength < 1)
            return "";
        else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i <= sequenceLength; i++) {
                if (!isDivisibleByThree(i) && !isDivisibleByFive(i))
                    stringBuilder.append(i);
                else
                    if (isDivisibleByThree(i))
                        stringBuilder.append(DIVISIBLE_BY_THREE_MARK);
                    if (isDivisibleByFive(i))
                        stringBuilder.append(DIVISIBLE_BY_FIVE_MARK);
                stringBuilder.append(DELIMITER);
            }
            return removeLastDelimiter(stringBuilder.toString());
        }

    }

    private boolean isDivisibleByFive(int i) {
        return isDivisibleBy(i, 5);
    }

    private boolean isDivisibleByThree(int i) {
        return isDivisibleBy(i, 3);
    }

    private boolean isDivisibleBy(int integer, int divider) {
        if ((integer % divider) == 0)
            return true;
        else
            return false;
    }

    private String removeLastDelimiter(String sequence) {
        return sequence.substring(0, sequence.length() - 1);
    }
}
