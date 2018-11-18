package tests;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import plateau.Coordinates;
import plateau.Plateau;

public class PlateauTests {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void plateauInvalidlyInitialized() {
		Plateau p;
		try {
			p = new Plateau(-2, 3);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertSame(e.getMessage(), "Invalid coordinates for the top right corner supplied!");
		}
	}
	
	@Test
	public void plateauValidlyInitialized() {
		Plateau p;
		try {
			p = new Plateau(2, 3);
			assertNotNull(p);
		} catch (Exception e) {
			fail("Didn't expect exception: " + e.getMessage());
		}
	}

	@Test
	public void isCoordinateWithinBounds() {	
		Plateau p;
		Coordinates c = new Coordinates(1, 1);
		try {
			p = new Plateau(2, 3);
			assertTrue(p.isWithinBounds(c));
		} catch (Exception e) {
			fail("Didn't expect exception: " + e.getMessage());
		}
	}
	
	@Test
	public void isCoordinateOutsideBounds() {	
		Plateau p;
		Coordinates c = new Coordinates(3, 3);
		try {
			p = new Plateau(2, 3);
			assertFalse(p.isWithinBounds(c));
		} catch (Exception e) {
			fail("Didn't expect exception: " + e.getMessage());
		}
	}

}
