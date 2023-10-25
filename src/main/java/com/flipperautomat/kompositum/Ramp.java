package com.flipperautomat.kompositum;

import com.flipperautomat.commands.Command;
import com.flipperautomat.visitor.Visitor;

public class Ramp implements PinballElement {
    private String rampName;
    private boolean isOpened = false;
    private int hitCount = 0;
    private Command rampCommand;

    public Ramp(String rampName, Command rampCommand) {
        this.rampName = rampName;
        this.rampCommand = rampCommand;
    }

    @Override
    public void hit() {
        if (isOpened) {
            hitCount++;
            rampCommand.execute(this);
            System.out.println("Ramp " + rampName + " was hit!");
        } else {
            System.out.println("Ramp " + rampName + " is closed!");
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void setRampCommand(Command rampCommand) {
        this.rampCommand = rampCommand;
    }

    public String getRampName() {
        return rampName;
    }

    public void setRampName(String rampName) {
        this.rampName = rampName;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }
}