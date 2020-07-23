package br.com.unnamed.spring_cloud_cadastro;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/login")
public class LoginController {
	
	@PostMapping
	@ResponseBody
	public String login(@RequestBody LoginForm loginForm) {
		return "";
	}
	
}

	
