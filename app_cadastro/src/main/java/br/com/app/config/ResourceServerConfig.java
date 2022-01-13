package br.com.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // permite todos permitAll()
        // http.authorizeRequests().antMatchers("/api/clientes").permitAll();
        // permite a USER e ADMIN essa url
        // http.authorizeRequests().antMatchers("/api/clientes").hasAnyRole("USER", "ADMIN");
        // apenas USER
        // http.authorizeRequests().antMatchers("/api/clientes/**").hasRole("USER");

        http.authorizeRequests().antMatchers("/api/usuarios").permitAll()
                .antMatchers("/api/clientes/**",
                                        "/api/servicos-prestados/**").authenticated()
                .anyRequest().denyAll();
    }
}
