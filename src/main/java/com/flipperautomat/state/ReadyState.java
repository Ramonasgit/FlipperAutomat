package com.flipperautomat.state;

public class ReadyState implements State {
    private PinballMachine pinballMachine;

    public ReadyState(PinballMachine pinballMachine) {
        this.pinballMachine = pinballMachine;
    }

    @Override
    public void insertCoin() {
        // Logik für insertCoin im ReadyState
    }

    @Override
    public void pressStart() {
        // Logik für pressStart im ReadyState
    }

    @Override
    public void play() {
        // Logik für play im ReadyState
    }

    @Override
    public void loseBall() {
        // Logik für loseBall im ReadyState
    }
}