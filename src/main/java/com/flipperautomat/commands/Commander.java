package com.flipperautomat.commands;

import com.flipperautomat.kompositum.Hole;
import com.flipperautomat.kompositum.PinballElement;
import com.flipperautomat.states.Nocredit;
import com.flipperautomat.Gamelogic.PinballMachine;
import com.flipperautomat.visitor.Counter;
import com.flipperautomat.visitor.Reset;

public class Commander implements Command {
    private PinballMachine pinballmachine;
    private int currentLevel = 1;
    private Reset reset;
    private Counter counter;

    public Commander(PinballMachine pinballmachine, Reset reset, Counter counter) {
        this.pinballmachine = pinballmachine;
        this.reset = reset;
        this.counter = counter;
    }

    @Override
    public void execute(PinballElement element) {
        if (element instanceof Hole) {
            handleHoleAction();
        } else {
            element.accept(counter);
            if (counter.getScore() >= 500L * currentLevel) {
                setCurrentLevel(currentLevel + 1);
                System.out.println("Dein Level: " + this.currentLevel);
            }
            pinballmachine.setScore(pinballmachine.getScore() + (currentLevel * 1000L));
            System.out.println("Dein aktueller Score: " + pinballmachine.getScore());
        }
    }

    public void handleHoleAction() {
        for (PinballElement element1 : pinballmachine.getElements()) {
            element1.accept(reset);
        }
        System.out.println("Dein Score: " + pinballmachine.getScore() + " und " + counter.getScore() + " Bonuspunkte.");
        pinballmachine.setScore(pinballmachine.getScore() + counter.getScore());
        pinballmachine.setBalls(pinballmachine.getBalls() - 1);
        if (pinballmachine.getBalls() == 1) {
            System.out.println(pinballmachine.getFactory().createBall2());
        } else if (pinballmachine.getBalls() == 0) {
            System.out.println(pinballmachine.getFactory().createBall3());
        } else if (pinballmachine.getBalls() < 0) {
            if (pinballmachine.getScore() >= 40000 && currentLevel >= 2) {
                System.out.println("GRATULIERE, DU HAST GEWONNEN!");
            } else if (pinballmachine.getScore() < 40000) {
                System.out.println(pinballmachine.getFactory().createGameover());
            }
            pinballmachine.setScore(0);
            pinballmachine.setStatus(new Nocredit());
        }
        counter.setScore(0);
        this.currentLevel = 1;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
}
