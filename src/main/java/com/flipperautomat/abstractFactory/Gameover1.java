package com.flipperautomat.abstractFactory;

public class Gameover1 implements Gameover{

    @Override
    public String showGameover() {
        return
                        "                                                                 \n" +
                        " ,----.                                                              \n" +
                        "'  .-./    ,--,--.,--,--,--. ,---.      ,---.,--.  ,--.,---. ,--.--. \n" +
                        "|  | .---.' ,-.  ||        || .-. :    | .-. |\\  `'  /| .-. :|  .--' \n" +
                        "'  '--'  |\\ '-'  ||  |  |  |\\   --.  ' '-' ' \\    / \\ --.|  |    \n" +
                        " `------'  `--`--'`--`--`--' `----'     `---'   `--'   `----'`--'    \n" + "";

    }
}
