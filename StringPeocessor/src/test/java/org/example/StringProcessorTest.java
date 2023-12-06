package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringProcessorTest{

    @Test
    public void StrongPassword() {
        StringProcessor sp = new StringProcessor();
        assertTrue(sp.isStrongPassword("2345Asfdhh458.gh$"));
        assertTrue(sp.isStrongPassword("Ainazik.BAkyt23454$$"));
        assertTrue(sp.isStrongPassword("2volleT.234$$"));
        assertTrue(sp.isStrongPassword("23Myskal%%.2023"));
        assertTrue(sp.isStrongPassword("onLine2023.20$$"));
    }

    @Test
    public void CountDigit() {
        StringProcessor sp = new StringProcessor();
        assertEquals(7, sp.calculateDigits("vegegwege635g8333"));
        assertEquals(4, sp.calculateDigits("vegegwege635g8ab"));
        assertEquals(3, sp.calculateDigits("vegegwege635g"));
        assertEquals(9, sp.calculateDigits("456525836"));
        assertEquals(2, sp.calculateDigits("vaf12"));
    }

    @Test
    public void countWords() {
        StringProcessor sp = new StringProcessor();
        assertEquals(4, sp.calculateWords("My name is Ainazik") , 0.001);
        assertEquals(3, sp.calculateWords("Ala-Too International University") , 0.001);
        assertEquals(3, sp.calculateWords("I love cooking") , 0.001);
        assertEquals(4, sp.calculateWords("She is very good") , 0.001);
        assertEquals(2, sp.calculateWords("Ainazik Bakytbek") , 0.001);
    }

    @Test
    public void notStrong() {
        StringProcessor sp = new StringProcessor();
        assertFalse(sp.isStrongPassword("3443"));
        assertFalse(sp.isStrongPassword("55522f"));
        assertFalse(sp.isStrongPassword("asdf452"));
        assertFalse(sp.isStrongPassword("421m"));
        assertFalse(sp.isStrongPassword("a3"));
    }


    @Test
    public void testExpression(){
        StringProcessor sp = new StringProcessor();
        assertEquals(4.5, sp.calculateExpression("(2 + 1)*3/2") , 0.001);
        assertEquals(8.5, sp.calculateExpression("(1 + 1)*3+5/2") , 0.001);
        assertEquals(134, sp.calculateExpression("2 * 2 + (2 * 65)") , 0.001);
        assertEquals(165, sp.calculateExpression("45 + 2 * 120 / (1+1)") , 0.001);
        assertEquals(330, sp.calculateExpression("600/3 + (65 * 2)") , 0.001);
    }

}

