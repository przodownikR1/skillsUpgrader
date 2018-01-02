package pl.java.scalatech.tests.web3;
public abstract class ThreadUtils {

	public static void delay(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			//TODO:
		}
	}
}