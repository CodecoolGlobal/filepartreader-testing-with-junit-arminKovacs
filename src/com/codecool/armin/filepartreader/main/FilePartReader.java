package com.codecool.armin.filepartreader.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FilePartReader {

    private String test;

    FilePartReader(Integer test) {
        this.test = test;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException("Wrong from line");
        }
    }

    public String read() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("fileTest.txt");
        StringBuilder resultStringBuilder = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = br.readLine()) != null) {
            resultStringBuilder.append(line).append("\n");
        }

        return resultStringBuilder.toString();
    }

    public String readLines(Integer fromLine, Integer toLine ) throws IOException {
        String[] fileString = read().split("\n");
        Integer counter = 1;
        StringBuilder resultString = new StringBuilder();

        for (String line : fileString) {
            if (fromLine.equals(counter)) {
                resultString.append(line).append("\n");
            }
            counter ++;
            if(counter.equals(toLine)) {
                break;
            }
        }

        return resultString.toString();
    }
}
