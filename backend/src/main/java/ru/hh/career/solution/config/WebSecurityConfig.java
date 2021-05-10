package ru.hh.career.solution.config;

import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;
import static javax.ws.rs.core.UriBuilder.fromResource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import ru.hh.career.solution.resource.AccountResource;

@Configuration
@EnableWebSecurity
@Import(FilterChainProxy.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private static final String USER_BY_USERNAME_QUERY = "select username, password_hash, 'true' as enabled "
    + "from account where username = ?";

  private static final String AUTHORITIES_BY_USERNAME_QUERY = "select username, 'USER' as authorities "
    + "from account where username = ?";

  private static final String SIGNUP_URL = fromResource(AccountResource.class).path(AccountResource.class, "signup").toString();
  private static final String LOGIN_URL = fromResource(AccountResource.class).path("login").toString();
  private static final String LOGOUT_URL = fromResource(AccountResource.class).path("logout").toString();

  private DataSource dataSource;

  private PasswordEncoder encoder;

  @Lazy
  @Inject
  WebSecurityConfig(DataSource dataSource, PasswordEncoder encoder) {
    this.dataSource = dataSource;
    this.encoder = encoder;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf().disable()
      .authorizeRequests()
        .antMatchers(HttpMethod.POST, SIGNUP_URL, LOGIN_URL, LOGOUT_URL).permitAll()
        .anyRequest().permitAll()
      .and()
        .exceptionHandling()
        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
      .and()
        .formLogin()
        .loginProcessingUrl(LOGIN_URL)
        .successHandler((request, response, authentication) -> response.setStatus(HttpStatus.NO_CONTENT.value()))
        .failureHandler(new SimpleUrlAuthenticationFailureHandler())
      .and()
        .logout()
        .logoutUrl(LOGOUT_URL)
        .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.NO_CONTENT));
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .jdbcAuthentication().dataSource(dataSource)
      .passwordEncoder(encoder)
      .usersByUsernameQuery(USER_BY_USERNAME_QUERY)
      .authoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME_QUERY);
  }

  // Gives finer control over encoders than PasswordEncoderFactories.createDelegatingPasswordEncoder
  @Bean
  @Primary
  public PasswordEncoder passwordEncoder(Map<String, PasswordEncoder> encoders) {
    return new DelegatingPasswordEncoder("bcrypt", encoders);
  }

  @Bean("bcrypt")
  public PasswordEncoder bcryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
