package pl.com.nur.securitytudzien2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.com.nur.securitytudzien2.service.PeopleList;

import java.util.Collections;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PeopleList peopleList;



    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        for (int i = 0; i <peopleList.getPeopleList().size() ; i++) {
            auth.inMemoryAuthentication().withUser(
                    new User(peopleList.getPeopleList().get(i).getNick(),
                    getPasswordEncoder().encode(peopleList.getPeopleList().get(i).getPassword()),
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_" + peopleList.getPeopleList().get(i).getRole()))));
        }

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/forAdmin").hasRole("ADMIN")
                .antMatchers("/forUser").hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().logoutSuccessUrl("/papa");

    }
}
