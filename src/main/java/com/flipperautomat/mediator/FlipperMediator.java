package com.flipperautomat.mediator;

import com.flipperautomat.composite.GameComponent;

import java.util.ArrayList;
import java.util.List;

public class FlipperMediator {

    private final List<GameComponent> targets = new ArrayList<>();
    private final GameComponent ramp;

    public FlipperMediator(GameComponent ramp) {
        this.ramp = ramp;
    }

    public void addTarget(GameComponent target) {
        targets.add(target);
    }

    public void targetHit(GameComponent target) {
        targets.remove(target);

        if (targets.isEmpty()) {
            rampOpen();
            resetTargets();
        }
    }

    private void rampOpen() {
        System.out.println("Ramp is now open!");
        ramp.hit();
    }

    private void resetTargets() {
        System.out.println("Resetting all targets...");
        // Logic to reset all targets
    }
}
