import managers.ControlStation;



public class AppRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length > 0) {
			ControlStation.getInstance().parseFile(args[0]);
		} else {
			System.out.println("Running from sample data.");
			ControlStation.getInstance().parseFile("SampleData1.txt");
		}	
		
	}

}
