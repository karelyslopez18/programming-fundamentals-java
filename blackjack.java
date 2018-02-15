/**
 * @author karelyslopez
 *
 */
import java.util.Scanner;
import java.util.Random;
public class blackjack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		Random rand = new Random(); //new object creation
		
		blackjack bjack = new blackjack();
		char askuser2 = 'y';
		Scanner input= new Scanner(System.in);
		while (askuser2 != 'n') {
			char askuser = 'y';
			int randvalue = rand.nextInt(9)+1;
			int startingcards = rand.nextInt(9)+1;
			int total = randvalue+startingcards ;
			System.out.println("First cards: "+randvalue+", "+startingcards);
			System.out.println("Total: "+ total);
			while (askuser != 'n') {
				if (!bjack.isBust(total) && !bjack.isWin(total)) {
					System.out.println("Do you wamt another card? (y/n): ");
					askuser = input.next().charAt(0);
					if (askuser != 'n') {
						int card = rand.nextInt(9)+1;
						total+=card;
						System.out.println("Card: "+card);
						System.out.println("Total: "+total);
					}
				} else if (bjack.isBust(total)) {
					System.out.println("Bust.");
					break;
				} else if (bjack.isWin(total)) {
					System.out.println("Win.");
					break;
				} else {
					// eat it
				}
			} //loop end
			System.out.println("Would you like to play again? (y/n): ");
			askuser2 = input.next().charAt(0);
		}
	}
	
	
	public boolean isWin(int value) {
		if (value==21) {
			return true;	
		}else {
			return false;
		}
	}
	
	public boolean isBust(int value) {
		if (value>21) {
			return true;
		}else {
			return false;
		}
	}
}
