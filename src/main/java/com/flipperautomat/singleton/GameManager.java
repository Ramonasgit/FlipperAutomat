package com.flipperautomat.singleton;

public class GameManager {
    private static GameManager instance;
    private int score;

    private GameManager() {
        score = 0;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void startGame() {
        System.out.println("Game Started!");
    }

}