package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import plateau.Coordinates;
import plateau.Plateau;
import rover.Orientation;
import rover.Rover;

public class RoverTests {
	Plateau p = null;

	@Before
	public void setUp() throws Exception {
		p = Plateau.create(2, 3);
	}

	@Test
	public void testNextCoordinates() {
		Coordinates c = new Coordinates(1, 1);
		Coordinates nextCoordinates;
		Orientation o = new Orientation();
		Rover r;
		
		if(p != null) {
			r = Rover.create(c, o, p);
			nextCoordinates = r.getNextCoordinates();
			assertEquals(nextCoordinates.getY(), 2);
			assertEquals(nextCoordinates.getX(), 1);
		}		
	}
	
	@Test
	public void testValidMove() {
		Coordinates c = new Coordinates(2, 2);
		Coordinates nextCoordinates;
		Orientation o = new Orientation();
		Rover r;
		
		if(p != null) {
			r = Rover.create(c, o, p);
			nextCoordinates = r.move();
			assertNotNull(nextCoordinates);
		}		
	}
	
	@Test
	public void testInvalidMove() {
		Coordinates c = new Coordinates(2, 3);
		Coordinates nextCoordinates;
		Orientation o = new Orientation();
		Rover r;
		
		if(p != null) {
			r = Rover.create(c, o, p);
			nextCoordinates = r.move();
			assertNull(nextCoordinates);
		}		
	}

}
