
public class BlinkerCell extends AbstractCell  {

	int switching = 0;
	boolean life;
	public BlinkerCell(int r, int c, ConwayWorld w) {
		super(r, c, w);
	}

	@Override
	public AbstractCell cellForNextGeneration() {
		switching++;
		life = (switching%2) != 0;
		return this;
	}

	@Override
	public boolean willBeAliveInNextGeneration() {
		return life;
	}
	
	public char displayCharacter() {
		return life ? 'A' : 'D';
	}
	
	public boolean getIsAlive() {
		return life;
	}
}
