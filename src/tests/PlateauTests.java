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
		Plateau p = Plateau.create(-2, 3);
	}
	
	@Test
	public void plateauValidlyInitialized() {
		Plateau p = Plateau.create(2, 3);
	}

	@Test
	public void isCoordinateWithinBounds() {	
		Plateau p = Plateau.create(2, 3);
		Coordinates c = new Coordinates(1, 1);
		if (p != null) {
			assertTrue(p.isWithinBounds(c));
		}
	}
	
	@Test
	public void isCoordinateOutsideBounds() {	
		Plateau p = Plateau.create(2, 3);
		Coordinates c = new Coordinates(3, 3);
		if (p != null) {
			assertFalse(p.isWithinBounds(c));
		}
	}

}
