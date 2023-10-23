package com.flipperautomat.composite;


import com.flipperautomat.command.Command;

import java.util.ArrayList;
import java.util.List;

public abstract class GameComponent {
    protected List<GameComponent> children = new ArrayList<>();
    protected Command command;

    public void add(GameComponent component) {
        children.add(component);
    }

    public void remove(GameComponent component) {
        children.remove(component);
    }

    public abstract void hit();
}
