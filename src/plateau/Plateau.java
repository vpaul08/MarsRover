package plateau;

import java.util.ArrayList;

import rover.Rover;


public class Plateau {
	private Coordinates bottomLeft, topRight;
	
	public Plateau(int topRightX, int topRightY) {
		bottomLeft = new Coordinates(0, 0);
		topRight = new Coordinates(topRightX, topRightY);
	}

}
