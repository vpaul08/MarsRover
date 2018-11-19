package managers;

import plateau.Coordinates;
import plateau.Plateau;
import rover.Orientation;
import rover.Rover;

public class CommandsParser {
	public static Plateau createPlateau(String str) {
		int topRightX, topRightY;
		if(str != null && str.length() > 0) {
			String[] plateauCoordinatesArray = str.split(" ");
			if (plateauCoordinatesArray.length != 2) {
				return null;
			}
			try {
				topRightX = Integer.parseInt(plateauCoordinatesArray[0]); 
				topRightY = Integer.parseInt(plateauCoordinatesArray[1]); 
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
		Plateau p = Plateau.create(topRightX, topRightY);
		return p;
	}
	
	public static Rover createRover(String str, Plateau plateau) {
		int x, y;
		Orientation orientation;
		if(str != null && str.length() > 0) {
			String[] roverInitializationArray = str.split(" ");
			if (roverInitializationArray.length != 3) {
				return null;
			}
			try {
				x = Integer.parseInt(roverInitializationArray[0]); 
				y = Integer.parseInt(roverInitializationArray[1]); 
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			if(roverInitializationArray[2].length() > 1) {
				return null;
			}
			if ("NESW".contains(roverInitializationArray[2])) {
				orientation = Orientation.getOrientationFromCode(roverInitializationArray[2].charAt(0));
			} else {
				return null;
			}
		} else {
			return null;
		}
		Coordinates coordinates = new Coordinates(x, y);
		Rover r = Rover.create(coordinates, orientation, plateau);
		return r;
	}
	
	public static boolean validateMoveInstructions(String str) {
		if(str != null && str.length() > 0) {
			str = str.trim();
			if (str.matches("[LRM]*")) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

}
