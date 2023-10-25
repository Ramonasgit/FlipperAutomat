package com.flipperautomat.states;

import com.flipperautomat.Gamelogic.PinballMachine;

public class Ready extends Status{

    public Ready() {
    }

    @Override
    public void insertCoin(PinballMachine pinballmachine) {
        super.insertCoin(pinballmachine);
    }

    @Override
    public void startGame(PinballMachine pinballmachine) {
        pinballmachine.setStatus(new Playing());
        if (pinballmachine.getCredit() > 0) {
            pinballmachine.setCredit(pinballmachine.getCredit() - 1);
            pinballmachine.setBalls(3);
            System.out.println("Lass uns spielen!!");
        } else {
            pinballmachine.setStatus(new Nocredit());
            System.out.println("Du hast kein Guthaben!");
        }
    }

}
