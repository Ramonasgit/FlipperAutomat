package com.flipperautomat.states;

import com.flipperautomat.Gamelogic.PinballMachine;

public abstract class Status {

    public Status() {
    }

    public void insertCoin(PinballMachine pinballMachine) {
        pinballMachine.setCredit(pinballMachine.getCredit() + 1);
        System.out.println("Münze eingeworfen! Du hast jetzt: " + pinballMachine.getCredit() + " Guthaben.");
    }

    public void startGame(PinballMachine pinballMachine) {
        if (pinballMachine.getCredit() > 0) {
            pinballMachine.setStatus(new Ready());
            System.out.println("Drücke  START, um zu beginnen!");
        } else {
            pinballMachine.setStatus(new Nocredit());
            System.out.println("Entschuldigung, es gibt kein Guthaben :(");
        }
    }
}
