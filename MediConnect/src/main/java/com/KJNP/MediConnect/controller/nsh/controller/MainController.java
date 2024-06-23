package com.KJNP.MediConnect.controller.nsh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/nsh")
	public String main() {
		
		return "nsh/main";
	}
}
