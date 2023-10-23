package com.flipperautomat.command;

public class AddPointsCommand implements Command {

    private GameController gameController;
    private int points;


    public AddPointsCommand(GameController gameController, int points) {
        this.gameController = gameController;
        this.points = points;
    }

    @Override
    public void execute() {
        // Hier fügen wir die Punkte zum Spieler hinzu.
        // Zum Beispiel:
        gameController.addPoints(points);
    }
}