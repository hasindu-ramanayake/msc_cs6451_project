package org.example.db;

public class FileDbAdapter implements IDbAdapter {
    private FileReaderService fileReader;

    public FileDbAdapter(FileReaderService fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public String readData(String source) {
        return fileReader.loadFromFile(source);
    }
    // add function to implement from interface

}
