import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class YatzheMain {
    private static final int NEW_GAME = 1;
    private static final int SAVED_GAME = 2;
    private static final int NEW_ROUND = 1;
    private static final int SEE_TABLE = 2;
    private static final int SAVE_AND_EXIT = 3;
    private static final int FINISH = 4;

    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        int gameSource = Input.inputGameSource();
        switch (gameSource) {
            case NEW_GAME:
                Game.newGame(players);
                break;

            case SAVED_GAME:
                FileManager.readFromFile(players);
                Output.printTable(players);
                break;
        }
        int roundChoice = NEW_ROUND;
        while ((roundChoice != SAVE_AND_EXIT) && (roundChoice != FINISH)) {
            roundChoice = Input.inputRoundChoice();
            switch (roundChoice) {
                case NEW_ROUND:
                    Game.gameRound(players);
                    if (Game.checkFinish(players.get(0))) {
                        roundChoice = FINISH;
                    }
                    break;
                case SEE_TABLE:
                    Output.printTable(players);
                    break;
                case SAVE_AND_EXIT:
                    FileManager.createNewFile(players);
                    break;
            }
        }
        if (roundChoice == FINISH) {
            Game.findWinner(players);
        }
    }
}
