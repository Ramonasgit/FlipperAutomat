package com.flipperautomat.abstractFactory;

public class Ball3 implements Ball {

    @Override
    public String display() {
        return
                        "                                     \n" +
                        " ,-----.          ,--.,--.    ,----.  \n" +
                        "|  |) /_  ,--,--.|  ||  |    '.-.  | \n" +
                        "|  .-.  \\' ,-.  ||  ||  |      .' <  \n" +
                        "|  '--' /\\ '-'  ||  ||  |    /'-'  | \n" +
                        "`------'  `--`--'`--'`--'    `----'  \n" +
                        "                                     ";
    }
}
