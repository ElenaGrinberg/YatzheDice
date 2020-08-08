import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;

public class Output {
    private static final Logger logger = LogManager.getLogger(Output.class);

    public static void printTable(ArrayList<Player> players) {
        String line = "                  ";
        int i;
        System.out.println("The current score is:");

        for(i = 0; i<players.size(); i++) {
            line += players.get(i).getPlayerName() +"\t";
        }
        System.out.println(line);
        for (i = 1; i < 15; i++) {
            line = Const.contracts[i] + "\t";
            for (int j = 0; j < players.size(); j++) {
                if(players.get(j).getScore(i) >= 0) {
                    line += "\t" + players.get(j).getScore(i);
                } else {
                    line += "\t" + "__";
                }
            }
            System.out.println(line);
        }
        line = "General        " + "\t";
        for (int j = 0; j < players.size(); j++) {
            line += "\t" + players.get(j).getScore(0);
        }
        System.out.println(line);

    }

    public static void printPlayerTable(Player player) {
        int i;
        String line;
        System.out.printf("%s's current score is:\n", player.getPlayerName());
        for (i = 1; i < 15; i++) {
            line = String.format("(%d)  ", i);
            line += Const.contracts[i] + "\t";
            if(player.getScore(i) >= 0) {
                line += "\t" + player.getScore(i);
            } else {
                line += "\t" + "__";
            }
            if (player.getScore(i) == -1) {
                line += "\t" + Const.contractScore[i];
            }
            System.out.println(line);
        }
        line = "      General         " + "\t";
        line += "\t" + player.getScore(0);
        System.out.println(line);
        System.out.println();

    }

    public static void printCurrentScore(int[] score) {
        System.out.println("1st dice    2nd dice    3rd dice    4th dice    5th dice");
        System.out.printf("   ");
        for (int i = 0; i < 5; i++) {
            System.out.printf(score[i] + "           ");
        }
        System.out.println();
    }

    public static void printFinalScore(ArrayList<Player> players) {
        System.out.println("Final score:");
        for (int i = 0; i < players.size(); i++) {
            System.out.printf("%s got %d points \n", players.get(i).getPlayerName(), players.get(i).getScore(0));
        }
    }
}
