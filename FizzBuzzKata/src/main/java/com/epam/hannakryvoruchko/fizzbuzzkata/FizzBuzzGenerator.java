package com.epam.hannakryvoruchko.fizzbuzzkata;

/**
 * Created by Hanna_Kryvoruchko1 on 5/25/2015.
 */
public class FizzBuzzGenerator {

    public String generate(int sequenceLength) {
        if (sequenceLength < 1)
            return "";
        else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i <= sequenceLength; i++) {
                if (isDivisibleByThree(i))
                    stringBuilder.append("Fizz");
                else if (isDivisibleByFive(i))
                    stringBuilder.append("Buzz");
                else
                    stringBuilder.append(i);
                stringBuilder.append(",");
            }
            String sequence = stringBuilder.toString();
            sequence = removeLastComma(sequence);
            return sequence;
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

    private String removeLastComma(String sequence) {
        return sequence.substring(0, sequence.length() - 1);
    }
}
