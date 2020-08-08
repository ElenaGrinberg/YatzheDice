

import java.util.ArrayList;


public class Game {


    public static void newGame(ArrayList<Player> players) {
        int numberOfPlayers = Input.inputNumberOfPlayers();
        for (int i = 1; i <= numberOfPlayers; i++) { // ���� ����
            players.add(new Player(Input.inputPlayerName(i)));
        }
    }

    public static boolean checkFinish(Player player) {
        for (int i = 1; i < 15; i++) {
            if (player.getScore(i) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkFreeContracts(Player player) {
        for (int i = 1; i < 13; i++) {
            if (player.getScore(i) == -1) {
                return true;
            }
        }
        if (player.getScore(14) == -1) {
            return true;
        }
        return false;
    }

    public static void gameRound(ArrayList<Player> players) {
        for (int currentPlayer = 0; currentPlayer < players.size(); currentPlayer++) {
            playerRound(players.get(currentPlayer));
        }
    }

    public static void findWinner(ArrayList<Player> players) {
        int currentWinner = 0;
        int currentMaxScore = 0;
        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).getScore(0) > currentMaxScore) {
                currentMaxScore = players.get(i).getScore(0);
                currentWinner = i;
            }
        }
        Output.printFinalScore(players);
        System.out.printf("The winner is %s!\n", players.get(currentWinner).getPlayerName());
    }

    static void playerRound(Player player) {
        Dice dice = new Dice(6);
        int[] currentThrow = new int[5];
        boolean[] newThrow = new boolean[5];
        System.out.println("\n\n");
        Output.printPlayerTable(player);
        for(int i = 0; i < 5; i++) {
            currentThrow[i] = dice.throwDice();
        }
        System.out.printf("%s made the first throw:\n", player.getPlayerName());
        Output.printCurrentScore(currentThrow);
        Input.inputNewThrow(newThrow);
        boolean isThrowing = false;
        for(int i = 0; i < 5; i++) {
            if(newThrow[i]) {
                currentThrow[i] = dice.throwDice();
                isThrowing = true;
            }
        }
        if (isThrowing) {
            System.out.printf("%s made the second throw:\n", player.getPlayerName());
            Output.printCurrentScore(currentThrow);
            for (int i = 0; i < 5; i++) {
                newThrow[i] = false;
            }
            Input.inputNewThrow(newThrow);
            isThrowing = false;
            for (int i = 0; i < 5; i++) {
                if (newThrow[i]) {
                    currentThrow[i] = dice.throwDice();
                    isThrowing = true;
                }
            }
        }
        if (isThrowing) {
            System.out.printf("%s made the final throw:\n", player.getPlayerName());
            Output.printCurrentScore(currentThrow);
        }
        writePlayerScore(player, currentThrow);
        player.setScore(0, 0);
        for (int i = 1; i < 15; i++) {
            if (player.getScore(i) > 0) {
                player.setScore(0, player.getScore(0) + player.getScore(i));
            }
        }
        System.out.println("Your contract is written");
        Output.printPlayerTable(player);
        System.out.println("\n");
    }

     static void writePlayerScore(Player player, int[] currentThrow) {
        int contractChoice = Const.INVALID_CONTRACT;
        while (contractChoice != Const.APPROVED_CONTRACT) {
            if (contractChoice == Const.INVALID_CONTRACT) {
                contractChoice = Input.inputContract();
            }
            if ((player.getScore(contractChoice) != -1) && (contractChoice != Const.YAHTZEE)) {
                System.out.println("This contract was filled already, chose another one");
                contractChoice = Const.INVALID_CONTRACT;
            }
            switch (contractChoice) {
                case Const.ONE:
                    contractChoice = Contract.writeContract(player,1, Contract.ones(currentThrow));
                    break;
                case Const.TWO:
                    contractChoice = Contract.writeContract(player,2, Contract.twos(currentThrow));
                    break;
                case Const.THREE:
                    contractChoice = Contract.writeContract(player,3, Contract.threes(currentThrow));
                    break;
                case Const.FORE:
                    contractChoice = Contract.writeContract(player,4, Contract.fores(currentThrow));
                    break;
                case Const.FIVE:
                    contractChoice = Contract.writeContract(player,5, Contract.fives(currentThrow));
                    break;
                case Const.SIX:
                    contractChoice = Contract.writeContract(player,6, Contract.sixes(currentThrow));
                    break;
                case Const.CHANCE:
                    contractChoice = Contract.writeContract(player,14, Contract.chance(currentThrow));
                    break;
                case Const.TWO_OF_A_KIND:
                    contractChoice = Contract.writeContract(player,7, Contract.twoOfAKind(currentThrow));
                    break;
                case Const.THREE_OF_A_KIND:
                    contractChoice = Contract.writeContract(player,8, Contract.threeOfAKind(currentThrow));
                    break;
                case Const.FORE_OF_A_KIND:
                    contractChoice = Contract.writeContract(player,9, Contract.foreOfAKind(currentThrow));
                    break;
                case Const.FULL_HOUSE:
                    contractChoice = Contract.writeContract(player,10, Contract.fullHouse(currentThrow));
                    break;
                case Const.SMALL_STRAIGHT:
                    contractChoice = Contract.writeContract(player,11, Contract.smallStraight(currentThrow));
                    break;
                case Const.LARGE_STRAIGHT:
                    contractChoice = Contract.writeContract(player,12, Contract.largeStraight(currentThrow));
                    break;
                case Const.YAHTZEE:
                    int score = Contract.yahtzee(currentThrow);
                    if (score > 0) {
                        if (player.getScore(13) == -1) {
                            player.setScore(13, score);
                        } else {
                            player.setScore(13, player.getScore(13) + score*2);
                        }
                        contractChoice = Const.APPROVED_CONTRACT;
                    } else {
                        if (checkFreeContracts(player)) {
                            System.out.println("Your combination doesn't match Yahtzee, chose another contract");
                            contractChoice = Const.INVALID_CONTRACT;
                        } else {
                            System.out.println("Yahtzee is your last free contract and you're getting 0 points there");
                            player.setScore(13, score);
                            contractChoice = Const.APPROVED_CONTRACT;
                        }
                    }
                    break;
            }
        }
     }
}
