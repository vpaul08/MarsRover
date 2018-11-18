package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import plateau.Coordinates;
import plateau.Plateau;
import rover.Orientation;
import rover.Rover;

public class SequentialMovesTests {
	Plateau p = null;

	@Before
	public void setUp() throws Exception {
		try {
			p = new Plateau(5, 5);
		} catch (Exception e) {
			fail("Didn't expect exception: " + e.getMessage());
		}
	}

	@Test
	public void testMove1() {		
		Coordinates c = new Coordinates(1, 2);
		Coordinates nextCoordinates;
		Orientation o = new Orientation();
		Rover r;
		
		if(p != null) {
			r = new Rover(c, o, p);
			
			r.turnLeft();	//L
			r.move();		//M
			r.turnLeft();	//L
			r.move();		//M
			r.turnLeft();	//L
			r.move();		//M
			r.turnLeft();	//L
			r.move();		//M
			r.move();		//M
			System.out.println(r);
			
			assertEquals(r.getCoordinates().getX(), 1);
			assertEquals(r.getCoordinates().getY(), 3);
			assertEquals(r.getOrientation().toString(), "NORTH");
		}		
	}
	
	@Test
	public void testMove2() {		
		Coordinates c = new Coordinates(3, 3);
		Coordinates nextCoordinates;
		Orientation o = new Orientation(Orientation.EAST);
		Rover r;		
		
		if(p != null) {
			r = new Rover(c, o, p);
			
			r.move();		//M
			r.move();		//M
			r.turnRight();	//R
			r.move();		//M
			r.move();		//M
			r.turnRight();	//R
			r.move();		//M
			r.turnRight();	//R
			r.turnRight();	//R
			r.move();		//M
			System.out.println(r);
			
			assertEquals(r.getCoordinates().getX(), 5);
			assertEquals(r.getCoordinates().getY(), 1);
			assertEquals(r.getOrientation().toString(), "EAST");
		}		
	}

}
