import managers.ControlStation;



public class AppRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ControlStation.getInstance().parseFile("SampleData.txt");		
	}

}
