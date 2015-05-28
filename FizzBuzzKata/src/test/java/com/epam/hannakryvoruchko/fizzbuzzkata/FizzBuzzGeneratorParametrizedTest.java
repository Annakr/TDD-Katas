package com.epam.hannakryvoruchko.fizzbuzzkata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Hanna_Kryvoruchko1 on 5/26/2015.
 */
@RunWith(Parameterized.class)
public class FizzBuzzGeneratorParametrizedTest {

    private int sequenceLength;
    private String expectedResult;
    private FizzBuzzGenerator fizzBuzzGenerator;

    public FizzBuzzGeneratorParametrizedTest(int sequenceLength, String expectedResult) {
        this.sequenceLength = sequenceLength;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        fizzBuzzGenerator = new FizzBuzzGenerator();
    }

    @Parameterized.Parameters
    public static Collection sequence() {
        return Arrays.asList(new Object[][]{
                {0, ""},
                {1, "1"},
                {2, "1,2"},
                {3, "1,2,Fizz"},
                {5, "1,2,Fizz,4,Buzz"},
                {6, "1,2,Fizz,4,Buzz,Fizz"},
                {15, "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz"},
        });
    }

    @Test
    public void testGenerateSequenceWithParams(){
        String sequence = fizzBuzzGenerator.generate(sequenceLength);
        Assert.assertEquals(expectedResult, sequence);
    }



}
