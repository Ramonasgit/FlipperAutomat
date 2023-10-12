package com.flipperautomat.state;

public class EndState implements State {
    private PinballMachine pinballMachine;

    public EndState(PinballMachine pinballMachine) {
        this.pinballMachine = pinballMachine;
    }

    @Override
    public void insertCoin() {
        pinballMachine.addCredit();
        System.out.println("Credit added. Total credits: " + pinballMachine.getCredits());
    }

    @Override
    public void pressStart() {
        if(pinballMachine.getCredits() > 0) {
            System.out.println("Starting a new game...");
            // Logic to reset the game and transition to PlayingState
            pinballMachine.setState(pinballMachine.getPlayingState());
        } else {
            System.out.println("No credits available. Insert coin first.");
        }
    }

    @Override
    public void play() {
        System.out.println("Game over. Press Start to play again.");
    }

    @Override
    public void loseBall() {
        System.out.println("Game is already over.");
    }
}