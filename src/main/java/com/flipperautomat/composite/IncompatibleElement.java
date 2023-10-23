package com.flipperautomat.composite;

import com.flipperautomat.command.Command;

public class IncompatibleElement extends GameComponent{

    private final Command command;
    public IncompatibleElement(Command command) {
        this.command = command;
    }

    public void doSomething() {
        System.out.println("Doing something in the incompatible flipper element!");
    }

    @Override
    public void hit() {
        command.execute();
    }
}