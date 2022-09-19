package dp.factory;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailNotification implements Notification {

	private static String USER_NAME = "username@gmail.com";
	private static String PASSWORD = "password";
	private static String RECIPIENT = "to user";

	@Override
	public void notifyUser() {

		String from = USER_NAME;
		String pass = PASSWORD;
		String[] to = { RECIPIENT };
		String subject = "Java send mail example";
		String body = "Welcome to JavaMail 2\n Upskilling Program\n JSE & JEE";

		sendFromGMail(from, pass, to, subject, body);

		System.out.println("Email sent successfully");
	}

	private static void sendFromGMail(String from, String pass, String[] to,
			String subject, String body) {

		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];

			// To get the array of addresses
			for (int i = 0; i < to.length; i++) {
				toAddress[i] = new InternetAddress(to[i]);
			}

			for (int i = 0; i < toAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}

			message.setSubject(subject);
			message.setText(body);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
	}

}