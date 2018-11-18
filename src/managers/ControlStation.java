package managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import plateau.Plateau;
import rover.Orientation;
import rover.Rover;

public final class ControlStation {
	private static volatile ControlStation instance = null;

	private Plateau plateau;
	private Rover rover;

	private ControlStation() { }

	public static ControlStation getInstance() {
		if (instance == null) {
			synchronized (ControlStation.class) {
				if (instance == null) {
					instance = new ControlStation();
				}
			}
		}

		return instance;
	}

	public void parseFile(String filePath) {
		try {
			File file = new File(filePath);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			int ctr = 1;
			while ((line = bufferedReader.readLine()) != null) {
				if (ctr == 1) {
					Plateau p = CommandsParser.getPlateau(line);
					if(p != null)
						this.setPlateau(p);
					else 
						break;
				} else {
					if (ctr % 2 == 0) {
						Rover r = CommandsParser.getRover(line, this.getPlateau());
						if (r != null) {
							this.setRover(r);
						} else {							
							break;						
						}
					} else {
						if (CommandsParser.checkMoveInstructions(line)) {
							this.getRover().handleSequentialInstructions(line);
							System.out.println(this.getRover());
						}
					}
				}
				ctr++;
			}
			fileReader.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public Rover getRover() {
		return rover;
	}

	public void setRover(Rover rover) {
		this.rover = rover;
	}

}
