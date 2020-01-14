package com.codecool.armin.filepartreader;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Arrays;


public class FilePartReader {

    FilePartReader() {}

    public void setup(String filePath, Integer fromLine, Integer toLine) throws IOException {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException("Wrong from line");
        }
    }

    public String read(String filePath) throws IOException {
        String line = null;

        StringBuilder result = new StringBuilder();

        FileReader fileReader = new FileReader(filePath);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((line = bufferedReader.readLine()) != null) {
            result.append(line).append("\n");
        }

        bufferedReader.close();

        return result.toString();
    }

    public String readLines(String filePath, Integer fromLine, Integer toLine ) throws IOException {
        String[] fileString = read(filePath).split("\n");
        Integer lineCounter = 1;
        StringBuilder resultString = new StringBuilder();

        for (String line : fileString) {
            if (lineCounter >= fromLine) {
                resultString.append(line).append("\n");
            }
            lineCounter ++;
            if (lineCounter > toLine) {
                break;
            }
        }

        return StringUtils.chomp(resultString.toString());
    }
}
