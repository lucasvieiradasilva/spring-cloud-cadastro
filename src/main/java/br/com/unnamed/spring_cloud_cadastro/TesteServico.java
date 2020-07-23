package br.com.unnamed.spring_cloud_cadastro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteServico {
	
//	@Autowired
//	private UsuarioRepository usuarioRepository;

	@GetMapping
	public String getCompraById() {
//		Usuario usuario = new Usuario();
////		usuario.setNome("Teste");
//		
//		usuarioRepository.save(usuario);
		
		return "OK";
	}
}
