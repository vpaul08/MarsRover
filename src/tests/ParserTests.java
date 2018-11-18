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
		assertTrue(CommandsParser.checkMoveInstructions(null));
	}
	
	@Test
	public void testEmptyMovesSequence() {
		assertTrue(CommandsParser.checkMoveInstructions(""));
	}
	
	@Test
	public void testSpaceOnlyMovesSequence() {
		assertTrue(CommandsParser.checkMoveInstructions(" "));
	}
	
	@Test
	public void testValidMovesSequence() {
		assertTrue(CommandsParser.checkMoveInstructions("MMMMLR"));
	}
	
	@Test
	public void testInvalidMovesSequenceExtraCharacters() {
		assertFalse(CommandsParser.checkMoveInstructions("MMMMPLR"));
	}
	
	@Test
	public void testInvalidMovesSequenceSpacesBetweenCharacters() {
		assertFalse(CommandsParser.checkMoveInstructions("MMMMP LR"));
	}
	
	@Test
	public void testGetPlateau() {
		Plateau p = CommandsParser.getPlateau("5 5");
		assertNotNull(p);
	}
	
	@Test
	public void testGetRover() {
		Plateau p = CommandsParser.getPlateau("5 5");
		Rover r = null;
		r = CommandsParser.getRover("4 3 N", p);
		assertNotNull(r);
	}
	

}
