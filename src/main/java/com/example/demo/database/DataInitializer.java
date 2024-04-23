package com.example.demo.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public void run(String... args) throws Exception {
		if(empRepo.count() == 0) {
			empRepo.insert(new EmployeeData(
					111111,
					"111111",
					"剛田武",
					true,
					false,
					"0000-00-00:00:00",
					"0000-00-00:00:00"
					));
		}
	}
}
