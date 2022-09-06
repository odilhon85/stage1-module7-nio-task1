package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.List;


public class FileReader {


    public Profile getDataFromFile(File file) {

        List<String> data = readData(file);

        return new Profile(getString(data.get(0)), getInt(data.get(1)),getString(data.get(2)),getLong(data.get(3)));
    }

    public List<String> readData(File file){
        List<String> data = null;
        try(FileChannel channel = null){
            data = Files.readAllLines(file.toPath());
        }catch(IOException e){
            e.printStackTrace();
        }
        return data;
    }

    public String getString(String value){
        int index = value.indexOf(' ');
        return value.substring(index).trim();
    }

    public int getInt(String value){
        int index = value.indexOf(' ');
        return Integer.parseInt(value.substring(index).trim());
    }

    public long getLong(String value){
        int index = value.indexOf(' ');
        return Long.parseLong(value.substring(index).trim());
    }
}
