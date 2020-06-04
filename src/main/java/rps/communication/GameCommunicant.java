package rps.communication;

import rps.players.Computer;
import rps.players.Player;

import java.util.Scanner;

public class GameCommunicant {

    public GameStats start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("set your name:");
        String name = scanner.nextLine();
        System.out.println("set max win bound");
        int condition = scanner.nextInt();
        System.out.println("Information about game: " + "\nkey '1' = rock");
        System.out.println("key '2' = paper");
        System.out.println("key '3' = scissors");
        System.out.println("press 'x' to exit game");
        System.out.println("press 'n' to start new game");
        return new GameStats(name, condition);
    }

    public void messageWin(String name, Player player, Computer computer) {
        if (!name.equals("draw")) {
            System.out.println(name + " has won this round, game stats: you = " + player.getPlayerWins() + " computer = " + computer.getComputerWins());
        } else {
            System.out.println("draw");
        }
    }

    public void showStatistics(String winner, Player player, Computer computer) {
        System.out.println("Winner is " + winner);
        System.out.println("Stats of game:\n" + player.getName() + " points: \n" + player.getPlayerWins() + "\ncomputer points:\n" + computer.getComputerWins());
        System.out.println("Press 'x' if you want to exit game or 'n' to start new game");
    }

    public void moveInformation(String playerMove, String computerMove) {
        System.out.println("you choose: " + numberTranslator(playerMove));
        System.out.println("computer choose: " + numberTranslator(computerMove));
    }

    private String numberTranslator(String move) {
        if (move.equals("1")) {
            return "rock";
        } else if (move.equals("2")) {
            return "paper";
        } else {
            return "scissors";
        }
    }
}
