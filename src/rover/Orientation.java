package rover;

public class Orientation {
	public static final int NORTH = 1;
	public static final int EAST = 2;
	public static final int SOUTH = 3;
	public static final int WEST = 4;
	private int value;
	
	
	
	public Orientation() {
		this.value = NORTH;
	}

	public Orientation(int value) {
		this.value = value;
	}
	
	public void turnRight() {
		if (this.value == 4)
			this.value = 1; 
		else
			this.value += 1;
	}
	
	public void turnLeft() {
		if (this.value == 1)
			this.value = 4; 
		else
			this.value -= 1;
	}
	
	public int getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		switch(this.value){
			case NORTH: return "NORTH";
			case SOUTH: return "SOUTH";
			case EAST: return "EAST";
			case WEST: return "WEST";
			default: return "Invalid orientation!";
		}
	}

}
