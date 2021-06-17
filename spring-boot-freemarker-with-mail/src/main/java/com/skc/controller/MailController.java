package com.skc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skc.dto.MailRequest;
import com.skc.dto.MailResponse;
import com.skc.service.EmailService;

@RestController
public class MailController {

	@Autowired
	private EmailService service;

	@PostMapping("/sendingEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		Map<String, Object> model = new HashMap<>();
		model.put("name", request.getName());
		model.put("location", "Bangalore,India");
		return service.sendEmail(request, model);

	}
}
