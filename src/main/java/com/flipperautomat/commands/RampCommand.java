package com.flipperautomat.commands;


import java.util.ArrayList;
import java.util.List;

import com.flipperautomat.kompositum.PinballElement;
import com.flipperautomat.Gamelogic.PinballMachine;

public class RampCommand implements Command {
    private PinballMachine game;
    private List<PinballElement> affectedElements;

    public RampCommand(PinballMachine game) {
        this.game = game;
        this.affectedElements = new ArrayList<>();
    }

    @Override
    public void execute(PinballElement element) {
        // Simuliere einen Treffer auf der Rampe und erhöhe die Punktzahl.
        game.setScore(game.getScore() + 10000);

        // Löse den Treffer auf den betroffenen Elementen aus.
        for (PinballElement affectedElement : this.affectedElements) {
            affectedElement.hit();
        }
    }

    public void add(PinballElement element) {
        affectedElements.add(element);
        // Füge ein Element zur Liste der betroffenen Elemente hinzu.

    }

    public void remove(PinballElement element) {
        affectedElements.remove(element);

        // Entferne ein Element aus der Liste der betroffenen Elemente.
    }

}

