package org.example.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {
    public List<String[]> loadFromFile(String filePath) {
        List<String[]> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read header
            String header = br.readLine();
            System.out.println("Header: " + header);
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                dataList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}

