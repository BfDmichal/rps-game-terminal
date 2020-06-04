package rps.communication;

public class GameStats {
    private final String name;
    private final int numbersOfRounds;

    public GameStats(String name, int numbersOfRounds) {
        this.name = name;
        this.numbersOfRounds = numbersOfRounds;
    }

    public String getName() {
        return name;
    }

    public int getNumbersOfRounds() {
        return numbersOfRounds;
    }
}
