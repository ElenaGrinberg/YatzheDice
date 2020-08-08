import java.util.Scanner;


public class Input {

    public static int inputGameSource() { // выбор новая/сохраненная игра
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("Do you want to start a new game (1) or to resume a saved one (2)? Enter you answer.");
        while (choice == 0) {
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (Exception err) {

            }
            if (choice != 1 && choice != 2) {
                System.out.println("Your choice is not correct. Enter the number 1 or 2");

                choice = 0;
            }
        }
        return choice;
    }

    public static int inputRoundChoice() { // выбор новая/сохраненная игра
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("Do you want to start a new round (1), to see the score table (2), or to save the game and exit(3)? Enter you answer.");
        while (choice == 0) {
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (Exception err) {

            }
            if (choice != 1 && choice != 2 && choice != 3) {
                System.out.println("Your choice is not correct. Enter the number 1, 2 or 3");

                choice = 0;
            }
        }
        return choice;
    }

    public static int inputNumberOfPlayers() { //количество игроков
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        System.out.println("Enter the number of players (2..4)");
        while (number == 0) {
            try {
                number = Integer.parseInt(scanner.next());
            } catch (Exception err) {
            }
            if (number < 2 || number > 4) {
                System.out.println("Your choice is not correct. Enter the number 2..4");
                number = 0;
            }
        }
        return number;
    }

    public static int inputContract() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        System.out.println("Enter the contract (1..14)");
        while (number == 0) {
            try {
                number = Integer.parseInt(scanner.next());
            } catch (Exception err) {
            }
            if (number < 1 || number > 14) {
                System.out.println("Your choice is not correct. Enter the number 1..14");
                number = 0;
            }
        }
        return number;
    }

    public static int inputContractOrApprove() {
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        System.out.println("Your combination doesn't match the chosen contract. You can write 0 points (enter 0) or change the contract (1..14):");
        while (number < 0) {
            try {
                number = Integer.parseInt(scanner.next());
            } catch (Exception err) {
            }
            if (number < 0 || number > 14) {
                System.out.println("Your choice is not correct. Enter the number 0..14");
                number = -1;
            }
        }
        return number;
    }

    public static String inputPlayerName(int playerNumber){ // имя игрока
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the Player number " + playerNumber);
        String name;
        name = scanner.next();
        return name;
    }

    public static void inputNewThrow(boolean[] newThrow) {
        int i;
        Scanner scanner = new Scanner(System.in);
        boolean gotResult = false;
        int currentDice;
        System.out.println("Enter the numbers of dices you want to re-throw (0 for keeping all results)");
        while (!gotResult) {
            String rethrowString = scanner.next();
            for(i = 0; i < rethrowString.length(); i++) {
                gotResult = true;
                try {
                    if (Integer.parseInt(rethrowString) == 0) {
                        gotResult = true;
                        break;
                    }
                    currentDice = Integer.parseInt("" + rethrowString.charAt(i));
                    if ((currentDice > 0) && (currentDice < 6)) {
                        newThrow[currentDice-1] = true;
                    } else {
                        gotResult = false;
                        break;
                    }
                } catch (Exception err) {
                    gotResult = false;
                    break;
                }
            }
            if (!gotResult) {
                System.out.println("Your choice is not valid, enter again");
            }
        }
    }

    public static boolean approveScore() {
        System.out.println("Your combination doesn't match the chosen contract. You can write 0 points (enter 0) or change the contract (1..14):");
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        while (number == 0) {
            try {
                number = Integer.parseInt(scanner.next());
            } catch (Exception err) {
            }
            if (number < 1 || number > 2) {
                System.out.println("Your choice is not correct. Enter 1 or 2.");
                number = 0;
            }
        }
        if (number == 1) {
            return true;
        } else {
            return false;
        }
    }
}
