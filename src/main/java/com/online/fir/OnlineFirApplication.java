package com.online.fir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for Spring boot application.
 *
 * @author Simran Tyagi Komal Tyagi
 * @implSpec specific to Stations,FIRs and User API
 * @since 2022-04-04
 */

@SpringBootApplication(scanBasePackages = "com.online.fir")
public class OnlineFirApplication {

	/**
	 * Main method, used to run the application.
	 * @param args the command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(OnlineFirApplication.class, args);
	}

}
