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
                stringBuilder.append(i + ",");
            }
            String sequence = stringBuilder.toString();
            sequence = removeLastComma(sequence);
            return sequence;
        }

    }

    private String removeLastComma(String sequence) {
        return sequence.substring(0, sequence.length() - 1);
    }
}
