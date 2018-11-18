package plateau;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;



public class Plateau {
	private Coordinates bottomLeft, topRight;
	
	private Plateau(int topRightX, int topRightY) throws Exception {
		bottomLeft = new Coordinates(0, 0);
		if(topRightX < bottomLeft.getX() || topRightY < bottomLeft.getY()) {
			throw new Exception("Invalid coordinates for the top right corner supplied!");
		}
		topRight = new Coordinates(topRightX, topRightY);
	}
	
	public static Plateau create(int topRightX, int topRightY) {
		Plateau p = null;
		try {
			p = new Plateau(topRightX, topRightY);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return p;
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
	
	public boolean isWithinBounds(Coordinates c) {
		if (
			c.getX() >= bottomLeft.getX() && c.getX() <= topRight.getX() &&
			c.getY() >= bottomLeft.getY() && c.getY() <= topRight.getY()
		) {
			return true;
		}			
		return false;
	}

}
