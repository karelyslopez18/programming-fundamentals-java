/***
 * @author karelyslopez
 * date: 02/20/18
 */
import java.util.ArrayList;
import java.util.Scanner;

public class HighScores {
	public static void main(String[] args) {
		int[] x = new int[5];
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> scores = new ArrayList<Integer>();
		initialize(names, scores);
		sort(names, scores);
		System.out.println("\n\n\n");
		display(names, scores);

	}

	public static void initialize(ArrayList<String> names, ArrayList<Integer> scores) {
		Scanner sc = new Scanner(System.in);
		for (int limit = 0; limit <= 4; limit++) {
			System.out.print("Enter the name for score #" + (limit + 1) + ": ");
			names.add(sc.next());
			System.out.print("Enter the score for score #" + (limit + 1) + ": ");
			scores.add(sc.nextInt());
		}
	}

	public static void sort(ArrayList<String> names, ArrayList<Integer> scores) {
		int startScan, index, maxIndex, maxValue;
		String nameValue = "";
		for (startScan = 0; startScan < (scores.size() - 1); startScan++) {
			maxIndex = startScan;
			maxValue = scores.get(startScan);
			nameValue = names.get(startScan);

			for (index = startScan + 1; index < scores.size(); index++) {
				if (scores.get(index) > maxValue) {
					maxValue = scores.get(index);
					nameValue = names.get(index);
					maxIndex = index;
				}
			}

			scores.set(maxIndex, scores.get(startScan));
			scores.set(startScan, maxValue);

			names.set(maxIndex, names.get(startScan));
			names.set(startScan, nameValue);

		}
	}

	public static void display(ArrayList<String> names, ArrayList<Integer> scores) {
		System.out.println("Top Scorers:");
		for (int y = 0; y <= scores.size() - 1; y++) {
			System.out.println(names.get(y) + ": " + scores.get(y));
		}
	}
}
