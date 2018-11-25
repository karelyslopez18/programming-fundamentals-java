import java.util.Random;

public class RandomNumberGuesser extends NumberGuesser{
	
	private int guess = 0;
    RandomNumberGuesser(int lowerBound, int higherBound) {
		super(lowerBound, higherBound);
    }
    
    public int getCurrentGuess() {
		Random ra = new Random();
		
		if(!getFlag()) {
			return guess;
		}
		else {			
			guess = ra.nextInt(this.getHigher()-this.getLower()) + this.getLower();
			super.setFlag(false);
			return guess;
		}
    }
    
    public void higher(){
        super.setLower(this.getCurrentGuess()+1);
        super.setFlag(true);
    }

    public void lower(){
        super.setHigher(this.getCurrentGuess()-1);
        super.setFlag(true);
    }
}