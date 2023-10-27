package com.flipperautomat.Gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.flipperautomat.abstractFactory.Ball1;
import com.flipperautomat.abstractFactory.Ball12;
import com.flipperautomat.abstractFactory.SlantFactory;
import com.flipperautomat.abstractFactory.SoftFactory;
import com.flipperautomat.commands.Command;
import com.flipperautomat.commands.Commander;
import com.flipperautomat.commands.RampCommand;
import com.flipperautomat.kompositum.Bumper;
import com.flipperautomat.kompositum.Flipper;
import com.flipperautomat.kompositum.Hole;
import com.flipperautomat.kompositum.Kicker;
import com.flipperautomat.kompositum.PinballElement;
import com.flipperautomat.kompositum.Ramp;
import com.flipperautomat.kompositum.Spinner;
import com.flipperautomat.kompositum.Target;
import com.flipperautomat.mediator.Mediator;
import com.flipperautomat.mediator.PinballMediator;
import com.flipperautomat.states.Status;
import com.flipperautomat.visitor.Counter;
import com.flipperautomat.visitor.Reset;

public class Pinballgame {

    private PinballMachine pinballMachine = PinballMachine.getPinball();

    private List<PinballElement> elements = new ArrayList<>();

    private Random random = new Random();

    Reset resetVisitor = new Reset();
    Counter counterVisitor = new Counter();
    Commander spinnerCommand1 = new Commander(pinballMachine, resetVisitor, counterVisitor);
    Commander spinnerCommand2 = new Commander(pinballMachine, resetVisitor, counterVisitor);
    Commander spinnerCommand3 = new Commander(pinballMachine, resetVisitor, counterVisitor);

    Spinner spinner1 = new Spinner("SPINNER 1", spinnerCommand1);
    Spinner spinner2 = new Spinner("SPINNER 2", spinnerCommand2);
    Spinner spinner3 = new Spinner("SPINNER 3", spinnerCommand3);

    RampCommand rampCommand = new RampCommand(pinballMachine);

    Commander commander = new Commander(pinballMachine, resetVisitor, counterVisitor);
    List<Command> commandList = new ArrayList<>();

    Ramp ramp = new Ramp("THE RAMP", rampCommand);
    Hole hole = new Hole("THE HOLE", commander);
    Flipper rightFlipper = new Flipper("THE RIGHT FLIPPER");
    Flipper leftFlipper = new Flipper("THE LEFT FLIPPER");
    Kicker kicker1 = new Kicker("KICKER 1", commander);
    Kicker kicker2 = new Kicker("KICKER 2", commander);

    List<Bumper> bumpers = new ArrayList<>();
    Bumper bumper1 = new Bumper("BUMPER 1", commander);
    Bumper bumper2 = new Bumper("BUMPER 2", commander);
    Bumper bumper3 = new Bumper("BUMPER 3", commander);
    Bumper bumper4 = new Bumper("BUMPER 4", commander);

    List<Target> targets = new ArrayList<>();
    Target target1 = new Target("BUMPER 1", commander);
    Target target2 = new Target("BUMPER 2", commander);
    Target target3 = new Target("BUMPER 3", commander);
    Target target4 = new Target("BUMPER 4", commander);

    Mediator mediator = new PinballMediator(elements, ramp);

    public Pinballgame() {
    }

    public Status getStatus() {
        return pinballMachine.getStatus();
    }

    public void setPinballElements() {

        commandList.add(spinnerCommand1);
        commandList.add(spinnerCommand2);
        commandList.add(spinnerCommand3);
        rampCommand.add(spinner1);
        rampCommand.add(spinner2);
        rampCommand.add(spinner3);

        elements.add(hole);
        elements.add(rightFlipper);
        elements.add(leftFlipper);
        elements.add(kicker1);
        elements.add(kicker2);
        elements.add(ramp);
        bumpers.add(bumper1);
        bumpers.add(bumper2);
        bumpers.add(bumper3);
        bumpers.add(bumper4);
        elements.addAll(bumpers);
        targets.add(target1);
        targets.add(target2);
        targets.add(target3);
        targets.add(target4);
        elements.addAll(targets);
        // Hier wird targetMediator initialisiert und den Target-Objekten zugewiesen
        Mediator mediator = new PinballMediator(elements, ramp);
        for (Target target : targets) {
            target.setTargetMediator(mediator);
        }

        pinballMachine.setElements(elements);
    }

    public void play(Scanner scanner) {
        setPinballElements();
        styleChoice(scanner);
        getNoCreditAndReadyChoices(scanner);
    }

    public void styleChoice(Scanner scanner) {
        System.out.println("Such dir deinen persönlichen Stil aus:");
        System.out.println("Wahl 1:");
        System.out.println(new Ball1().display());
        System.out.println("********************************************** ODER **********************************************");
        System.out.println("Wahl 2:");
        System.out.println(new Ball12().display());
        boolean unavailableChoice = true;
        while (unavailableChoice) {
            System.out.print("\n Deine Wahl ist:\n");
            int factoryChoice = scanner.nextInt();
            if (factoryChoice == 1) {
                pinballMachine.setFactory(new SoftFactory());
                unavailableChoice = false;
            } else if (factoryChoice == 2) {
                pinballMachine.setFactory(new SlantFactory());
                unavailableChoice = false;
            } else {
                System.out.println("Bitte wähle zwischen 1 oder 2.");
                unavailableChoice = true;
            }
    }
}

    public void getNoCreditAndReadyChoices(Scanner scanner) {
        boolean unavailableChoice = true;
        while (unavailableChoice) {
            System.out.println("Token hinzufügen drücke -1-, Spiel starten drücke -2- oder Spiel beenden drücke  -3- .\n");
            System.out.println("Dein Guthaben beträgt: " + pinballMachine.getCredit());
            int noCreditChoice = scanner.nextInt();
            if (noCreditChoice == 1) {
                pinballMachine.getStatus().insertCoin(pinballMachine);
                unavailableChoice = true;
            } else if (noCreditChoice == 2) {
                pinballMachine.getStatus().startGame(pinballMachine);
                if (pinballMachine.getBalls() > 0) {
                    elementGotHit(scanner);
                }
            } else if (noCreditChoice == 3) {
                unavailableChoice = false;
            } else {
                System.out.println("Bitte wähle zwischen 1, 2 oder 3!");
                unavailableChoice = true;
            }
        }
    }

    public void beforeFlipper(Scanner scanner) {
        if (pinballMachine.getBalls() >= 0) {
            boolean notFlipper = true;
            while (notFlipper) {
                System.out.println("Flipper betätigen drücke -1-, Spiel starten drücke -2- oder Coin hinzufügen drücke -3- .\n");
                int beforeFlipperChoice = scanner.nextInt();
                if (beforeFlipperChoice == 1) {
                    notFlipper = false;
                } else if (beforeFlipperChoice == 2) {
                    pinballMachine.getStatus().startGame(pinballMachine);
                } else if (beforeFlipperChoice == 3) {
                    pinballMachine.getStatus().insertCoin(pinballMachine);
                }
            }
            useFlipper(scanner);
        } else {
            getNoCreditAndReadyChoices(scanner);
        }
    }

    public void useFlipper(Scanner scanner) {
        boolean isFlipperOrHole = true;
        while (isFlipperOrHole) {
            int option = random.nextInt(14);
            if (!(elements.get(option) instanceof Hole) && !(elements.get(option) instanceof Flipper)) {
                isFlipperOrHole = false;
                elementGotHit(scanner);
            }
        }
    }

    public void elementGotHit(Scanner scanner) {
        if (pinballMachine.getBalls() == 3) {
            System.out.println(pinballMachine.getFactory().createBall1());
            pinballMachine.setBalls(2);
        }
        if (pinballMachine.getBalls() >= 0) {
            boolean isNotFlipper = true;
            while (isNotFlipper) {
                int option = random.nextInt(14);
                elements.get(option).hit();
                if (elements.get(option) instanceof Flipper) {
                    isNotFlipper = false;
                }
                if (elements.get(option) instanceof Hole && pinballMachine.getBalls() < 0) {
                    isNotFlipper = false;
                }
            }
            beforeFlipper(scanner);
        } else {
            getNoCreditAndReadyChoices(scanner);
        }
    }
}



