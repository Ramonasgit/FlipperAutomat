package com.flipperautomat.composite;

import com.flipperautomat.command.Command;
import com.flipperautomat.mediator.FlipperMediator;

public class Bumper extends GameComponent {

    private final FlipperMediator mediator;

    public Bumper(FlipperMediator mediator, Command command) {
        this.mediator = mediator;
        this.command = command;
        mediator.addTarget(this);
    }

    @Override
    public void hit() {
        command.execute();
        for (GameComponent child : children) {
            child.hit();
        }
        mediator.targetHit(this);
    }
}