package io.github.lucariatias.artistry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Artistry extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel imagePanel;
    private Image image;

    private MenuManager menuManager = new MenuManager(this);
    private FileManager fileManager = new FileManager(this);

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Artistry frame = new Artistry();
                    frame.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    public Artistry() {
        setTitle("Artistry");
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 640, 480);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBounds(0, 0, 640, 480);
        image = new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);
        imagePanel = new ImagePanel(this);
        imagePanel.setBounds((getWidth() - image.getWidth(null)) / 2, (getHeight() - image.getHeight(null)) / 2, (getWidth() + image.getWidth(null)) / 2, (getHeight() + image.getHeight(null)) / 2);
        contentPane.add(imagePanel);
        setContentPane(contentPane);
        setupMenu();
        addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent event) {
                imagePanel.setBounds((getWidth() - image.getWidth(null)) / 2, (getHeight() - image.getHeight(null)) / 2, (getWidth() + image.getWidth(null)) / 2, (getHeight() + image.getHeight(null)) / 2);
            }

            @Override
            public void componentMoved(ComponentEvent event) {

            }

            @Override
            public void componentShown(ComponentEvent event) {

            }

            @Override
            public void componentHidden(ComponentEvent event) {

            }

        });
    }
    
    private void setupMenu() {
        menuManager.setupMenu();
    }

    public void openFile(File file) {
        fileManager.openFile(file);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        imagePanel.setBounds((getWidth() - image.getWidth(null)) / 2, (getHeight() - image.getHeight(null)) / 2, (getWidth() + image.getWidth(null)) / 2, (getHeight() + image.getHeight(null)) / 2);
        imagePanel.repaint();
    }
    
}
