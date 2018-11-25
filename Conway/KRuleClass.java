import java.util.Random;

public class KRuleClass extends AbstractCell {
	int value = 0;
	boolean nextGen = false;
	public KRuleClass(int r, int c, ConwayWorld w) {
		super(r, c, w);
	}

	@Override
	public AbstractCell cellForNextGeneration() {
		Random rand = new Random();
		value = (rand.nextInt(25)+1);
		return this;
	}

	@Override
	public boolean willBeAliveInNextGeneration() {
		return nextGen;
	}
	
	public char displayCharacter() {
		char val;
		
		switch(value) {
			case 11: val = 'K';
			  nextGen = false;
						break;
			case 1: val = 'A';
			   nextGen = true;
						break;
			case 19: val = 'R';
			  nextGen = false;
						break;
			case 5: val = 'E';
			   nextGen = true;
						break;
			case 12: val = 'L';
			  nextGen = false;
						break;
			case 25: val = 'Y';
			   nextGen = true;
						break;
			default: val = 'S';
			  nextGen = false;
						break;
		}
		return val;
	}
	
	public boolean getIsAlive() {
		return nextGen;
	}
}
