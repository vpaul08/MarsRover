package rover;

import plateau.Coordinates;
import plateau.Plateau;

public class Rover {
	private Coordinates coordinates;
	private int orientation;
	private Plateau plateau;
	
	public Rover(Coordinates coordinates, int orientation, Plateau plateau) {
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

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

}
