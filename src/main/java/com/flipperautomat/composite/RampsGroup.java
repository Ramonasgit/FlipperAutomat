package com.flipperautomat.composite;

import java.util.ArrayList;
import java.util.List;

public class RampsGroup extends GameComponent {
    private List<GameComponent> components = new ArrayList<>();

    public RampsGroup(String name) {
        super(name);
    }

    public void add(GameComponent component) {
        components.add(component);
    }

    @Override
    public void play() {
        System.out.println("Playing with " + name + " that has:");
        for (GameComponent component : components) {
            component.play();
        }
    }
}