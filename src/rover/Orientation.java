package rover;

import plateau.Coordinates;

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
		this.value = this.value == 4 ? 1 : this.value + 1;
	}

	public void turnLeft() {
		this.value = this.value == 1 ? 4 : this.value - 1;
	}

	public int getValue() {
		return this.value;
	}

	public Coordinates getCoordinatesShift() {
		Coordinates coordinates;
		switch (this.value) {
		case NORTH:
			coordinates = new Coordinates(0, 1);
			break;
		case SOUTH:
			coordinates = new Coordinates(0, -1);
			break;
		case EAST:
			coordinates = new Coordinates(1, 0);
			break;
		case WEST:
			coordinates = new Coordinates(-1, 0);
			break;
		default:
			coordinates = new Coordinates(0, 0);
			break;
		}
		return coordinates;
	}
	
	public static Orientation getOrientationFromCode(char code) {
		switch(code) {
		case 'N': return new Orientation(NORTH);
		case 'S': return new Orientation(SOUTH);
		case 'E': return new Orientation(EAST);
		case 'W': return new Orientation(WEST);
		default: return null;
		}
	}

	@Override
	public String toString() {
		switch (this.value) {
		case NORTH:
			return "NORTH";
		case SOUTH:
			return "SOUTH";
		case EAST:
			return "EAST";
		case WEST:
			return "WEST";
		default:
			return "Invalid orientation!";
		}
	}

}
