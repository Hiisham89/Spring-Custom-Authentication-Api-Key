package com.hosham.test.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DemoController {

	@GetMapping("/demo")
	
	public String demo() {
		return"hello world";
	}
}
