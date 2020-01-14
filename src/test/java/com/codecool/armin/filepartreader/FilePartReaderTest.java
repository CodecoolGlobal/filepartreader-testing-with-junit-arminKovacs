package com.codecool.armin.filepartreader;

import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    void testFileFound() throws IOException {
        FilePartReader fpr = new FilePartReader();
        assertNotNull(fpr.read("fileTest"));
    }

    @Test
    void testSetupExceptionThrowFromLineLarger() throws IOException {
        FilePartReader fpr = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () ->
                fpr.setup("fileTest", 21, 2));
    }

    @Test
    void testSetupExceptionThrowFromLineNegative() throws IOException {
        FilePartReader fpr = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () ->
                fpr.setup("fileTest", -1, 2));
    }

    @Test
    void testReadLinesFirstLine() throws IOException {
        FilePartReader fpr = new FilePartReader();
        assertEquals("First line", fpr.readLines("fileTest", 1, 1));
    }

    @Test
    void testReadLinesFiveLines() throws IOException {
        FilePartReader fpr = new FilePartReader();
        assertEquals("First line\nSecond line\nThird line\nFourth line\nFifth line", fpr.readLines("fileTest", 1, 5));
    }


}