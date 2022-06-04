package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    private FileInputStream fis;

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        if (getExtension(fileName).equals("txt")) {
            this.fis = new FileInputStream(fileName);
        }
        else {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public String getExtension (String file) {
        String[] data = file.split("\\.");
        return data[data.length - 1];
    }

    public static void main(String[] args) {
    }
}

