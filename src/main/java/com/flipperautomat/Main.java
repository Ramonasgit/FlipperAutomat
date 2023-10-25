package com.flipperautomat;

import java.util.Scanner;

import com.flipperautomat.Gamelogic.Pinballgame;

public class Main {
    public static void main(String[] args) {
        Pinballgame pinballgame = new Pinballgame();
        Scanner scanner = new Scanner(System.in);
        pinballgame.play(scanner);
    }
}