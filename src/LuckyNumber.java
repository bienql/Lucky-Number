import java.util.Scanner;
import java.lang.Math;
public class LuckyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LuckyNumber x = new LuckyNumber();
        int guesscount = x.play(); // run method and return guess count at the same time

        int gamecount = 1; //initialize variable gamecount
        int min = guesscount; //initialize variable minimum guess
        while (gamecount > 0) {
            System.out.print("Do you want to play again? ");
            String str = sc.nextLine(); //user input
            System.out.println("");

            if (str.equals("y") || str.equals("Y") || str.equals("yes") || str.equals("YES") || str.equals("Yes")) {
                int buffer = guesscount;
                guesscount = x.play();
                guesscount += buffer;

                if (guesscount < min) { //check min of guesscount
                    min = guesscount;
                }
            }
            else {
                System.out.println("Overall results:");//REPORT
                System.out.println("Total games = " + gamecount); //count games played here
                System.out.println("Total guesses = " + guesscount); // count guesses here
                System.out.println("Guesses/games = " + guesscount * 1.0 / gamecount); // average guesses over games
                System.out.println("Best game = " + min); // game with minimum guesses
                break;
            }
            gamecount++;
        }
    }
    public static int play() {
        int randomInt = (int)(Math.floor(Math.random() * 101)); //generate random integer
        System.out.println("I'm thinking of a number between 0 and 100...");
        System.out.print("Your guess? ");
        Scanner sc = new Scanner(System.in); //user input

        int count = 1;

        while (randomInt <= 100 && randomInt >= 0) {
            int a = sc.nextInt();
            if (a == randomInt) {
                System.out.println("You got it right in " + count + " guesses!");
                break;
            }
            else {
                if (a < randomInt) {
                    System.out.println("It's higher.");
                    System.out.print("Your guess? ");
                }
                else {
                    System.out.println("It's lower.");
                    System.out.print("Your guess? ");
                }
            }
            count++;
        }
        return count;
    }

}
