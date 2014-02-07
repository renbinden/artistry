package io.github.lucariatias.artistry;

import javax.swing.*;

public class ToolPanel extends JPanel {

    public ToolPanel() {
        JButton brushButton = new JButton();
        brushButton.setIcon(new ImageIcon(getClass().getResource("/brush.png")));
    }

}
