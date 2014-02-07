package io.github.lucariatias.artistry;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;

public class OpenRunnable implements Runnable {

    private Artistry artistry;

    public OpenRunnable(Artistry artistry) {
        this.artistry = artistry;
    }

    @Override
    public void run() {
        FileDialog dialog = new FileDialog(artistry, "Open", FileDialog.LOAD);
        dialog.setFilenameFilter(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                for (String fileSuffix : ImageIO.getReaderFileSuffixes()) {
                    if (name.endsWith(fileSuffix)) {
                        return true;
                    }
                }
                return false;
            }
        });
        dialog.setVisible(true);
        artistry.openFile(dialog.getFiles()[0]);
    }

}
