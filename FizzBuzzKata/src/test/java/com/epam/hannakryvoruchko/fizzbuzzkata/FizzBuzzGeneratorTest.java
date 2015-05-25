package com.epam.hannakryvoruchko.fizzbuzzkata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Hanna_Kryvoruchko1 on 5/25/2015.
 */
public class FizzBuzzGeneratorTest {

    private FizzBuzzGenerator fizzBuzzGenerator;

    @Before
    public void setUp() {
        fizzBuzzGenerator = new FizzBuzzGenerator();
    }

    @Test
    public void testGenerateZeroLength(){
        String sequence = fizzBuzzGenerator.generate(0);
        Assert.assertEquals("", sequence);
    }

    @Test
    public void testGenerateNegativeLength(){
        String sequence = fizzBuzzGenerator.generate(-1);
        Assert.assertEquals("", sequence);
    }

    @Test
    public void testGenerateOneNumberLength(){
        String sequence = fizzBuzzGenerator.generate(1);
        Assert.assertEquals("1", sequence);
    }

    @Test
    public void testGenerateTwoNumbersLength(){
        String sequence = fizzBuzzGenerator.generate(2);
        Assert.assertEquals("1,2", sequence);
    }

    @Test
    public void testGenerateThreeNumbersLength(){
        String sequence = fizzBuzzGenerator.generate(3);
        Assert.assertEquals("1,2,Fizz", sequence);
    }

}
