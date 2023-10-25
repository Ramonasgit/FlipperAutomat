package com.flipperautomat.mediator;

import java.util.List;

import com.flipperautomat.kompositum.PinballElement;
import com.flipperautomat.kompositum.Ramp;
import com.flipperautomat.kompositum.Target;

public class PinballMediator implements Mediator {

    private List<PinballElement> pinballElements;
    private Ramp pinballRamp;

    public PinballMediator(List<PinballElement> elements, Ramp ramp) {
        this.pinballElements = elements;
        this.pinballRamp = ramp;
    }

    @Override
    public void hitTarget() {
        boolean allTargetsDown = true;
        for (PinballElement element : pinballElements) {
            if (element instanceof Target) {
                Target target = (Target) element;
                allTargetsDown &= target.isTargetDown();
                pinballRamp.setOpened(allTargetsDown);
            }
        }
    }
}
