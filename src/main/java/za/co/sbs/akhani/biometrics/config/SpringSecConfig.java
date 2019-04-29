package za.co.sbs.akhani.biometrics.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        httpSecurity.authorizeRequests().antMatchers("/","/swagger-resources").permitAll();
//        httpSecurity.csrf().disable();
//        httpSecurity.headers().frameOptions().disable();

        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()
//                .antMatchers("/api/**").authenticated()
                .anyRequest().permitAll()
                .and().headers().frameOptions().disable()
                .and().csrf().disable();
    }


}