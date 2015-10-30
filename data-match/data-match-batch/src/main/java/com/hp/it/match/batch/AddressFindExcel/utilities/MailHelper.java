package com.hp.it.match.batch.AddressFindExcel.utilities;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang.StringUtils;

public class MailHelper {

	private static final String CHARSET = "gbk";

	private static final String SMTP_HOST_NAME = "smtp3.hp.com";
	private static final String EMAIL_FROM = "noreply@hp.com";

	public static final String EMAIL_TO = "EMAIL_TO";
	public static final String EMAIL_CC = "EMAIL_CC";
	public static final String EMAIL_BCC = "EMAIL_BCC";
	public static final String EMAIL_SUBJECT = "EMAIL_SUBJECT";
	public static final String EMAIL_TEXT = "EMAIL_TEXT";
	public static final String EMAIL_ATTACHMENT = "EMAIL_ATTACHMENT";

	private static Properties props;

	/**
	 * <p>
	 * Send mail. The data should be contain the following information:
	 * </p>
	 * 
	 * <li>the mail address: data.put(MailHelper.EMAIL_TO, "");</li> 
	 * <li>the mail cc address(optional): data.put(MailHelper.EMAIL_CC, "");</li> 
	 * <li>the mail bcc address(optional): data.put(MailHelper.EMAIL_BCC, "");</li>
	 * <li>the mail subject: data.put(MailHelper.EMAIL_SUBJECT, "");</li> 
	 * <li>the mail content: data.put(MailHelper.EMAIL_TEXT, "");</li> 
	 * <li>the mail attachment(optional): data.put(MailHelper.EMAIL_ATTACHMENT, "");</li>
	 * 
	 * <p>
	 * <br>
	 * For multiple emails, the delimiter is comma, the format is:<br>
	 * String mailList = "tom@hp.com,bob@hp.com";<br>
	 * </p>
	 * 
	 * @param data
	 *            the data need to be send.
	 * 
	 * @return flag that the mail sending success or not
	 * @throws Exception
	 */
	public static boolean sendEmail(Map<String, String> data) throws Exception {
		initProperties(false);

		if (data.get(EMAIL_TO) == null || data.get(EMAIL_SUBJECT) == null || data.get(EMAIL_TEXT) == null) {
			throw new Exception("Error occured while sending mail: mail information is not complete.");
		}

		Session session = Session.getDefaultInstance(props, null);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(EMAIL_FROM));
			message.addRecipients(Message.RecipientType.TO, getAddress(data.get(EMAIL_TO)));
			if (StringUtils.isNotEmpty(data.get(EMAIL_CC))) {
				message.addRecipients(Message.RecipientType.CC, getAddress(data.get(EMAIL_CC)));
			}
			if (StringUtils.isNotEmpty(data.get(EMAIL_BCC))) {
				message.addRecipients(Message.RecipientType.BCC, getAddress(data.get(EMAIL_BCC)));
			}
			message.setSentDate(new Date());
			message.setSubject(encodeText(data.get(EMAIL_SUBJECT)));

			MimeMultipart mmp = new MimeMultipart();
			MimeBodyPart mbpText = new MimeBodyPart();
			mbpText.setContent(data.get(EMAIL_TEXT), "text/html;charset=utf-8");
			mmp.addBodyPart(mbpText);

			if (data.get(EMAIL_ATTACHMENT) != null) {
				setAttachment(data.get(EMAIL_ATTACHMENT), mmp);
			}
			message.setContent(mmp);

			Transport.send(message);
			return true;
		} catch (Exception e) {
			throw new Exception("Error occured while sending mail. ", e);
		}
	}

	private static void initProperties(boolean authenticate) {
		props = System.getProperties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", authenticate);
		props.put("mail.mime.address.strict", false);
	}

	private static String encodeText(String text) throws UnsupportedEncodingException {
		if (text == null) {
			return null;
		}
		return MimeUtility.encodeText(text, CHARSET, "B");
	}

	private static Address[] getAddress(String mailList) throws AddressException {
		String[] mails = mailList.split(",");
		Address[] addresses = new Address[mails.length];
		for (int i = 0; i < mails.length; i++) {
			addresses[i] = new InternetAddress(mails[i]);
		}
		return addresses;
	}

	private static void setAttachment(String attachment, MimeMultipart mmp) throws MessagingException, UnsupportedEncodingException {
		String[] files = attachment.split(",");
		if (files.length != 0) {
			for (String file : files) {
				MimeBodyPart mbpFile = new MimeBodyPart();
				FileDataSource fds = new FileDataSource(file);
				mbpFile.setDataHandler(new DataHandler(fds));
				mbpFile.setFileName(encodeText(fds.getName()));
				mmp.addBodyPart(mbpFile);
			}
		}
	}

}
