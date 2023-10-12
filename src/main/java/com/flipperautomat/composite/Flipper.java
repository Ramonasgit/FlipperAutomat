package com.flipperautomat.composite;

public class Flipper extends GameComponent {

    public Flipper(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Playing with " + name);
    }
}