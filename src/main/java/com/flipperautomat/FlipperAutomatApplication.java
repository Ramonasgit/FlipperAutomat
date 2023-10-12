package com.flipperautomat;

import com.flipperautomat.composite.Bumper;
import com.flipperautomat.composite.Flipper;
import com.flipperautomat.composite.GameComponent;
import com.flipperautomat.composite.RampsGroup;
import com.flipperautomat.state.PinballMachine;


public class FlipperAutomatApplication {
    public static void main(String[] args) {
        // Komponenten für das Composite Pattern erstellen
        GameComponent mainFlipper = new Flipper("Main Flipper");
        GameComponent bumper1 = new Bumper("Left Bumper");
        GameComponent bumper2 = new Bumper("Right Bumper");

        RampsGroup rampsGroup = new RampsGroup("Ramp Group 1");
        GameComponent ramp1 = new Flipper("Ramp 1");
        GameComponent ramp2 = new Flipper("Ramp 2");
        rampsGroup.add(ramp1);
        rampsGroup.add(ramp2);

        // Zustandssteuerung durch das State Pattern
        PinballMachine pinballMachine = new PinballMachine();

        System.out.println("Initial state: No credit");
        pinballMachine.pressStart();

        System.out.println("\nInserting a coin...");
        pinballMachine.insertCoin();

        System.out.println("\nPressing start...");
        pinballMachine.pressStart();

        // Ab hier könnte das Spiel beginnen.
        // In einem echten Spiel würden Sie nun Game-Loop-Logik,
        // Kollisionsüberprüfungen etc. hinzufügen, aber für den
        // Anfang können wir den "play()" Methodenaufruf auf den
        // erstellten Komponenten machen.
        mainFlipper.play();
        bumper1.play();
        bumper2.play();
        rampsGroup.play();
    }
}