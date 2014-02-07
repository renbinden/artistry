package io.github.lucariatias.artistry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class NewDialog extends JFrame {

    private Artistry artistry;
    private JPanel contentPane;

    public NewDialog(Artistry artistry) {
        this.artistry = artistry;
        contentPane = new JPanel();
        setLayout(null);
        setSize(320, 240);
        setTitle("New");
        contentPane.setLayout(null);
        JLabel widthLabel = new JLabel("Width: ");
        widthLabel.setBounds(16, 16, 128, 24);
        contentPane.add(widthLabel);
        final JSpinner widthSpinner = new JSpinner();
        widthSpinner.setBounds(144, 16, 128, 24);
        contentPane.add(widthSpinner);
        JLabel heightLabel = new JLabel("Height: ");
        heightLabel.setBounds(16, 48, 128, 24);
        contentPane.add(heightLabel);
        final JSpinner heightSpinner = new JSpinner();
        heightSpinner.setBounds(144, 48, 128, 24);
        contentPane.add(heightSpinner);
        JLabel colourSpaceLabel = new JLabel("Colour space: ");
        colourSpaceLabel.setBounds(16, 80, 128, 24);
        contentPane.add(colourSpaceLabel);
        final JComboBox<String> colourSpaceBox = new JComboBox<>(new String[] {"RGB", "Greyscale"});
        colourSpaceBox.setBounds(144, 80, 128, 24);
        contentPane.add(colourSpaceBox);
        JLabel backgroundColourLabel = new JLabel("Background colour: ");
        backgroundColourLabel.setBounds(16, 112, 128, 24);
        contentPane.add(backgroundColourLabel);
        final JComboBox<String> backgroundColourBox = new JComboBox<>(new String[] {"Foreground colour", "Background colour", "White", "Black", "Transparency"});
        backgroundColourBox.setBounds(144, 112, 128, 24);
        contentPane.add(backgroundColourBox);
        JButton submitButton = new JButton("OK");
        submitButton.setBounds(16, 144, 256, 24);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                BufferedImage newImage = new BufferedImage((int) widthSpinner.getValue(), (int) heightSpinner.getValue(), colourSpaceBox.getSelectedItem().equals("RGB") ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_BYTE_GRAY);
                Graphics graphics = newImage.getGraphics();
                if (backgroundColourBox.getSelectedItem().equals("Foreground colour") || backgroundColourBox.getSelectedItem().equals("Black")) {
                    graphics.setColor(Color.BLACK);
                    graphics.fillRect(0, 0, newImage.getWidth(), newImage.getHeight());
                }
                if (backgroundColourBox.getSelectedItem().equals("Background colour") || backgroundColourBox.getSelectedItem().equals("White")) {
                    graphics.setColor(Color.WHITE);
                    graphics.fillRect(0, 0, newImage.getWidth(), newImage.getHeight());
                }
                NewDialog.this.artistry.setImage(newImage);
                NewDialog.this.dispose();
            }
        });
        contentPane.add(submitButton);
        setContentPane(contentPane);
        setResizable(false);
        setVisible(true);
    }

}
