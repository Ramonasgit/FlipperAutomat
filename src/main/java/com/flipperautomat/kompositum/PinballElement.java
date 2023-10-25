package com.flipperautomat.kompositum;

import com.flipperautomat.visitor.Visitor;
public interface PinballElement {

    void hit();
    void accept(Visitor visitor);

}
