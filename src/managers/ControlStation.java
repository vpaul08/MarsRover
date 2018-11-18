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
	private ArrayList<Rover> rovers;

	private ControlStation() {
		rovers = new ArrayList<Rover>();
	}

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
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			System.out.println("Contents of file:");
			System.out.println(stringBuffer.toString());
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

	public void addRover(Rover rover) {
		rovers.add(rover);
	}

}
