package com.flipperautomat.states;

import com.flipperautomat.Gamelogic.PinballMachine;

public class Playing extends Status {

    public Playing() {
    }

    @Override
    public void insertCoin(PinballMachine pinballmachine) {
        super.insertCoin(pinballmachine);
    }

    @Override
    public void startGame(PinballMachine pinballmachine) {
        pinballmachine.setStatus(this);
        System.out.println("Autoren: Bluma Ramona und Dardagan Almasa");
    }
}
