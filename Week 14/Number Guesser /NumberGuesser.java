
public class NumberGuesser {
	
	protected int high;
	protected int low;
	
	private int originalHigh;
	private int originalLow;
	
	public NumberGuesser(int l, int h) {
		low = originalLow = l;
		high = originalHigh = h;
	}
	
	public int getCurrentGuess() {
		return (high + low) / 2;
	}
	
	public void higher() {
		low = getCurrentGuess() + 1;
		isCheating();
	}
	
	public void lower() {
		high = getCurrentGuess() - 1;
		isCheating();
	}
	
	private void isCheating() throws IllegalStateException {
		if (low>high) {
			throw new IllegalStateException();
		}
	}
	
	public void reset() {
		low = originalLow;
		high = originalHigh;
	}
}