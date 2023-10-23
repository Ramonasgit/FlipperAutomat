package com.flipperautomat;

import com.flipperautomat.command.*;
import com.flipperautomat.composite.*;

import java.util.List;

public class FlipperAutomatApplication {
    public static void main(String[] args) {
        // 1. Initialisierung
        GameController gameController = new GameController();
        GameSetup gameSetup = new GameSetup(gameController);

        // 2. Spiel-Setup
        gameSetup.setupGame();

        // 3. Spiel starten: Hier simulieren wir einige Interaktionen
        Bumper bumper = new Bumper(new AddPointsCommand(gameController, 10));
        Hole hole = new Hole(new MacroCommand(List.of(
                new AddPointsCommand(gameController, 50),
                new GuessingGameCommand(gameController)
        )));

        System.out.println("Bumper getroffen:");
        bumper.hit(); // Simuliert, dass ein Bumper getroffen wurde

        System.out.println("\nLoch getroffen:");
        hole.hit(); // Simuliert, dass ein Loch getroffen wurde
    }
}
