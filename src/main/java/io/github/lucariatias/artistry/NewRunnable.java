package io.github.lucariatias.artistry;

public class NewRunnable implements Runnable {

    private Artistry artistry;

    public NewRunnable(Artistry artistry) {
        this.artistry = artistry;
    }

    @Override
    public void run() {
        new NewDialog(artistry);
    }

}
