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
    public void testGenerate(){
        fizzBuzzGenerator.generate(0);
    }

}
