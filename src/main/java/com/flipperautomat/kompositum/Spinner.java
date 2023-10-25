package com.flipperautomat.kompositum;

import com.flipperautomat.commands.Command;
import com.flipperautomat.visitor.Visitor;

public class Spinner implements PinballElement {
    private String spinnerName;
    private int hitCount = 0;
    private Command spinnerCommand;

    public Spinner(String spinnerName, Command spinnerCommand) {
        this.spinnerName = spinnerName;
        this.spinnerCommand = spinnerCommand;
    }

    @Override
    public void hit() {
        this.hitCount++;
        spinnerCommand.execute(this);
        System.out.println("Spinner " + spinnerName + " was hit!");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void setSpinnerCommand(Command spinnerCommand) {
        this.spinnerCommand = spinnerCommand;
    }

    public String getSpinnerName() {
        return spinnerName;
    }

    public void setSpinnerName(String spinnerName) {
        this.spinnerName = spinnerName;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }
}