package com.flipperautomat.commands;

import com.flipperautomat.kompositum.PinballElement;

public interface Command {

    void execute(PinballElement element);
}

