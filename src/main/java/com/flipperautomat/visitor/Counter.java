package com.flipperautomat.visitor;

import com.flipperautomat.kompositum.Bumper;
import com.flipperautomat.kompositum.Flipper;
import com.flipperautomat.kompositum.Hole;
import com.flipperautomat.kompositum.Kicker;
import com.flipperautomat.kompositum.Ramp;
import com.flipperautomat.kompositum.Spinner;
import com.flipperautomat.kompositum.Target;

public class Counter implements Visitor {

    private long score = 0;

    @Override
    public void visit(Bumper bumper) {
        if (bumper.getHitCount() >= 4) {
            score += 10000;
            System.out.println("You earned a bonus of 10,000 points!");
        }
    }

    @Override
    public void visit(Flipper flipper) {
    }

    @Override
    public void visit(Hole hole) {
    }

    @Override
    public void visit(Kicker kicker) {
        if (kicker.getHitCount() >= 3) {
            score += 1000;
            System.out.println("You earned a bonus of 1,000 points!");
        }
    }

    @Override
    public void visit(Ramp ramp) {
        if (ramp.isOpened() && ramp.getHitCount() >= 2) {
            score += 5000;
            System.out.println("You earned a bonus of 5,000 points!");
        }
    }

    @Override
    public void visit(Spinner spinner) {
        if (spinner.getHitCount() > 2) {
            score += 3000;
            System.out.println("You earned a bonus of 3,000 points!");
        }
    }

    @Override
    public void visit(Target target) {
        if (target.getHitCount() > 3) {
            score += 500;
            System.out.println("You earned a bonus of 500 points!");
        }
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}