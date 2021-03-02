package com.example.app.utils;

import org.junit.Assert;
import org.junit.Test;

public class UtilsUnitTest {
    @Test
    public void testCalculate(){
        final Double expected = Double.valueOf(-1);
        Calculator calculator = new Calculator();
        final Double actual = calculator.calculate("12/2-21/3");
        Assert.assertEquals(expected, actual);
    }
}
