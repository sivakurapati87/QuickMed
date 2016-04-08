package com.intuiture.qm.util;
//package com.intuiture.goat.util;
//
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//import org.apache.log4j.Logger;
//
//public class SendEmail {
//	private static Logger LOG = Logger.getLogger(SendEmail.class);
//	static Properties mailServerProperties;
//	static Session getMailSession;
//	static MimeMessage generateMailMessage;
//
//	public static void sentEmail(String mail, String pwd) {
//		try {
//			System.out.println("\n 1st ===> setup Mail Server Properties..");
//			mailServerProperties = System.getProperties();
//			mailServerProperties.put("mail.smtp.port", "587");
//			mailServerProperties.put("mail.smtp.auth", "true");
//			mailServerProperties.put("mail.smtp.starttls.enable", "true");
//			System.out
//					.println("Mail Server Properties have been setup successfully..");
//
//			// Step2
//			System.out.println("\n\n 2nd ===> get Mail Session..");
//			getMailSession = Session.getDefaultInstance(mailServerProperties,
//					null);
//			generateMailMessage = new MimeMessage(getMailSession);
//			generateMailMessage.addRecipient(Message.RecipientType.TO,
//					new InternetAddress(mail));
//			// generateMailMessage.addRecipient(Message.RecipientType.CC, new
//			// InternetAddress("test2@crunchify.com"));
//			String emailBody = null;
//			if (pwd != null) {
//				generateMailMessage.setSubject("EasyLot Recovery");
//				emailBody = "Your EasyLot Password is:" + pwd
//						+ "<br><br> Regards, <br>EasyLot Team";
//				;
//			} else {
//				generateMailMessage.setSubject("Greetings from EasyLot..");
//				emailBody = "Thanks to registered in Store2DoorGrocer.. Store2DoorGrocer is a Grocery site that brings your kitchen items in a very reasonable price at your doorstep.."
//						+ "<br><br> Regards, <br>EasyLot Team";
//			}
//			generateMailMessage.setContent(emailBody, "text/html");
//			System.out.println("Mail Session has been created successfully..");
//
//			// Step3
//			System.out.println("\n\n 3rd ===> Get Session and Send mail");
//			Transport transport = getMailSession.getTransport("smtp");
//
//			// Enter your correct gmail UserID and Password
//			// if you have 2FA enabled then provide App Specific Password
//			transport.connect("smtp.gmail.com", "mylothelpyou@gmail.com",
//					"pa55w0rd!");
//			transport.sendMessage(generateMailMessage,
//					generateMailMessage.getAllRecipients());
//			transport.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error("error at sentEmail() in SendEmail" + e.getMessage());
//		}
//	}
//
//}
