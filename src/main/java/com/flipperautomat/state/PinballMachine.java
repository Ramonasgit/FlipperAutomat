package com.flipperautomat.state;

public class PinballMachine {
    private State noCreditState;
    private State readyState;
    private State playingState;
    private State endState;

    private State currentState;
    private int credits = 0;
    private int balls = 3; // Bälle  zu Beginn des Spiels

    public void decrementBalls() {
        this.balls--;
    }

    public int getBalls() {
        return this.balls;
    }
    public PinballMachine() {
        noCreditState = new NoCreditState(this);
        readyState = new ReadyState(this);
        playingState = new PlayingState(this);
        endState = new EndState(this);

        currentState = noCreditState;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void pressStart() {
        currentState.pressStart();
    }

    public void play() {
        currentState.play();
    }

    public void loseBall() {
        currentState.loseBall();
    }

    public void addCredit() {
        this.credits++;
    }

    public void consumeCredit() {
        if (this.credits > 0) this.credits--;
    }

    public int getCredits() {
        return this.credits;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getNoCreditState() {
        return noCreditState;
    }

    public State getReadyState() {
        return readyState;
    }

    public State getPlayingState() {
        return playingState;
    }

    public State getEndState() {
        return endState;
    }
}