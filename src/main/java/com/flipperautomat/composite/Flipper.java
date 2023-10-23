package com.flipperautomat.composite;

import com.flipperautomat.command.Command;

public class Flipper extends GameComponent {
    private String name;

    public Flipper(String name, Command command) {
        this.name = name;
        this.command = command; // Command, das ausgeführt wird, wenn die Komponente "getroffen" wird
    }

    @Override
    public void hit() {
        command.execute(); // Führen Sie das Command aus, das diesem Flipper-Element zugeordnet ist
        System.out.println("Hit the flipper: " + name);
        for (GameComponent child : children) {
            child.hit(); // Führen Sie die hit() Methode für alle Kinder dieses Flipper-Elements aus
        }
    }
}
