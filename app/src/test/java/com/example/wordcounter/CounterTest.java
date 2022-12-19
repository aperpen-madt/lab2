package com.example.wordcounter;

import org.junit.Test;

import static org.junit.Assert.*;

import utils.Counter;

public class CounterTest {
    @Test
    public void TestCountWordsWhenSpacedString() {
        final String input = "Hello world this is a test";
        final int expectedResult = 6;
        final int actualResult = new Counter(input).countWords();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestCountWordsWhenPunctuatedString() {
        final String input = "Hello world, this is a test";
        final int expectedResult = 6;
        final int actualResult = new Counter(input).countWords();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestCountWordsWhenEmptyString() {
        final String input = "";
        final int expectedResult = 0;
        final int actualResult = new Counter(input).countWords();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestCountWordsWhenFinalSeparator() {
        final String input = "Hello, this is a test with a final dot.";
        final int expectedResult = 9;
        final int actualResult = new Counter(input).countWords();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestCountWordsWhenConsecutiveSeparators() {
        final String input = "Hello, this is a  test with  double space.";
        final int expectedResult = 8;
        final int actualResult = new Counter(input).countWords();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestCountChars() {
        final String input = "Hello world, this is a test.";
        final int expectedResult = 28;
        final int actualResult = new Counter(input).countChars();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestCountCharsWhenEmptyString() {
        final String input = "";
        final int expectedResult = 0;
        final int actualResult = new Counter(input).countChars();

        assertEquals(expectedResult, actualResult);
    }
}