package rps;

import rps.logic.Logic;

public class RpsRunner {
    public static void main(String[] args) {
        Logic logic = new Logic();
        logic.startGame();
    }
}
