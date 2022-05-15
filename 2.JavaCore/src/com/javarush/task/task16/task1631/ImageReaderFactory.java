package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader (ImageTypes it) {
        if (it == null) {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        ImageReader toReturn = null;
        switch (it) {
            case PNG:
                toReturn = new PngReader();
                break;
            case JPG:
                toReturn = new JpgReader();
                break;
            case BMP:
                toReturn = new BmpReader();
                break;
            default: throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return toReturn;
    }
}
