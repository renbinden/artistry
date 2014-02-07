package io.github.lucariatias.artistry;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileManager {

    private Artistry artistry;

    public FileManager(Artistry artistry) {
        this.artistry = artistry;
    }

    public void openFile(File file) {
        try {
            Image image = ImageIO.read(file);
            artistry.setImage(image);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

}
