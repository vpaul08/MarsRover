package rover;

import plateau.Coordinates;
import plateau.Plateau;

public class Rover {
	private Coordinates coordinates;
	private Orientation orientation;
	private Plateau plateau;

	public Rover(Coordinates coordinates, Orientation orientation,
			Plateau plateau) {
		this.coordinates = coordinates;
		this.orientation = orientation;
		this.plateau = plateau;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public void turnLeft() {
		this.orientation.turnLeft();
	}

	public void turnRight() {
		this.orientation.turnRight();
	}

	public Coordinates getNextCoordinates() {
		return Coordinates.sum(this.coordinates,
				orientation.getCoordinatesShift());
	}

	public Coordinates move() {
		Coordinates nextCoordinates = this.getNextCoordinates();
		if (plateau.isWithinBounds(nextCoordinates)) {
			this.setCoordinates(nextCoordinates);
			return nextCoordinates;
		}
		return null;
	}

	public void handleSequentialInstructions(String str) {
		for(char c : str.toCharArray()) {
		    this.handleInstruction(Instruction.valueOf(c + ""));
		}	
	}
	
	public void handleInstruction(Instruction instruction) {
		switch (instruction) {
		case R:
			this.turnRight();
			break;
		case L:
			this.turnLeft();
			break;
		case M:
			this.move();
			break;
		default: break;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("The current location of the rover is: ")
				.append(this.getCoordinates()).append(" Orientation: ")
				.append(getOrientation());
		return builder.toString();
	}

}
