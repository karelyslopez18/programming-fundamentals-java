import java.util.Scanner;
import java.util.ArrayList;

public class PokerHands {
	public static void main(String args[]) {
		int[] ogCards = new int[5];
		Scanner read = new Scanner(System.in);
		System.out.println("Enter five numeric cards, no face cards. Use 2 - 9. ");
		for (int x = 0; x <= 4; x++) {
			System.out.print("Card " + (x + 1) + ": ");
			ogCards[x] = read.nextInt();
		}
		
		if(containsFourOfaKind(ogCards)) {
			System.out.println("Four of a kind!");
//		} else if(containsFullHouse(ogCards)) { //broken
//			System.out.println("Full house!");
		} else if(containsStraight(ogCards)) {
			System.out.println("Straight!");
		} else if(containsThreeOfaKind(ogCards)){
			System.out.println("Three of a kind!");
		} else if(containsTwoPair(ogCards)) {
			System.out.println("Two pair!");
		} else if(containsPair(ogCards)){
			System.out.println("Pair!");
		} else {
			System.out.println("High Card!");
		}
	}

	public static boolean containsPair(int hand[]) {
		int count = 0;
		for (int x = 0; x <= hand.length - 1; x++) {
			for (int y = x; y <= hand.length - 1; y++) {
				if (hand[x] == hand[y]) {
					count++;
					if (count == 2) {
						return true;
					}
				}
			}
			count = 0;
		}
		return false;
	}

	public static boolean containsTwoPair(int hand[]) {
		int count = 0;
		boolean flag = false;
		for (int x = 0; x <= hand.length - 1; x++) {
			for (int y = x; y <= hand.length - 1; y++) {
				if (hand[x] == hand[y]) {
					count++;
					if (count == 2 && !flag) {
						flag = true;
					} else if (flag && count == 2) {
						return true;
					}
				}
			}
			count = 0;
		}
		return false;
	}

	public static boolean containsThreeOfaKind(int hand[]) {
		int count = 0;
		for (int x = 0; x <= hand.length - 1; x++) {
			for (int y = x; y <= hand.length - 1; y++) {
				if (hand[x] == hand[y]) {
					count++;
					if (count == 3) {
						return true;
					}
				}
			}
			count = 0;
		}
		return false;
	}

	public static boolean containsStraight(int hand[]) {
		boolean flag = true;
		for (int x = 0; x <= hand.length - 2; x++) {
			if (hand[x] + 1 != hand[x + 1]) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static boolean containsFullHouse(int hand[]) {
		int count = 0;
		boolean flag = false;
		for (int x = 0; x <= hand.length - 1; x++) {
			for (int y = x+1; y <= hand.length - 1; y++) {
				if (hand[x] == hand[y]) {
					System.out.println(hand[x]);
					count++;
					if (count != 0 && !flag) {
						flag = true;
					} else if (flag && count != 0) {
						return true;
					}
				}
			}
			count = 0;
		}
		return false;
	}

	public static boolean containsFourOfaKind(int hand[]) {
		int count = 0;
		for (int x = 0; x <= hand.length - 1; x++) {
			for (int y = x; y <= hand.length - 1; y++) {
				if (hand[x] == hand[y]) {
					count++;
					if (count == 4) {
						return true;
					}
				}
			}
			count = 0;
		}
		return false;
	}

	public static void experimentalStructure(int hand[]) {
		Scanner read = new Scanner(System.in);
		for (int x = 0; x <= 4; x++) {
			System.out.print("Card " + (x + 1) + ": ");
			hand[x] = read.nextInt();
			int[][] cards = new int[5][2];
			for (int y = 0; y <= hand.length - 1; y++) {
				if (cards[y][0] == hand[x]) {
					cards[y][1] = cards[y][1] + 1;
					break;
				} else if (cards[y][0] == 0) {
					cards[y][0] = hand[x];
					cards[y][1] = 1;
					break;
				} else {
					// eat it
				}
			}
		}
	}

}