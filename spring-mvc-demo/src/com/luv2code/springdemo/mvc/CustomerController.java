package com.luv2code.springdemo.mvc;

import javax.validation.Valid;
import javax.xml.bind.Binder;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerBinder = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerBinder);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer customer,
			BindingResult bindingResult) {
		
		System.out.println("Customer Lastname: |" + customer.getLastName() + "|");
		
		System.out.println("Binding Result: " + bindingResult);
		
		System.out.println("\n\n\n\n");
		
		if (bindingResult.hasErrors()) {
			return "customer-form";
		} else {
			return "customer-confirmation";
		}
	}

}
