import java.util.Scanner;

// ******************************************************
// ** Akshay U Gaikwad**
// ** Program: GuessingNumberGame**
// ******************************************************
public class GuessingNumberGame {

    static int low = 1, high = 100;
    static int numberOfTurnsLeft = 5;

    public static void main(String[] args) {
        gameBegins();
    }

    public static void gameBegins() {
        int secretNumber = 0;

        double i = Math.random();
        if (i != 0)
            secretNumber = (int) (i * 101);
        else {
            gameBegins();
            System.out.println("Please Enter a Valid Number");
        }
        System.out.println("");
        System.out.println("**********");
        System.out.println(" NEW GAME  ");
        System.out.println("**********");
        System.out.println("");
        System.out.println("");
        System.out.println("Guess a number between 1-100!  You will get 5 turns.");
        System.out.println("Best Of Luck.....!");

        while (true) {
            int inputNumber = playerInput();
            predictionResult(inputNumber, secretNumber);
        }
    }

    public static int playerInput() {
        Scanner in = new Scanner(System.in);
        int playerInput = in.nextInt();
        System.out.println("Player guesses " + playerInput);
        return playerInput;
    }

    public static void predictionResult(int inputNumber, int secretNumber) {
        
        if (inputNumber < secretNumber) {
            low = inputNumber;
            System.out.println("Sorry, that is too LOW number ");
            low = low + 1;
            numberOfTurnsLeft = numberOfTurnsLeft - 1;
            if (numberOfTurnsLeft == 0) {
                System.out.println("YOU LOSE! The SECRET number was " + secretNumber);
                playAgain();
            }
            System.out.println(
                    "Guess a number between " + low + "-" + high + " and your turns left " + numberOfTurnsLeft);
        }
        
        else if (inputNumber > secretNumber) {
            high = inputNumber;
            System.out.println("Sorry, that is too HIGH number ");
            high = high - 1;
            numberOfTurnsLeft = numberOfTurnsLeft - 1;
            if (numberOfTurnsLeft == 0) {
                System.out.println("YOU LOSE! The SECRET number was " + secretNumber);
                playAgain();
            }
            System.out.println(
                    "Guess a number between " + low + "-" + high + " and your turns left " + numberOfTurnsLeft);
        } else {
            System.out.println("Congratulations...!");
            System.out.println("YOU WIN THE GAME! The SECRET number was " + secretNumber);
            System.out.println("Your score is " + ((numberOfTurnsLeft) * 10) + " out of 100");
            playAgain();
        }
    }

    public static void playAgain() {
        low = 1;
        high = 100;
        numberOfTurnsLeft = 5;
        gameBegins();

    }

}
