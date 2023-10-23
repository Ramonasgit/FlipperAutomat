package com.flipperautomat.state;

public class ReadyState implements State {
    private PinballMachine pinballMachine;

    public ReadyState(PinballMachine pinballMachine) {
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
            pinballMachine.consumeCredit();
            pinballMachine.setState(pinballMachine.getPlayingState());
            System.out.println("Game started. Remaining credits: " + pinballMachine.getCredits());
        } else {
            System.out.println("Not enough credits to start the game.");
        }
    }

    @Override
    public void play() {
        System.out.println("Press start to begin playing.");
    }

    @Override
    public void loseBall() {
        System.out.println("Press start to begin playing.");
    }
}
