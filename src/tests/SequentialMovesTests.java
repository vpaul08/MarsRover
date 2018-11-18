package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import plateau.Coordinates;
import plateau.Plateau;
import rover.Instruction;
import rover.Orientation;
import rover.Rover;

public class SequentialMovesTests {
	Plateau p = null;

	@Before
	public void setUp() throws Exception {
		p = Plateau.create(5, 5);
	}

	@Test
	public void testMove1() {		
		Coordinates c = new Coordinates(1, 2);		
		Orientation o = new Orientation();
		Rover r;
		
		if(p != null) {
			r = Rover.create(c, o, p);
			
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
			assertEquals(r.getOrientation().toString(), "N");
		}		
	}
	
	@Test
	public void testMove2() {		
		Coordinates c = new Coordinates(3, 3);		
		Orientation o = new Orientation(Orientation.EAST);
		Rover r;		
		
		if(p != null) {
			r = Rover.create(c, o, p);
			
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
			assertEquals(r.getOrientation().toString(), "E");
		}		
	}
	
	@Test
	public void testMoveInstruction1() {		
		Coordinates c = new Coordinates(1, 2);		
		Orientation o = new Orientation();
		Rover r;
		
		if(p != null) {
			r = Rover.create(c, o, p);
			
			r.handleInstruction(Instruction.L);
			r.handleInstruction(Instruction.M);
			r.handleInstruction(Instruction.L);
			r.handleInstruction(Instruction.M);
			r.handleInstruction(Instruction.L);
			r.handleInstruction(Instruction.M);
			r.handleInstruction(Instruction.L);
			r.handleInstruction(Instruction.M);
			r.handleInstruction(Instruction.M);
			System.out.println(r);
			
			assertEquals(r.getCoordinates().getX(), 1);
			assertEquals(r.getCoordinates().getY(), 3);
			assertEquals(r.getOrientation().toString(), "N");
		}		
	}
	
	@Test
	public void testMoveInstruction2() {		
		Coordinates c = new Coordinates(3, 3);
		Orientation o = new Orientation(Orientation.EAST);
		Rover r;		
		
		if(p != null) {
			r = Rover.create(c, o, p);
			
			r.handleInstruction(Instruction.M);
			r.handleInstruction(Instruction.M);
			r.handleInstruction(Instruction.R);
			r.handleInstruction(Instruction.M);
			r.handleInstruction(Instruction.M);
			r.handleInstruction(Instruction.R);
			r.handleInstruction(Instruction.M);
			r.handleInstruction(Instruction.R);
			r.handleInstruction(Instruction.R);
			r.handleInstruction(Instruction.M);
			System.out.println(r);
			
			assertEquals(r.getCoordinates().getX(), 5);
			assertEquals(r.getCoordinates().getY(), 1);
			assertEquals(r.getOrientation().toString(), "E");
		}		
	}
	
	@Test
	public void testMoveSequentialInstructions() {		
		Coordinates c = new Coordinates(3, 3);
		Orientation o = new Orientation(Orientation.EAST);
		Rover r;		
		
		if(p != null) {
			r = Rover.create(c, o, p);
			
			r.handleSequentialInstructions("MMRMMRMRRM");
			System.out.println(r);
			
			assertEquals(r.getCoordinates().getX(), 5);
			assertEquals(r.getCoordinates().getY(), 1);
			assertEquals(r.getOrientation().toString(), "E");
		}		
	}
	
	

}
