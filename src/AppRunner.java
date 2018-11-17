import plateau.Plateau;


public class AppRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Plateau p;
		System.out.println("Welcome to the Mars Rover");
		try {
			p = new Plateau(2, 3);
			System.out.println(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
