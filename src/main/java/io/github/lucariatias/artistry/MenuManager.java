package io.github.lucariatias.artistry;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuManager {

    private Artistry artistry;

    public MenuManager(Artistry artistry) {
        this.artistry = artistry;
    }

    public void setupMenu() {
        MenuBar menuBar = new MenuBar();
        menuBar.setName("Artistry");
        setupFileMenu(menuBar);
        setupEditMenu(menuBar);
        setupImageMenu(menuBar);
        setupLayerMenu(menuBar);
        setupFilterMenu(menuBar);
        artistry.setMenuBar(menuBar);
    }

    private void setupFileMenu(MenuBar menuBar) {
        Menu fileMenu = new Menu("File");
        setupMenuItem(fileMenu, "New...", KeyEvent.VK_N, new NewRunnable(artistry));
        setupMenuItem(fileMenu, "Open...", KeyEvent.VK_O, new OpenRunnable(artistry));
        menuBar.add(fileMenu);
    }

    private void setupEditMenu(MenuBar menuBar) {
        Menu editMenu = new Menu("Edit");
        menuBar.add(editMenu);
    }

    private void setupImageMenu(MenuBar menuBar) {
        Menu imageMenu = new Menu("Image");
        menuBar.add(imageMenu);
    }

    private void setupLayerMenu(MenuBar menuBar) {
        Menu layerMenu = new Menu("Layer");
        menuBar.add(layerMenu);
    }

    private void setupFilterMenu(MenuBar menuBar) {
        Menu filterMenu = new Menu("Filter");
        menuBar.add(filterMenu);
    }

    private void setupMenuItem(Menu menu, String title, int shortcut, final Runnable runnable) {
        setupMenuItem(menu, title, shortcut, false, runnable);
    }

    private void setupMenuItem(Menu menu, String title, int shortcut, boolean shortcutRequiresShiftModifier, final Runnable runnable) {
        MenuItem menuItem = new MenuItem(title);
        menuItem.setShortcut(new MenuShortcut(shortcut, shortcutRequiresShiftModifier));
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                runnable.run();
            }
        });
        menu.add(menuItem);
    }

}
