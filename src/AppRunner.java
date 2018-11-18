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
		Plateau plateau = Plateau.create(5, 5);
		Coordinates coordinates = new Coordinates(5,5);
		Orientation orientation = new Orientation();
		Rover r = Rover.create(coordinates, orientation, plateau);
		
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
		
	}

}
