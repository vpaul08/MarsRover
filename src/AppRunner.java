import static org.junit.Assert.fail;
import plateau.Coordinates;
import plateau.Plateau;
import rover.Orientation;
import rover.Rover;



public class AppRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ControlStation.getInstance().parseFile("SampleData.txt");
		try {
			Plateau plateau = new Plateau(5, 5);
			Coordinates coordinates = new Coordinates(5,5);
			Orientation orientation = new Orientation();
			Rover r = new Rover(coordinates, orientation, plateau);
			r.move();
			System.out.println(r);
			r.move();
			System.out.println(r);
			r.turnRight();
			r.move();
			System.out.println(r);
			r.turnRight();
			r.move();
			System.out.println(r);
		} catch (Exception e) {
			fail("Didn't expect exception: " + e.getMessage());
		}
		
	}

}
