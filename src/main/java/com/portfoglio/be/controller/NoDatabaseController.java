package com.portfoglio.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfoglio.be.service.NoDatabaseService;

@RestController
@RequestMapping("/api/v1/noDatabase")
public class NoDatabaseController {

	@Autowired
	private NoDatabaseService noDatabaseService;
	
	@GetMapping("/getMessage")
	public ResponseEntity<String> getMessage(){
		String message = noDatabaseService.getMessage();
		return ResponseEntity.ok(message);
	}
}
