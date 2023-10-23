package com.flipperautomat.composite;

import com.flipperautomat.command.Command;

public class Hole extends GameComponent {

    private final Command command;

    public Hole(Command command) {
        this.command = command;
    }

    @Override
    public void hit() {
        command.execute();
    }
}