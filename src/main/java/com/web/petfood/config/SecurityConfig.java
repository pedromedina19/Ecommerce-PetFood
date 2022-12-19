package com.web.petfood.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

	@Autowired
	private DataSource dataSource;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				// Qualquer um pode fazer requisições para essas URLs
				.antMatchers("/css/**", "/js/**", "/images/**", "/", "/index.html", "/produtos/pesquisarproduto", "/clientes/abrircadastrar","/clientes/cadastrar").permitAll()
				// Um usuário autenticado e com o papel ADMIN pode fazer requisições para essas
				// URLs
				.antMatchers("/relatorios/produtospormarcas", "/produtos/pesquisar", "/usuarios/cadastrar")
				.hasRole("ADMIN")
				.antMatchers("/produtos/abrircadastrar", "/marcas/cadastrar").hasAnyRole("ADMIN", "FUNCIONARIO")
				.antMatchers("/produtos/addcarrinho").hasAnyRole("ADMIN", "CLIENTE")
				// .antMatchers("URL").hasAnyRole("ADMIN", "USUARIO")
				// Todas as outras requisições exigem um usuário autenticado
				.anyRequest().authenticated()
				.and()
				// A autenticação usando formulário está habilitada
				.formLogin()
				// Uma página de login customizada
				.loginPage("/login").permitAll()
				// Define a URL para o caso de falha no login
				// .failureUrl("/login-error");
				.and()
				// Para fazer logout (já é configurado automaticamente para a URL /logout)
				// Só está habilitado aqui para mudarmos a URL de sucesso do logout
				.logout()
				// Define a URL para o caso do usuário fazer logout. O padrão é /login
				.logoutSuccessUrl("/");
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
		manager.setUsersByUsernameQuery("select nome_usuario, senha, ativo "
				+ "from usuario "
				+ "where nome_usuario = ?");
		manager.setAuthoritiesByUsernameQuery(
				"SELECT tab.nome_usuario , papel.nome FROM"
						+ "(SELECT usuario.nome_usuario , usuario.codigo FROM usuario WHERE nome_usuario = ?) as tab "
						+ " INNER JOIN usuario_papel ON codigo_usuario = tab.codigo "
						+ " INNER JOIN papel ON codigo_papel = papel.id;");
		return manager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}