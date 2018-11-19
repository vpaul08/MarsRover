package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import managers.CommandsParser;

import org.junit.Before;
import org.junit.Test;

import plateau.Plateau;
import rover.Rover;

public class ParserTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testNullMovesSequence() {
		assertTrue(CommandsParser.validateMoveInstructions(null));
	}
	
	@Test
	public void testEmptyMovesSequence() {
		assertTrue(CommandsParser.validateMoveInstructions(""));
	}
	
	@Test
	public void testSpaceOnlyMovesSequence() {
		assertTrue(CommandsParser.validateMoveInstructions(" "));
	}
	
	@Test
	public void testValidMovesSequence() {
		assertTrue(CommandsParser.validateMoveInstructions("MMMMLR"));
	}
	
	@Test
	public void testInvalidMovesSequenceExtraCharacters() {
		assertFalse(CommandsParser.validateMoveInstructions("MMMMPLR"));
	}
	
	@Test
	public void testInvalidMovesSequenceSpacesBetweenCharacters() {
		assertFalse(CommandsParser.validateMoveInstructions("MMMMP LR"));
	}
	
	@Test
	public void testGetPlateau() {
		Plateau p = CommandsParser.createPlateau("5 5");
		assertNotNull(p);
	}
	
	@Test
	public void testGetRover() {
		Plateau p = CommandsParser.createPlateau("5 5");
		Rover r = null;
		r = CommandsParser.createRover("4 3 N", p);
		assertNotNull(r);
	}
	

}
