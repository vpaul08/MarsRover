package managers;

import plateau.Coordinates;
import plateau.Plateau;
import rover.Orientation;
import rover.Rover;

public class CommandsParser {
	public static Plateau getPlateau(String str) {
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
				e.getMessage();
				return null;
			}
		} else {
			return null;
		}
		Plateau p = null;
		try {
			p = new Plateau(topRightX, topRightY);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return p;
	}
	
	public static Rover getRover(String str, Plateau plateau) {
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
				e.getMessage();
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
		Rover r = new Rover(coordinates, orientation, plateau);
		return r;
	}
	
	public static boolean checkMoveInstructions(String str) {
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
