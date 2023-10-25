package com.flipperautomat.visitor;

import com.flipperautomat.kompositum.Bumper;
import com.flipperautomat.kompositum.Flipper;
import com.flipperautomat.kompositum.Hole;
import com.flipperautomat.kompositum.Kicker;
import com.flipperautomat.kompositum.Ramp;
import com.flipperautomat.kompositum.Spinner;
import com.flipperautomat.kompositum.Target;

public class Reset implements Visitor {

    @Override
    public void visit(Bumper bumper) {
        if (bumper.isLit()) {
            bumper.setLit(false);
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
        if (kicker.isActive()) {
            kicker.setActive(false);
        }
    }

    @Override
    public void visit(Ramp ramp) {
        if (ramp.isOpened()) {
            ramp.setOpened(false);
        }
    }

    @Override
    public void visit(Spinner spinner) {
        if (spinner.getHitCount() > 0) {
            spinner.setHitCount(0);
        }
    }

    @Override
    public void visit(Target target) {
        if (target.isTargetDown()) {
            target.setTargetDown(false);
        }
    }
}
