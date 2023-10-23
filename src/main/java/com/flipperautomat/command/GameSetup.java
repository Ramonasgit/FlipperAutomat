package com.flipperautomat.command;

import com.flipperautomat.composite.Hole;

import java.util.List;

public class GameSetup {

    private GameController gameController;

    public GameSetup(GameController gameController) {
        this.gameController = gameController;
    }


    public void setupGame() {

        // Erstellen Sie die Befehle
        Command addPointsCommand = new AddPointsCommand(gameController, 100);
        Command guessingGameCommand = new GuessingGameCommand(gameController);

        // Erstellen Sie ein MacroCommand und fügen Sie die Befehle hinzu
        MacroCommand holeMacroCommand = new MacroCommand(List.of(
                addPointsCommand,
                guessingGameCommand
        ));

        holeMacroCommand.addCommand(addPointsCommand);
        holeMacroCommand.addCommand(guessingGameCommand);

        // Erstellen Sie ein Hole-Element und weisen Sie das MacroCommand zu
        Hole hole = new Hole(holeMacroCommand);

    }
}
