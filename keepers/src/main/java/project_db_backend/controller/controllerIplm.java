package project_db_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controllerIplm {

	@GetMapping("")
	public String home() {
		return "/home";
	}
}
