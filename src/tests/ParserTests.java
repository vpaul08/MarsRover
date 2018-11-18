package tests;

import static org.junit.Assert.*;

import managers.CommandsParser;

import org.junit.Before;
import org.junit.Test;

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

}
