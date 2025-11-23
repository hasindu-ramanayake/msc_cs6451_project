package org.example.db;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class FileReaderService {
    public String loadFromFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

