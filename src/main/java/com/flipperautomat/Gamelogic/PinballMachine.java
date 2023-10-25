package com.flipperautomat.Gamelogic;

import java.util.List;

import com.flipperautomat.abstractFactory.MainFactory;
import com.flipperautomat.kompositum.PinballElement;
import com.flipperautomat.states.Nocredit;
import com.flipperautomat.states.Status;

public class PinballMachine {

    private static PinballMachine pinballmachine = new PinballMachine(new Nocredit());
    private Status status;
    private int credit = 0;
    private int balls = 0;
    private MainFactory factory;
    private List<PinballElement> elements;
    private long score = 0;

    public PinballMachine(Status status) {
        this.status = status;
    }

    public static PinballMachine getPinball() { return pinballmachine;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public MainFactory getFactory() {
        return factory;
    }

    public void setFactory(MainFactory factory) {
        this.factory = factory;
    }

    public List<PinballElement> getElements() {
        return elements;
    }

    public void setElements(List<PinballElement> elements) {
        this.elements = elements;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}

