package io.github.lucariatias.artistry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ImagePanel extends JPanel {
    private Artistry artistry;
    public ImagePanel(Artistry artistry) {
        this.artistry = artistry;
        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent event) {
                Graphics graphics = ImagePanel.this.artistry.getImage().getGraphics();
                graphics.setColor(Color.BLUE);
                graphics.fillOval(event.getX() - 4, event.getY() - 4, 8, 8);
                graphics.dispose();
                ImagePanel.this.artistry.setImage(ImagePanel.this.artistry.getImage());
            }

            @Override
            public void mouseMoved(MouseEvent event) {

            }
        });
    }
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(artistry.getImage(), 0, 0, null);
    }
}
