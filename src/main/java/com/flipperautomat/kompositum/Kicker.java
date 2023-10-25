package com.flipperautomat.kompositum;

import com.flipperautomat.commands.Command;
import com.flipperautomat.visitor.Visitor;

public class Kicker implements PinballElement {
    private String kickerName;
    private int hitCount = 0;
    private Command kickerCommand;
    private boolean isActive = false;

    public Kicker(String kickerName, Command kickerCommand) {
        this.kickerName = kickerName;
        this.kickerCommand = kickerCommand;
    }

    @Override
    public void hit() {
        System.out.println("Kicker " + kickerName + " was hit!");
        kickerCommand.execute(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void setKickerCommand(Command kickerCommand) {
        this.kickerCommand = kickerCommand;
    }

    public String getKickerName() {
        return kickerName;
    }

    public void setKickerName(String kickerName) {
        this.kickerName = kickerName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }
}
