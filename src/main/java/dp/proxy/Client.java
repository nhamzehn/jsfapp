package dp.proxy;

public class Client {

	public static void main(String[] args) {

		Internet internet = new ProxyInternet();
		try {
			internet.connectTo("https://htu.edu.jo");
			internet.connectTo("aaa.com");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
