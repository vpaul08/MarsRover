package plateau;

public class Coordinates {
	private int x, y;

	public Coordinates() {
		this.x = 0;
		this.y = 0;
	}
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public static Coordinates sum(Coordinates c1, Coordinates c2) {
		Coordinates newCoordinates = new Coordinates(c1.getX() + c2.getX(), c1.getY() + c2.getY());
		return newCoordinates;
	}
	

	@Override
	public String toString() {
		return "Coordinates: (" + this.getX() + ", " + this.getY() + ")";		
	}

}
