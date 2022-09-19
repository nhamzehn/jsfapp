package dp.singleton;

public class Client {

	public static void main(String[] args) {

		ApplicationConfiguration config1 = ApplicationConfiguration
				.getInstance();
		ApplicationConfiguration config2 = ApplicationConfiguration
				.getInstance();

		System.out.println("Config 1: User --> " + config1.get("user"));
		System.out.println("Config 2: User --> " + config2.get("user"));
		System.out.println("Config 1: Host --> " + config2.get("host"));

		config1.update("password", "tiger#2022");
		System.out.println("Config 1: Password --> " + config1.get("password"));
		System.out.println("Config 2: Password --> " + config2.get("password"));
		
	}
}
