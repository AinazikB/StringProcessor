package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringProcessorTest{

    @Test
    public void StrongPassword() {
        StringProcessor sp = new StringProcessor();
        assertTrue(sp.isStrongPassword("2345Asfdhh458.gh$"));
    }

    @Test
    public void CountDigit() {
        StringProcessor sp = new StringProcessor();
        int expected = 7;
        int actual = sp.calculateDigits("vegegwege635g8333");
        assertEquals(expected, actual);
    }

    @Test
    public void countWords() {
        StringProcessor sp = new StringProcessor();
        int expected = 4;
        int actual = sp.calculateWords("My name is Ainazik");
    }

    @Test
    public void notStrong() {
        StringProcessor sp = new StringProcessor();
        assertFalse(sp.isStrongPassword("3443"));
    }

    @Test
    public void resExpression() {
        StringProcessor sp = new StringProcessor();
        double expected = 0.0;
        double actual = sp.calculateExpression("vgvdhss");
        double delta = 0.001;
        assertEquals(expected, actual, delta);
    }
}