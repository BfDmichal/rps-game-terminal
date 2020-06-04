package rps.logic;

import rps.players.Computer;
import rps.players.Player;
import rps.communication.GameCommunicant;
import rps.communication.GameStats;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Logic {
    private final GameCommunicant gameCommunicant;
    private int condition;
    private final Player player;
    private final Computer computer;
    private final Scanner scanner = new Scanner(System.in);

    public Logic() {
        this.player = new Player();
        this.gameCommunicant = new GameCommunicant();
        this.computer = new Computer();
    }

    public boolean end(int condition) {
        return condition == player.getPlayerWins() || (condition == computer.getComputerWins());
    }

    public void startGame() {
        try {
            GameStats gameStats = gameCommunicant.start();
            player.setName(gameStats.getName());
            condition = gameStats.getNumbersOfRounds();
            while (!end(condition)) {
                System.out.println("set your move:");
                String playerMove = scanner.nextLine();
                playerMove = checkMove(playerMove);
                String computerMove = computer.computerMove();
                String winnerOfRound = validation(playerMove, computerMove);
                gameCommunicant.messageWin(winnerOfRound, player, computer);
            }
            finishGame();
        } catch (InputMismatchException e) {
            System.out.println("bound must be number");
            startGame();
        }
    }

    private String validation(String playerMove, String computerMove) {
        String winName;
        if (playerMove.equals("1") && computerMove.equals("2")) {
            computer.addPoint();
            winName = "computer";
        } else if (playerMove.equals("1") && computerMove.equals("3")) {
            player.addPoint();
            winName = player.getName();
        } else if (playerMove.equals("2") && computerMove.equals("1")) {
            player.addPoint();
            winName = player.getName();
        } else if (playerMove.equals("2") && computerMove.equals("3")) {
            computer.addPoint();
            winName = "computer";
        } else if (playerMove.equals("3") && computerMove.equals("1")) {
            computer.addPoint();
            winName = "computer";
        } else if (playerMove.equals("3") && computerMove.equals("2")) {
            player.addPoint();
            winName = player.getName();
        } else {
            winName = "draw";
        }
        gameCommunicant.moveInformation(playerMove, computerMove);
        return winName;
    }

    private void exitGame() {
        System.out.println("Pressed 'x' to exit game. Are you sure? set 'y'- yes or 'n'- no");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equals("y")) {
            System.exit(0);
        } else {
            clearStats();
            startGame();
        }
    }

    private void newGame() {
        System.out.println("Pressed 'n' to start new game. Are you sure? set 'y'- yes or 'n'- no");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equals("y")) {
            clearStats();
            startGame();
        } else {
            System.exit(0);
        }
    }

    private void finishGame() {
        String choice = "";
        if (player.getPlayerWins() == condition) {
            gameCommunicant.showStatistics(player.getName(), player, computer);
        } else if (computer.getComputerWins() == condition) {
            gameCommunicant.showStatistics("computer", player, computer);
        }
        choice = scanner.nextLine();
        checkPlayerChoice(choice);
    }

    private void clearStats() {
        player.clearPoints();
        computer.clearPoints();
    }

    private String checkMove(String move) {
        while (!(move.equals("1") || move.equals("2") || move.equals("3"))) {
            System.out.println("Wrong key, available keys: '1';'2';'3' set your move again: ");
            move = scanner.nextLine();
        }
        return move;
    }

    private void checkPlayerChoice(String choice) {
        if (choice.equals("x")) {
            exitGame();
        } else if (choice.equals("n")) {
            newGame();
        }
    }
}
