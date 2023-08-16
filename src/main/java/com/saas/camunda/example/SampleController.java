package com.saas.camunda.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.camunda.zeebe.spring.client.lifecycle.ZeebeClientLifecycle;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SampleController {

	@Autowired
	private ZeebeClientLifecycle client;
	
//	@Autowired
//	private customerRepository customerRepo;
	
	@GetMapping("/start")
	public void StartFdProcess() {
//		Map<String, Object> map = new HashMap<>();
//		Optional<customerDataEntity> optional = customerRepo.findById(1952);
//		customerDataEntity data = optional.get();
//		System.out.println("Data fetched successfully:"+data);
//		map.put("firstName", data.getFirstName());
//		map.put("lastName", data.getLastName());
//		map.put("accountNumber", data.getAccountNumber());
//		map.put("phoneNumber", data.getPhoneNumber());
//		map.put("aadhar", data.getAadhar());
//		map.put("pan", data.getPan());
//		map.put("gender", data.getGender());
//		map.put("nationality", data.getNationality());
//		map.put("fdOpeningDate", data.getFdOpeningDate());
//		map.put("monthlyIncome", data.getMonthlyIncome());
//		

		Map<String,Object> m = new HashMap<>();
		m.put("firstName", "Ananya");
		m.put("lastName", "Perelli");
		m.put("accountNumber", "1475100001235");
		m.put("phoneNumber", "9842563170");
		m.put("aadhar", "42500361122");
		m.put("pan", "FGYUI9800K");
		m.put("gender", "F");
		m.put("nationality", "British");
		m.put("fdOpeningDate", "2021-05-14");
		m.put("monthlyIncome", "78090");
		m.put("season", "Summer");
		m.put("guestCount", "5");
		
		client
				.newCreateInstanceCommand()
				.bpmnProcessId("fdProcess")
				.latestVersion()
				.variables(m)
				.send()
				.join();
		
	
	
}
}



