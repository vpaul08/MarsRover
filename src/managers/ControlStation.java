package managers;

import java.util.ArrayList;

import plateau.Plateau;
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
            synchronized(ControlStation.class) {
                if (instance == null) {
                    instance = new ControlStation();
                }
            }
        }

        return instance;
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
