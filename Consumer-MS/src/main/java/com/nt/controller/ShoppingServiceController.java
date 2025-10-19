package com.nt.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BillingServiceComponent;

@RestController
@RequestMapping("/shopping")
public class ShoppingServiceController {
	
	@Autowired
	private BillingServiceComponent billingServiceComponent;
	
	@GetMapping("/details")
	public ResponseEntity<String> showBillingDetails() {
		String res = billingServiceComponent.getBillingInfo();
		String billInfo = "Bill Amount:: "+new Random().nextInt(100000);
		return new ResponseEntity<String>(billInfo + "..." + res,HttpStatus.OK);
	}
	

}
