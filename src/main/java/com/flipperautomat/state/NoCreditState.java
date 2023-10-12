package com.flipperautomat.state;

public class NoCreditState implements State {
    private PinballMachine pinballMachine;
    public NoCreditState(PinballMachine pinballMachine) {
        this.pinballMachine = pinballMachine;
    }
    @Override
    public void insertCoin() {
        pinballMachine.addCredit();
        System.out.println("Credit added. Total credits: " + pinballMachine.getCredits());

        if(pinballMachine.getCredits() > 0) {
            pinballMachine.setState(pinballMachine.getReadyState());
        }
    }

    @Override
    public void pressStart() {
        System.out.println("No credit available. Insert coin first.");
    }

    @Override
    public void play() {
        System.out.println("Cannot play. No credits available.");
    }

    @Override
    public void loseBall() {
        System.out.println("Game is not active.");
    }
}
