package br.com.unnamed.spring_cloud_cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.client.RestTemplate;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@ComponentScan(basePackages = {"br.com.unnamed.springdomains", "br.com.unnamed.spring_cloud_cadastro"})
@EnableJpaRepositories(basePackages = {"br.com.unnamed.springdomains", "br.com.unnamed.spring_cloud_cadastro"})
@EntityScan(basePackages = {"br.com.unnamed.springdomains", "br.com.unnamed.spring_cloud_cadastro"})
@SpringBootApplication
@EnableResourceServer
@EnableFeignClients
public class SpringCloudCadastroApplication {
//	private final RedisConnectionFactory redisConnectionFactory;
//
//  @Bean
//  public RedisTemplate<?, ?> redisTemplate() {
//      RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
//      template.setConnectionFactory(redisConnectionFactory);
//      template.afterPropertiesSet();
//      return template;
//  }

//Intercepta o feign client, assim podemos passar o token para as requisições
	@Bean
	public RequestInterceptor getInterceptorDeAutenticacao() {
		return new RequestInterceptor() {

			@Override
			public void apply(RequestTemplate template) {

				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				if(authentication == null) {
					return;
				}

				OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
				template.header("Authorization", "Bearer" + details.getTokenValue());
			}
		};

	}


	// Com essa anotação ele consegue pegar o nome da aplicação no eureka server
	// Quando houver mais de uma instancia para uma mesma aplicação, é o load balanced que irá dimensionar as requisições
	// distribuindo as cargas para ganhos de performance, isso quando uma mesma aplicação é erguida em mais de uma porta
	// Nao é exclusivo do eureka, pois estamos agora usando feign (eureka e feign são padrões para spring cloud)
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudCadastroApplication.class, args);







	}



	/**
	 * application.yml
	 *
	 * spring:
 datasource:
    username: postgres
    password: postgres
    url: jdbc:postgresql://localhost:5432/Teste
    #platform: postgres
 jpa:
    properties:
       hibernate.show_sql: true
       hibernate.format_sql: true
    hibernate:
       ddl-auto: update
       database-platform: org.hibernate.dialect.PostgreSQLDialect




    #database-platform: org.hibernate.dialect.MySQL5InnoDBDialect

    #spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
    #spring.jpa.hibernate.ddl-auto=none
    #spring.datasource.initialization-mode=always
    #spring.main.banner-mode=off
    #logging.level.org.springframework=ERROR

    # Details for our datasource
#spring.datasource.url = jdbc:postgresql://localhost:5432/database
#spring.datasource.username = postgres
#spring.datasource.password = postgres

# Hibernate properties
#spring.jpa.database = org.hibernate.dialect.PostgreSQLDialect
#spring.jpa.show-sql = false
#spring.jpa.hibernate.ddl-auto = create-drop
#spring.jpa.hibernate.naming.implicit-strategy = org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl
#spring.jpa.properties.hibernate.format_sql=true
	 *
	 *
	 */
}