import static java.util.Arrays.sort;

public class Contract {

    public static int writeContract(Player player, int contractNumber, int score) {
        int contractChoice;
        if (score == 0) {
            contractChoice = Input.inputContractOrApprove();
            if (contractChoice == Const.APPROVED_CONTRACT) {
                player.setScore(contractNumber, score);
            }
        } else {
            player.setScore(contractNumber, score);
            contractChoice = Const.APPROVED_CONTRACT;
        }
        return contractChoice;
    }

    public static int ones(int[] currentThrow) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (currentThrow[i] == 1) {
                score += currentThrow[i];
            }
        }
        return score;
    }

    public static int twos(int[] currentThrow) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (currentThrow[i] == 2) {
                score += currentThrow[i];
            }
        }
        return score;
    }

    public static int threes(int[] currentThrow) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (currentThrow[i] == 3) {
                score += currentThrow[i];
            }
        }
        return score;
    }

    public static int fores(int[] currentThrow) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (currentThrow[i] == 4) {
                score += currentThrow[i];
            }
        }
        return score;
    }

    public static int fives(int[] currentThrow) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (currentThrow[i] == 5) {
                score += currentThrow[i];
            }
        }
        return score;
    }

    public static int sixes(int[] currentThrow) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (currentThrow[i] == 6) {
                score += currentThrow[i];
            }
        }
        return score;
    }

    public static int chance(int[] currentThrow) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
                score += currentThrow[i];
        }
        return score;
    }

    public static int twoOfAKind(int[] currentThrow) {
        int score = 0;
        sort(currentThrow);
        for (int i = 4; i > 0; i--) {
            if (currentThrow[i] == currentThrow[i-1]) {
                score = currentThrow[i] * 2;
                break;
            }
        }
        return score;
    }

    public static int threeOfAKind(int[] currentThrow) {
        int score = 0;
        sort(currentThrow);
        for (int i = 4; i > 1; i--) {
            if ((currentThrow[i] == currentThrow[i-1]) && (currentThrow[i] == currentThrow[i-2])) {
                score = currentThrow[i] * 3;
            }
        }
        return score;
    }

    public static int foreOfAKind(int[] currentThrow) {
        int score = 0;
        sort(currentThrow);
        for (int i = 4; i > 2; i--) {
            if ((currentThrow[i] == currentThrow[i-1]) && (currentThrow[i] == currentThrow[i-2]) && (currentThrow[i] == currentThrow[i-3])) {
                score = currentThrow[i] * 4;
            }
        }
        return score;
    }

    public static int fullHouse(int[] currentThrow) {
        int score = 0;
        sort(currentThrow);
        if(((currentThrow[0] == currentThrow[1]) && (currentThrow[0] == currentThrow[2]) && (currentThrow[3] == currentThrow[4])) ||
           ((currentThrow[2] == currentThrow[3]) && (currentThrow[2] == currentThrow[4]) && (currentThrow[0] == currentThrow[1]))) {
            score = 25;
        }
        return score;
    }

    public static int smallStraight(int[] currentThrow) {
        int score = 0;
        sort(currentThrow);
        if((currentThrow[0] == 1) && (currentThrow[1] == 2) && (currentThrow[2] == 3) && (currentThrow[3] == 4) && (currentThrow[4] == 5) ) {
            score = 30;
        }
        return score;
    }

    public static int largeStraight(int[] currentThrow) {
        int score = 0;
        sort(currentThrow);
        if((currentThrow[0] == 2) && (currentThrow[1] == 3) && (currentThrow[2] == 4) && (currentThrow[3] == 5) && (currentThrow[4] == 6)) {
            score = 35;
        }
        return score;
    }

    public static int yahtzee(int[] currentThrow) {
        int score = 0;
        sort(currentThrow);
        if((currentThrow[0] == currentThrow[1]) && (currentThrow[0] == currentThrow[2]) && (currentThrow[0] == currentThrow[3])
        && (currentThrow[0] == currentThrow[4])) {
            score = 50;
        }
        return score;
    }
}
