package com.flipperautomat.state;

public class PlayingState implements State {
    private PinballMachine pinballMachine;

    public PlayingState(PinballMachine pinballMachine) {
        this.pinballMachine = pinballMachine;
    }

    @Override
    public void insertCoin() {
        pinballMachine.addCredit();
        System.out.println("Credit added. Total credits: " + pinballMachine.getCredits());
    }

    @Override
    public void pressStart() {
        System.out.println("Game is already in progress.");
    }

    @Override
    public void play() {
        System.out.println("Playing... Enjoy the game!");
    }

    @Override
    public void loseBall() {
        System.out.println("Ball lost!");
        pinballMachine.decrementBalls();

        if(pinballMachine.getBalls() > 0) {
            System.out.println("Launching next ball. Balls remaining: " + pinballMachine.getBalls());
            // Hier könnten Sie zusätzliche Logik zum Starten des nächsten Balls platzieren.
        } else {
            System.out.println("No balls remaining. Game Over!");
            pinballMachine.setState(pinballMachine.getEndState());
        }
    }
}