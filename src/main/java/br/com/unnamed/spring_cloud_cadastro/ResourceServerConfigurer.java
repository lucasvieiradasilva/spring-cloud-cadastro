package br.com.unnamed.spring_cloud_cadastro;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers(HttpMethod.GET, "/teste/a")
//			.hasRole("USER");
		
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/teste").authenticated()
			.antMatchers(HttpMethod.POST, "/login").permitAll();
		
		// OBS removi o usu do hystrix do projeto, pois aparentemente é uma lib descontinuada
		// O Zuul pode ser substituido por uma implementação pura (pesquisar sobre)
	}

}
