package Handlers;


import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface FileHandler {
    default void createFile(String filename) throws IOException {
        Path filePath = Path.of(filename);
        Files.createFile(filePath);
    }
    default void openFile(String filename) throws FileNotFoundException {

    }
    void readFile()
}
