package com.codecool.armin.filepartreader;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Test
    void testGetWordsOrderedAlphabetically() throws IOException {
        FilePartReader fpr = new FilePartReader();
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        List<String> expectedResult = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        assertEquals(expectedResult, fwa.getWordsOrderedAlphabetically());
    }

    @Test
    void testGetWordsContainingSubstring() throws IOException {
        FilePartReader fpr = new FilePartReader();
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        List<String> expectedResult = new ArrayList<>(Arrays.asList("a"));
        assertEquals(expectedResult, fwa.getWordsContainingSubstring("a"));
    }

    @Test
    void testGetStringsWhichPalindromes() throws IOException {
        FilePartReader fpr = new FilePartReader();
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        List<String> expectedResult = new ArrayList<>(Arrays.asList("b", "a", "c", "e", "d"));
        assertEquals(expectedResult, fwa.getStringsWhichPalindromes());
    }

}