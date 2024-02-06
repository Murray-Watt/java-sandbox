package org.mwatt.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordFrequencyTest {
    @Test
    public void testIncFrequency() {
        WordFrequency wordFrequency = new WordFrequency("test",1L);

        wordFrequency.incFrequency();
        assertEquals(2L, wordFrequency.getCount());

        wordFrequency.incFrequency(3);
        assertEquals(5L, wordFrequency.getCount());
    }

    @Test
    public void testCompareTo() {
        WordFrequency wordFrequency1 = new WordFrequency("apple",5L);
        WordFrequency wordFrequency2 = new WordFrequency("banana",5L);
        WordFrequency wordFrequency3 = new WordFrequency("apple",10L);

        // Test compareTo for equality
        assertEquals(0, wordFrequency1.compareTo(wordFrequency1));

        // Test compareTo for less than
        assertTrue(wordFrequency1.compareTo(wordFrequency2) < 0);

        // Test compareTo for greater than
        assertTrue(wordFrequency2.compareTo(wordFrequency1) > 0);

        // Test compareTo for comparing counts when keys are equal
        assertTrue(wordFrequency1.compareTo(wordFrequency3) < 0);
        assertTrue(wordFrequency3.compareTo(wordFrequency1) > 0);
    }
}