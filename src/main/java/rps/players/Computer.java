package rps.players;

import java.util.Random;

public class Computer {

    private int computerWins;

    public String computerMove(){
        Random random = new Random();
        int randomInt = random.nextInt(3)+1;
        return Integer.toString(randomInt);
    }

    public int getComputerWins() {
        return computerWins;
    }
    public void addPoint(){
        computerWins++;
    }
    public void clearPoints(){
        computerWins = 0;
    }
}
