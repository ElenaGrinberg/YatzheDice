
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    private static final Logger logger = LogManager.getLogger(FileManager.class);
    static final String FILE_NAME = "yatze.txt";


    public static void createNewFile(ArrayList<Player> players) {
        File file = new File(FILE_NAME);
        String playerData;
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter(FILE_NAME);
            for (int i = 0; i < players.size(); i++) {
                playerData = players.get(i).getPlayerName();
                for(int j = 0; j < 15; j++) {
                    playerData += "=" + players.get(i).getScore(j);
                }
                fileWriter.append(playerData + "\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile(ArrayList <Player> players){
        logger.info("readFromFile method runs");
        String[] parseArray;
        String row;
        String name;
        int[] score = new int[15];

        File file = new File(FILE_NAME);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            row = scanner.nextLine();
            parseArray = row.split("=");
            name = parseArray[0];
            for(int i = 0; i < 15; i++) {
                score[i] = Integer.parseInt(parseArray[i+1]);
            }
            players.add(new Player(name, score));
        }
    }
}



