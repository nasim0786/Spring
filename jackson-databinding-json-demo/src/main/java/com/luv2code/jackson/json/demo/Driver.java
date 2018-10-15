package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			
			Student student = mapper.readValue(
				new File("data/sample-full.json"), Student.class);
			
			System.out.println("First name: " + student.getFirstName());
			System.out.println("Last name: " + student.getLastName());
			
			Address address = student.getAddress();
			System.out.println("Street: " + address.getStreet());
			System.out.println("City: " + address.getCity());
			System.out.println("State: " + address.getState());
			System.out.println("Zip: " + address.getZip());
			System.out.println("Country: " + address.getCountry());
			
			for (String lang : student.getLanguages()) {
				System.out.println(lang);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
