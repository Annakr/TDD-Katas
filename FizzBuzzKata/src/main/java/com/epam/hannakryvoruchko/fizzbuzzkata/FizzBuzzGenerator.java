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
                if (divisibleByThree(i))
                    stringBuilder.append("Fizz,");
                else if (divisibleByFive(i))
                    stringBuilder.append("Buzz,");
                else
                    stringBuilder.append(i + ",");
            }
            String sequence = stringBuilder.toString();
            sequence = removeLastComma(sequence);
            return sequence;
        }

    }

    private boolean divisibleByFive(int i) {
        if ((i % 5) == 0)
            return true;
        else
            return false;
    }

    private boolean divisibleByThree(int i) {
        if ((i % 3) == 0)
            return true;
        else
            return false;
    }

    private String removeLastComma(String sequence) {
        return sequence.substring(0, sequence.length() - 1);
    }
}
