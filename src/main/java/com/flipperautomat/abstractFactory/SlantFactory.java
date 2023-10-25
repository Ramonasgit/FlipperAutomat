package com.flipperautomat.abstractFactory;

public class SlantFactory implements MainFactory {
    private Ball ball1 = new Ball12();
    private Ball ball2 = new Ball22();
    private Ball ball3 = new Ball32();
    private Gameover gameover = new Gameover2();

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
