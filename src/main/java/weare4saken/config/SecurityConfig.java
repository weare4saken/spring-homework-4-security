package weare4saken.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("Liza").password("qwerty").roles("EMPLOYEE"))
                .withUser(userBuilder.username("Katya").password("asdfg").roles("IT"))
                .withUser(userBuilder.username("Alena").password("zxcvb").roles("STUFF"))
                .withUser(userBuilder.username("Tanya").password("12345").roles("DIRECTOR"));
    }
}
