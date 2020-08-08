

public class Player {

    private final String playerName;
    private int[] score = new int[15];

    public Player(String name, int[] score) {
        this.playerName = name;
        for(int i = 0; i < 15; i++) {
            this.score[i] = score[i];
        }
    }

    public Player(String name) {
        this.playerName = name;
        for(int i = 1; i < 15; i++) {
            this.score[i] = -1;
        }
        this.score[0] = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore(int number) {
        return score[number];
    }

    public void setScore(int contract, int score) {
        this.score[contract] = score;
    }
}
