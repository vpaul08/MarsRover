package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import plateau.Coordinates;

import rover.Orientation;

public class OrientationTests {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testDefaultOrientation() {
		Orientation o = new Orientation();
		assertEquals("NORTH", o.toString());		
	}
	
	@Test
	public void testValidRightRotation() {
		Orientation o = new Orientation();
		o.turnRight();
		assertEquals("EAST", o.toString());		
	}
	
	@Test
	public void testValidLeftRotation() {
		Orientation o = new Orientation();
		o.turnLeft();
		assertEquals("WEST", o.toString());		
	}
	
	@Test
	public void testFullCircleRightRotation() {
		Orientation o = new Orientation();
		String initialOrientation = o.toString();
		o.turnRight();
		o.turnRight();
		o.turnRight();
		o.turnRight();
		String finalOrientation = o.toString();
		assertSame(initialOrientation, finalOrientation);		
	}
	
	@Test
	public void testFullCircleLeftRotation() {
		Orientation o = new Orientation();
		String initialOrientation = o.toString();
		o.turnLeft();
		o.turnLeft();
		o.turnLeft();
		o.turnLeft();
		String finalOrientation = o.toString();
		assertSame(initialOrientation, finalOrientation);		
	}
	
	@Test
	public void testCoordinatesShiftForNorth() {
		Orientation o = new Orientation(Orientation.NORTH);
		Coordinates coordinatesShift = o.getCoordinatesShift();
		assertEquals(coordinatesShift.getY(), 1);
		assertEquals(coordinatesShift.getX(), 0);
	}
	
	@Test
	public void testCoordinatesShiftForSouth() {
		Orientation o = new Orientation(Orientation.SOUTH);
		Coordinates coordinatesShift = o.getCoordinatesShift();
		assertEquals(coordinatesShift.getY(), -1);
		assertEquals(coordinatesShift.getX(), 0);
	}
	
	@Test
	public void testCoordinatesShiftForEast() {
		Orientation o = new Orientation(Orientation.EAST);
		Coordinates coordinatesShift = o.getCoordinatesShift();
		assertEquals(coordinatesShift.getY(), 0);
		assertEquals(coordinatesShift.getX(), 1);
	}

	@Test
	public void testCoordinatesShiftForWest() {
		Orientation o = new Orientation(Orientation.WEST);
		Coordinates coordinatesShift = o.getCoordinatesShift();
		assertEquals(coordinatesShift.getY(), 0);
		assertEquals(coordinatesShift.getX(), -1);
	}

}
