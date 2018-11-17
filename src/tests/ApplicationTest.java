package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import plateau.Plateau;

public class ApplicationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void canRoverMove() {
		fail("Not yet implemented");
	}
	
	@Test
	public void canRoverBePlaced() {
		fail("Not yet implemented");
	}
	
	@Test
	public void canRunMultipleInstructions() {
		fail("Not yet implemented");
	}

	@Test
	public void plateauInvalidlyInitialized() {
		Plateau p;
		System.out.println("Welcome to the Mars Rover");
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
		System.out.println("Welcome to the Mars Rover");
		try {
			p = new Plateau(2, 3);
			assertNotNull(p);
		} catch (Exception e) {
			fail("Didn't expect exception: " + e.getMessage());
		}
	}

}
