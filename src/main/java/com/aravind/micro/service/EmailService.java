package com.aravind.micro.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.aravind.micro.model.Applicant;
import com.aravind.micro.model.Premium;
import com.aravind.micro.repository.ApplicantRepo;
import com.aravind.micro.repository.PremiumRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private ApplicantRepo applicantRepo;

	@Autowired
	private PremiumRepo premiumRepo;

	@Value("${spring.mail.username}")
	private String sender;

	public void sendEmail(String to, String subject, String text) throws MessagingException, IOException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setFrom(sender);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(text, true); // Set true to enable HTML content

		javaMailSender.send(mimeMessage);
		System.out.println("Mail sent");
	}

	public void sendEmail(int applicantId, String status) throws MessagingException, IOException {
		Applicant applicant = applicantRepo.findById(applicantId);
		Premium premium = premiumRepo.getPremiumByApplicantId(applicantId);

		if (applicant != null) {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

			helper.setFrom(sender);
			helper.setTo(applicant.getEmail());
			helper.setSubject("Insurance Application " + status);

			if ("Approved".equalsIgnoreCase(status) && premium != null) {
				helper.setText("Dear " + applicant.getApplicantName() + ",\r\n" + "\r\n"
						+ "Your insurance application has been approved. Please find the premium details below:\r\n"
						+ "\r\n" + "Total Amount: " + premium.getTotalAmount() + "\r\n" + "Monthly: "
						+ premium.getMonthly() + "\r\n" + "Quarterly: " + premium.getQuartely() + "\r\n"
						+ "Half-Yearly: " + premium.getHalfly() + "\r\n" + "Yearly: " + premium.getYearly() + "\r\n"
						+ "\r\n"
						+ "Kindly check your dashboard for more information. If you are interested, please acknowledge us.\r\n"
						+ "\r\nThank you!");
			} else if ("Rejected".equalsIgnoreCase(status)) {
				helper.setText("Dear " + applicant.getApplicantName() + ",\r\n" + "\r\n"
						+ "Your insurance application did not meet our criteria because your risk score is high.\r\n"
						+ "\r\n" + "Thank you for your interest.\r\n" + "\r\n" + "Regards,\r\n" + "Insurance Team");
			}

			javaMailSender.send(mimeMessage);
			System.out.println("Mail sent");
		} else {
			System.err.println("Applicant not found for ID: " + applicantId);
		}
	}
}
