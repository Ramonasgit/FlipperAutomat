package com.flipperautomat.composite;


public class RampsGroup extends GameComponent {

    @Override
    public void hit() {
        for (GameComponent child : children) {
            child.hit();
        }
    }
}