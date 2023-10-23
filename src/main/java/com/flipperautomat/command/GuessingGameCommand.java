package com.flipperautomat.command;

import java.util.Random;

public class GuessingGameCommand implements Command {

    private GameController gameController;

    public GuessingGameCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        // Spieler wählt eine Zahl zwischen 1 und 3
        int playerChoice = new Random().nextInt(3) + 1; // Zufällige Auswahl für Demonstration
        int correctNumber = 2; // Beispiel für die korrekte Zahl

        if (playerChoice == correctNumber) {
            System.out.println("Richtig geraten! Zusatzpunkte erhalten!");
            gameController.addPoints(50); // 50 Zusatzpunkte
        } else {
            System.out.println("Falsch geraten, keine Zusatzpunkte.");
        }
    }
}
