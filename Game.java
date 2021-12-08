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
    Random rand = new Random(); // create an instance of the Random object
    int number = rand.nextInt(100) + 1; // call method nextInt and pass in upper range bound
//    System.out.println("random number is " +number);
    int count = 0;
    while (true) {
      try {
      int ans = input.nextInt();
      if (ans < 0 || ans > 100) {
        System.out.println("Please stick to the script. 1-100 only. ");
      } else {
        if (ans == number && count < 4) {
          System.out.println("Damn. You are good!");
          break;
        } else if (ans == number && count > 4) {
          System.out.println("it's about damn time!");
          break;
        } else if (ans > number) {
          System.out.println("Try again kemosabe, you're firing kinda high");
        } else {
          System.out.println("Give it some gas...try higher");
        }
      }
    } catch(InputMismatchException e){
        String bad_input = input.next();
        System.out.println("not the right kind of guess, dude!!");
        continue;
      }
      count++;
    }
    System.out.println("you took " +count+ " tries... Unbelievable.");
  }
}
