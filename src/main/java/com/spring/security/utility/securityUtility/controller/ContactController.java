package com.spring.security.utility.securityUtility.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utility")
public class ContactController {
    @GetMapping("/contact")
	public String getContact() {
		return "you will et your contact";
	}
}
