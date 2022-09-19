package dp.factory;

public class NotificationFactory {
	
	public Notification createNotification(String channel) {
		
		if (channel.equalsIgnoreCase("SMS")) {
			return new SMSNotification();
		}
		
		if (channel.equalsIgnoreCase("EMAIL")) {
			return new EmailNotification();
		}
		
		if (channel.equalsIgnoreCase("PUSH")) {
			return new PushNotification();
		}
		
		return null;
	}

}
