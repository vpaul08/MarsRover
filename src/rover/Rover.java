package rover;

import plateau.Coordinates;
import plateau.Plateau;

public class Rover {
	private Coordinates coordinates;
	private Orientation orientation;
	private Plateau plateau;
	
	public Rover(Coordinates coordinates, Orientation orientation, Plateau plateau) {
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
	

	public Coordinates getNextCoordinates() {
		return Coordinates.sum(this.coordinates, orientation.getCoordinatesShift());
	}
	
	public Coordinates move() {
		Coordinates nextCoordinates = this.getNextCoordinates();
		if(plateau.isWithinBounds(nextCoordinates))
			return nextCoordinates;
		return null;
	}

}
