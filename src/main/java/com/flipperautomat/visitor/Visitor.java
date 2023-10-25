package com.flipperautomat.visitor;

import com.flipperautomat.kompositum.*;

public interface Visitor {

    void visit(Bumper bumper);
    void visit(Flipper flipper);
    void visit(Hole hole);
    void visit(Kicker kicker);
    void visit(Ramp ramp);
    void visit(Spinner spinner);
    void visit(Target target);
}

