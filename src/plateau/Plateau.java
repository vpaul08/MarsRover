package plateau;

import java.util.ArrayList;

import rover.Rover;


public class Plateau {
	private Coordinates bottomLeft, topRight;
	
	public Plateau(int topRightX, int topRightY) throws Exception {
		bottomLeft = new Coordinates(0, 0);
		if(topRightX < bottomLeft.getX() || topRightY < bottomLeft.getY()) {
			throw new Exception("Invalid coordinates for the top right corner supplied!");
		}
		topRight = new Coordinates(topRightX, topRightY);
	}
	
	@Override
	public String toString() {
		int totalRows = topRight.getY() - bottomLeft.getY() + 1;
		int totalColumns = topRight.getX() - bottomLeft.getX() + 1;
		StringBuilder status = new StringBuilder();
		status.append("The plateu grid has the top right coordinates as " + topRight.getX() + ", " + topRight.getY())
		.append("\n There are a total of " + totalRows + " rows and " + totalColumns + " columns.");
		return status.toString();
	}

}
