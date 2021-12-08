/*

A number-guessing game.

*/
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Game {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("hello my gamer nerds. Please identify yourself or risk annihilation.");
    String userName = input.nextLine();
    System.out.println("Well it's about time you showed up, " + userName);
    System.out.print("Wanna play a game? All you have to do is give me a number between 1 and 100... ");
    // create an instance of the Random object
    boolean nextGame = true;
    int lowestTries = 15;
    do {
      Random rand = new Random(); // create an instance of the Random object
      int number = rand.nextInt(100) + 1; // call method nextInt and pass in upper range bound
      int count = 1;
      while (true) {
        try {
          int ans = input.nextInt();
          if (ans < 0 || ans > 100) {
            System.out.println("Please stick to the script. 1-100 only. ");
          } else {
            if (ans == number) {
              System.out.println("Damn. You are good!");
              if (count < lowestTries) {
                lowestTries = count;
              }
              System.out.println("It took you " + count + " tries this time. The high score is " + lowestTries);
              System.out.println("would you like to try again? 1 = yes, 0 = no");
              int res = input.nextInt();
              if(res == 1){
//                String answer = input.next();
                break;
              } else if(res == 0){
                nextGame = false;
                break;
              }
            } else if (ans > number) {
              System.out.println("Try again kemosabe, you're firing kinda high");
            } else {
              System.out.println("Give it some gas...try higher");
            }
          }
        } catch (InputMismatchException e) {
          String bad_input = input.next();
          System.out.println("not the right kind of guess, dude!!");
          continue;
        }
        count++;
      }
      System.out.println("You got it!");
    } while(nextGame);
  }
}
