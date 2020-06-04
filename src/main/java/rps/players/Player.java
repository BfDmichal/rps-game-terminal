package rps.players;

public class Player {
    private String name;
    private int playerWins;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public void addPoint() {
        playerWins++;
    }

    public void clearPoints() {
        playerWins = 0;
    }
}
