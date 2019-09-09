package spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import spittr.dao.SpitterRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    private final SpitterRepository spitterRepository;

    @Autowired
    public SecurityConfig(DataSource dataSource , SpitterRepository spitterRepository) {
        this.dataSource = dataSource;
        this.spitterRepository = spitterRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("admin"))
                .roles("USER","ADMIN")
            .and()
                .withUser("user").password(new BCryptPasswordEncoder().encode("user"))
                .roles("USER");*/

        /*auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
                "SELECT username,password,true FROM spitter where username = ?"
        ).authoritiesByUsernameQuery("SELECT username,'ROLE_USER' from spitter where username = ?")
                .passwordEncoder(new BCryptPasswordEncoder());*/

        auth.userDetailsService(spitterRepository).passwordEncoder(new BCryptPasswordEncoder());

    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and()
                .authorizeRequests()
                .antMatchers("/spitter/user/**").authenticated()
                .antMatchers("/spittles/**").authenticated()
                .anyRequest().permitAll()
                .and().csrf().disable();
    }
}
