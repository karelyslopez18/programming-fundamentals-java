/***
 * Author: Karelys Lopez Rivera
 * Date: Mar 6, 2018
 * Class: CS111B
 */
import java.util.Scanner;

public class GuessingProgram {
	public static void main(String[] args) {
		do {	
			playOneGame();
		} while (shouldPlayAgain());
		System.out.println("Thanks for playing!");
		System.exit(0);
	}
	
	@SuppressWarnings("resource")
	private static boolean shouldPlayAgain() {
		Scanner reader = new Scanner(System.in); 
		System.out.print("Do you want to play again? (y/n) ");
		char flag = reader.next().charAt(0);
		if(flag == 'y') {
			return true;
		}else {
			return false;
		}
	}
	
	public static void playOneGame() {
		boolean isCorrect = false; //flag it up
		char response;
		int number;
		int low = 1;
		int high = 100;
		System.out.println("Guess a number between 1 and 100.");
		RandomNumberGuesser guesser = new RandomNumberGuesser(low, high);
//		System.out.println(guesser.getCurrentGuess());
//		System.out.println(guesser.getCurrentGuess());
//		System.out.println(guesser.getCurrentGuess());
		while(!isCorrect) {
			number = guesser.getCurrentGuess();
			response = 	getUserResponseToGuess(number);
			
			if(response == 'h') {
				guesser.higher();
			}else if(response == 'l') {
				guesser.lower();
			}else if(response == 'c') {
				System.out.print("Great! ");
				isCorrect = true;
			} else {
				System.out.println("This is not a valid response.");
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static char getUserResponseToGuess(int guess) {
		System.out.print("Is it " + guess + "? (h/l/c) ");
		Scanner in = new Scanner(System.in);
		return in.next().charAt(0);
	}
}