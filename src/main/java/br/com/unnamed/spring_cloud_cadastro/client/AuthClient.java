package br.com.unnamed.spring_cloud_cadastro.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.unnamed.spring_cloud_cadastro.LoginDTOout;

@FeignClient("auth")
public interface AuthClient {

	@PostMapping("oath/token")
	public LoginDTOout getInfoPorEstado(@PathVariable String estado);

}
