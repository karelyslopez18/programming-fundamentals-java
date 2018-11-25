import java.util.*;

public class GuessingGame {
	public static void main(String[] args) {
		try {
			NumberGuesser g = new RandomNumberGuesser(1, 100);
			char response;

			do {
				g.reset();
				System.out.println("Think of a number from 1 to 100.");

				do {
					response = promptUserAndGetResponse(g.getCurrentGuess());

					if (response == 'h')
						g.higher();
					if (response == 'l')
						g.lower();

				} while (response != 'c');

			} while (shouldPlayAgain());
		} catch (IllegalStateException e) {
			System.out.println("Sequence of h and l is untenable");
		}
	}

	/**
	 * Helper Methods
	 */

	public static char promptUserAndGetResponse(int guess) {
		char response;
		Scanner input = new Scanner(System.in);

		do {
			System.out.print("Is it " + guess + "? (h/l/c): ");
			response = input.next().charAt(0);
		} while (response != 'h' && response != 'l' && response != 'c');

		return response;
	}

	public static boolean shouldPlayAgain() {
		char response;
		Scanner input = new Scanner(System.in);

		do {
			System.out.print("Do you want to play again? (y/n): ");
			response = input.next().charAt(0);
		} while (response != 'y' && response != 'n');

		return response == 'y';
	}
}