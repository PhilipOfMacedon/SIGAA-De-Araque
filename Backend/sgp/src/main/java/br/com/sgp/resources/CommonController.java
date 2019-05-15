package br.com.sgp.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

	@RequestMapping("/")
	public String index() {
		return "Testing homepage!";
	}
}
