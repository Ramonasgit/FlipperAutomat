package com.flipperautomat.kompositum;

import com.flipperautomat.visitor.Visitor;
public class Flipper implements PinballElement {
    private String flipperName;

    public Flipper(String flipperName) {
        this.flipperName = flipperName;
    }

    @Override
    public void hit() {
        System.out.println("Flipper " + flipperName + " was hit!");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getFlipperName() {
        return flipperName;
    }

    public void setFlipperName(String flipperName) {
        this.flipperName = flipperName;
    }
}