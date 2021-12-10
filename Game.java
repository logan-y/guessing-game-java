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
    System.out.print("Wanna guess what number I'm thinking? It's between 1 & 100... ");
    boolean nextGame = true;
    int lowestTries = 100;
    do {
      Random rand = new Random(); // create an instance of the Random object
      int number = rand.nextInt(100) + 1; // call method nextInt and pass in upper range bound
//      System.out.println("ans is " +number);
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

    //REVERSED GAME
    System.out.println("Wanna play it in reverse? I'll try to guess YOUR number...1/0?");
    int newGame = input.nextInt();
    if(newGame == 1){
      System.out.println("Ok, here are the rules. I guess. You tell me 'higher', 'lower', or 'you won' and eventually I will read your mind.");
        Random rand = new Random();
        int newGuess = rand.nextInt(100) + 1;
        int attempts = 1;
        int max = 100;
        int min = 1;
        boolean correct = false;
        System.out.println("Is " + newGuess + " your number?");
        String res = input.nextLine();
        if(res.equals("you won")){
          System.out.println("NICE");
        } else while (!correct) {
          attempts++;
          String clue = input.nextLine();
//            newGuess = rand.nextInt(100);
          switch (clue) {
            case "higher":
              min = newGuess;
              newGuess = rand.nextInt(max - min) + min;
              System.out.printf("max is %d and min is %d..", max, min);
              System.out.println("How about " + newGuess + "??");
              break;
            case "lower":
              max = newGuess;
              newGuess = rand.nextInt(max - min) + min;
              System.out.printf("max is %d and min is %d..", max, min);
              System.out.println("How about " + newGuess + "??");
              break;
            case "you won":
              System.out.println("I knew it all along I was just pretending the first " + attempts + " times.");
              correct = true;
              break;
            default:
              System.out.println("Give me a better clue, yo");
              break;
          }
          if (attempts == 9) {
            System.out.println("I should have had it by now... I give up!");
            break;
          }
        }
    } else if(newGame == 0){
      System.out.println("Thanks for playing! I hope you had fun. I sure did.");
    } else {
      System.out.println("I'll take that as a no? It's all good. See ya!");
    }






  }
}
