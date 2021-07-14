package utility;



public class metodos {

	
	public static void waitSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

}
}