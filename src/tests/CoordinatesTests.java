package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import plateau.Coordinates;

public class CoordinatesTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSum() {
		Coordinates c1 = new Coordinates(1,1);
		Coordinates c2 = new Coordinates(-2,2);
		Coordinates sum = Coordinates.sum(c1, c2);
		assertEquals(sum.getX(), -1);
		assertEquals(sum.getY(), 3);
	}

}
