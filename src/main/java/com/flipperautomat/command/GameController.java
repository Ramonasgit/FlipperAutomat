package com.flipperautomat.command;

public class GameController {

    private int totalPoints = 0; // Gesamtpunktzahl des Spielers

    public void addPoints(int points) {
        // Logik, um Punkte hinzuzufügen
        totalPoints += points; // Punkte zur Gesamtpunktzahl hinzufügen
        System.out.println(points + " Punkte hinzugefügt. Gesamtpunktzahl: " + totalPoints);
    }

    public void startGuessingGame() {
        // Logik, um das Ratespiel zu starten
        // Wir nehmen an, dass der Spieler zwischen 1 und 100 raten muss
        int secretNumber = (int) (Math.random() * 100) + 1;
        int playerGuess = (int) (Math.random() * 100) + 1; // Hier wird zufällig geraten

        System.out.println("Geheime Zahl: " + secretNumber);
        System.out.println("Spieler hat geraten: " + playerGuess);

        if (playerGuess == secretNumber) {
            System.out.println("Glückwunsch! Du hast richtig geraten!");
            addPoints(100); // 100 Punkte hinzufügen, wenn der Spieler richtig rät
        } else {
            System.out.println("Leider falsch geraten. Versuche es erneut!");
        }
    }
}
