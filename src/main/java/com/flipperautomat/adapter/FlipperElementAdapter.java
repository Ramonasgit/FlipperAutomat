package com.flipperautomat.adapter;

import com.flipperautomat.command.Command;
import com.flipperautomat.composite.GameComponent;
import com.flipperautomat.composite.IncompatibleElement;

public class FlipperElementAdapter extends GameComponent {

    private final IncompatibleElement incompatibleElement;

    public FlipperElementAdapter(IncompatibleElement incompatibleElement, Command command) {
        this.incompatibleElement = incompatibleElement;
        this.command = command;
    }

    @Override
    public void hit() {
        command.execute();
        incompatibleElement.doSomething();
    }
}