package pl.put.poznan.scenario.logic;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONReader {
    private File getFile(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();

        URL file = classLoader.getResource(fileName);
        if(file == null){
            throw new IllegalArgumentException("File not found");
        }
        return new File(file.getFile());
    }
    public String toString(String fileName){
        String path = getFile(fileName + ".json").getPath();
        String content = "";
        try{
            content = new String (Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
