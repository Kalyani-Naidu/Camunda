package com.saas.camunda.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import lombok.extern.slf4j.Slf4j;

import javax.mail.*;
import javax.mail.internet.*;


@Service
@Slf4j
public class ServiceCall {
	@Autowired
	private customerRepository customerRepo;

	@JobWorker(type = "messageEvent", autoComplete = true)
	public void sendEmail() {

		String from = "kalyani.uppula@eidiko-india.com";
		String to = "Saikumar.Gaini@eidiko-india.com";
		String host = "eidiko-india.com";

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Case Refernce No: CAM123412062023");
			message.setText("Hi, please take the necessary action on the above case");
			Transport.send(message);

			System.out.println("Message sent successfully");

		} catch (MessagingException exception) {
			exception.printStackTrace();
		}

	}
	
	@JobWorker(type = "validate", autoComplete = true)
	public void Validation(JobClient client, ActivatedJob activatedJob) {

		Map<String, Object> map = activatedJob.getVariablesAsMap();
		String dish = map.get("Dish").toString();
		System.out.println("Dish prepared:" + dish);
		System.out.println("true");
		map.replace("Dish", "Light Salad and a nice Steak", "It is a good recipe! You must try it!!!");
		System.out.println("Modified Value: " + map.get("Dish").toString());

		client.newCompleteCommand(activatedJob).variables(map).send().join();

	}

	@JobWorker(type="mail", autoComplete = true)
	public void sendEmail(ActivatedJob activatedJob) {
		
		String pattern = "ddMMyyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println("Today: "+date);
		long min = 10000;  
		long max = 99999;  
		int ref = (int)(Math.random()*(max-min+1)+min); 
		String refNum = "DMN"+ref+date;
		System.out.println("reference number is "+refNum);
		
		String to = "Saikumar.Gaini@eidiko-india.com";
		String from = "kalyani.uppula@eidiko-india.com";
		String host = "eidiko-india.com";
		
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		javax.mail.Session session = javax.mail.Session.getDefaultInstance(properties);
		
		try {
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Case Ref No:"+refNum);
			message.setText("Your dish is prepared successfully");
			
			Transport.send(message);
			System.out.println("Mail sent successfully");
		}
		catch(MessagingException exception) {
			exception.printStackTrace();
		}
		}

	@JobWorker(type = "customerData", autoComplete = true)
	public void serviceTaskImplementation(ActivatedJob activatedJob) {
		Map<String, Object> variableMap = activatedJob.getVariablesAsMap();

		System.out.println("Service Task Received: " + variableMap.values());
		System.out.println("Service Call Executed...");

		customerDataEntity customer = new customerDataEntity();
		customer.setFirstName(variableMap.get("firstName").toString());
		customer.setLastName(variableMap.get("lastName").toString());
		customer.setAccountNumber(variableMap.get("accountNumber").toString());
		customer.setPhoneNumber(variableMap.get("phoneNumber").toString());
		customer.setAadhar(variableMap.get("aadhar").toString());
		customer.setPan(variableMap.get("pan").toString());
		customer.setGender(variableMap.get("gender").toString());
		customer.setNationality(variableMap.get("nationality").toString());
		customer.setFdOpeningDate(variableMap.get("fdOpeningDate").toString());
		customer.setMonthlyIncome(variableMap.get("monthlyIncome").toString());

		customerDataEntity customer1 = customerRepo.save(customer);
		System.out.println("Data inserted successfully");
		System.out.println(customer1);

	}

}
