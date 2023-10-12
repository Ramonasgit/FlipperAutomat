package com.flipperautomat.composite;

public abstract class GameComponent {
    protected String name;

    public GameComponent(String name) {
        this.name = name;
    }

    public abstract void play();
}