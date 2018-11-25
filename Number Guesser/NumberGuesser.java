/***
 * Author: Karelys Lopez Rivera
 * Date: Mar 6, 2018
 * Class: CS111B
 */
public class NumberGuesser {
	private int lower;
	private int higher;
	private int lowerOg;
	private int higherOg;
	private boolean flag;

	NumberGuesser(int lowerBound, int higherBound) {
		this.lower = this.lowerOg = lowerBound;
		this.higher = this.higherOg = higherBound;
		this.flag = true;
	}

	public int getCurrentGuess() {
		return ((this.lower + this.higher) / 2);
	}

	public String getLowerAndHigher() {
		return (this.lower + "," + this.higher);

	}

	public void higher() {
		this.lower = getCurrentGuess() + 1;
	}

	public void lower() {
		this.higher = getCurrentGuess() - 1;
	}

	public int getLower(){
		return this.lower;
	}

	public void setLower(int value){
		this.lower = value;
	}

	public void setHigher(int value){
		this.higher = value;
	}
	public int getHigher(){
		return this.higher;
	}
	
	public void setFlag(boolean value) {
		this.flag = value;
	}
	
	public boolean getFlag() {
		return this.flag;
	}
	
	public void reset() {
		this.lower = this.lowerOg;
		this.higher = this.higherOg;
	}
}	

