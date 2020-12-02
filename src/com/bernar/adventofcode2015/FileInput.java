package com.bernar.adventofcode2015;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileInput {

    private static FileInput instance = null;

    private FileInput() {}

    public static FileInput getInstance() {
        if (instance == null) {
            instance = new FileInput();
        }
        return instance;
    }

    public List<String> readStringFromFile(String fileName) {
        InputStream resource = getClass().getClassLoader().getResourceAsStream(fileName);
        if (resource != null) {
            return new BufferedReader(new InputStreamReader(resource,
                    StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
