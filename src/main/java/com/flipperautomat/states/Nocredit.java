package com.flipperautomat.states;

import com.flipperautomat.Gamelogic.PinballMachine;

public class Nocredit extends Status {

    public Nocredit() {
    }

    @Override
    public void insertCoin(PinballMachine pinballmachine) {
        pinballmachine.setStatus(new Ready());
        super.insertCoin(pinballmachine);
    }

    @Override
    public void startGame(PinballMachine pinballmachine) {
        super.startGame(pinballmachine);
    }
}
