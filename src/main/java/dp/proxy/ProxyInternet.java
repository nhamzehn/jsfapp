package dp.proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {

	private Internet internet = new RealInternet();
	private static List<String> unautherizedSites;

	static {
		unautherizedSites = new ArrayList<String>();
		unautherizedSites.add("aaa.com");
		unautherizedSites.add("bbb.com");
		unautherizedSites.add("ccc.com");
	}

	@Override
	public void connectTo(String serverHost) throws Exception {

		if (unautherizedSites.contains(serverHost.toLowerCase())) {
			System.out.print("Connecting to: " + serverHost);
			Thread.sleep(2000);
			throw new Exception(" --> Access Denied ");
		}

		internet.connectTo(serverHost);

	}

}
