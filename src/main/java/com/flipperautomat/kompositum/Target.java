package com.flipperautomat.kompositum;

import com.flipperautomat.commands.Command;
import com.flipperautomat.mediator.Mediator;
import com.flipperautomat.visitor.Visitor;

public class Target implements PinballElement {
    private String targetName;
    private int hitCount = 0;
    private Command targetCommand;
    private Mediator targetMediator;
    private boolean isTargetDown = false;

    public Target(String targetName, Command targetCommand) {
        this.targetName = targetName;
        this.targetCommand = targetCommand;
    }

    @Override
    public void hit() {
        if (!isTargetDown) {
            this.hitCount++;
            setTargetDown(true);
            targetCommand.execute(this);
            targetMediator.hitTarget();
            System.out.println("Target " + targetName + " was hit!");
        } else {
            System.out.println("Target " + targetName + " is already down!");
        }
    }

    public void setTargetCommand(Command targetCommand) {
        this.targetCommand = targetCommand;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void setTargetMediator(Mediator targetMediator) {
        this.targetMediator = targetMediator;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public boolean isTargetDown() {
        return isTargetDown;
    }

    public void setTargetDown(boolean targetDown) {
        isTargetDown = targetDown;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }
}