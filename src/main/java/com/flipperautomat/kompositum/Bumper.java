package com.flipperautomat.kompositum;

import com.flipperautomat.commands.Command;
import com.flipperautomat.visitor.Visitor;

public class Bumper implements PinballElement {
    private String bumperName;
    private boolean isLit = false;
    private Command bumperCommand;
    private int hitCount = 0;

    public Bumper(String bumperName, Command bumperCommand) {
        this.bumperName = bumperName;
        this.bumperCommand = bumperCommand;
    }

    @Override
    public void hit() {
        this.hitCount++;
        setLit(true);
        bumperCommand.execute(this);
        System.out.println("Bumper " + bumperName + " was hit!");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void setBumperCommand(Command bumperCommand) {
        this.bumperCommand = bumperCommand;
    }

    public String getBumperName() {
        return bumperName;
    }

    public void setBumperName(String bumperName) {
        this.bumperName = bumperName;
    }

    public boolean isLit() {
        return isLit;
    }

    public void setLit(boolean lit) {
        isLit = lit;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }
}
