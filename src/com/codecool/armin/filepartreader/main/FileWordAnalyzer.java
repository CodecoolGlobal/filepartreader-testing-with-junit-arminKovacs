package com.codecool.armin.filepartreader.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List getWordsOrderedAlphabetically () throws IOException {
        List<String> result = Arrays.asList(filePartReader.readLines(1, 5).split("\\s+"));
        Collections.sort(result);
        return result;
    }

    public List getWordsContainingSubstring(String subString) throws IOException {
        String[] textList = filePartReader.readLines(1, 5).split("\\s+");
        List<String> result = new ArrayList<>();
        for (String word : textList) {
            if(word.contains(subString)) {
                result.add(word);
            }
        }
        return result;
    }

    public List getStringsWhichPalindromes () throws IOException {
        String[] textList = filePartReader.readLines(1, 5).split("\\s+");
        List<String> result = new ArrayList<>();
        for (String word : textList) {
            String reverseWord = new StringBuilder().append(word).reverse().toString();
            if (word.toLowerCase().equals(reverseWord.toLowerCase())) {
                result.add(word);
            }
        }
        return result;
    }
}
