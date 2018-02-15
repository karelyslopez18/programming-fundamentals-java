/***
 * Author: Karelys Lopez Rivera
 * Date: Feb 6, 2018
 * Class: CS111B
 */
import java.util.Scanner;

public class NumberGuesser {
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
		int boundLow = 1;
		int boundHigh = 100;
		
		System.out.println("Guess a number between 1 and 100.");
		
		while(!isCorrect) {
			number = getMidpoint(boundLow, boundHigh);
			response = 	getUserResponseToGuess(number);
			
			if(response == 'h') {
				boundLow = number + 1;
			}else if(response == 'l') {
				boundHigh = number - 1;
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

	public static int getMidpoint(int low, int high) {
		return (low + high) / 2;
	}
}


