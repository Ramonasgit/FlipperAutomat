package com.flipperautomat.abstractFactory;

public class SoftFactory implements MainFactory {

    private Ball ball1 = new Ball1();
    private Ball ball2 = new Ball2();
    private Ball ball3 = new Ball3();
    private Gameover gameover = new Gameover1();



    @Override
    public String createBall1() {
        return ball1.display();
    }

    @Override
    public String createBall2() {
        return ball2.display();
    }

    @Override
    public String createBall3() {
        return ball3.display();
    }

    @Override
    public String createGameover() {
        return gameover.showGameover();
    }
}
