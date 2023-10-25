package com.flipperautomat.kompositum;

import com.flipperautomat.commands.Command;
import com.flipperautomat.visitor.Visitor;

public class Hole implements PinballElement {
    private String holeName;
    private Command holeCommand;

    public Hole(String holeName, Command holeCommand) {
        this.holeName = holeName;
        this.holeCommand = holeCommand;
    }

    @Override
    public void hit() {
        System.out.println("A BALL WAS LOST!");
        holeCommand.execute(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
