package com.flipperautomat.composite;

public class Bumper extends GameComponent {

    public Bumper(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Bumping at " + name);
    }
}