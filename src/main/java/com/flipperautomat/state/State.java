package com.flipperautomat.state;

public interface State {
    void insertCoin();
    void pressStart();
    void play();
    void loseBall();
}
