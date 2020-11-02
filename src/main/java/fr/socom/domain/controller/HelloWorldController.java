package fr.socom.domain.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Dans ce projet spring boot nous avons deux contrôleurs: HelloWorldController et AuthenticationController.
@RestController
@CrossOrigin()
public class HelloWorldController {

	@RequestMapping({ "/hello" })
	public String hello() {
		return "Hello World";
	}

}