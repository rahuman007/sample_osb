package com.sample.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

	@RequestMapping("hello")
	public String sayHello() {
		return "Hello";
	}
}
