package dp.proxy;

public class RealInternet implements Internet {

	@Override
	public void connectTo(String serverHost) throws Exception {

		System.out.print("Connecting to: " + serverHost);
		Thread.sleep(2000);
		System.out.println(" --> connected");

	}

}
