package weare4saken.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class SecurityConfigNew extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("Liza").password("qwerty").roles("EMPLOYEE"))
                .withUser(userBuilder.username("Katya").password("asdfg").roles("IT"))
                .withUser(userBuilder.username("Alena").password("zxcvb").roles("STUFF"))
                .withUser(userBuilder.username("Tanya").password("12345").roles("DIRECTOR"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "IT", "STUFF", "DIRECTOR")
                .antMatchers("/it").hasAnyRole("IT", "STUFF", "DIRECTOR")
                .antMatchers("/stuff").hasAnyRole("STUFF", "DIRECTOR")
                .antMatchers("/director").hasAnyRole("DIRECTOR")
                .and().formLogin().permitAll();

    }
}
