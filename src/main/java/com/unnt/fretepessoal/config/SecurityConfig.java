package com.unnt.fretepessoal.config;

import com.google.gson.Gson;
import com.unnt.fretepessoal.security.JWTAuthenticationFilter;
import com.unnt.fretepessoal.security.JWTAuthorizationFilter;
import com.unnt.fretepessoal.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private Gson gson;

    @Autowired
    private UserDetailsService userDetailsService;

    private static final String[] PUBLIC_MATCHERS_ALL = {
        "/h2-console/**",
    };

    private static final String[] PUBLIC_MATCHERS_GET = {
    };

    private static final String[] PUBLIC_MATCHERS_POST = {
        "/users/signup"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        http.authorizeHttpRequests()
            .antMatchers(PUBLIC_MATCHERS_ALL).permitAll()
            .antMatchers(HttpMethod.GET,PUBLIC_MATCHERS_GET).permitAll()
            .antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil, gson))
            .addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService))
            .headers().frameOptions().disable()
            .and()
            .cors().configurationSource(corsConfigurationSource())
            .and()
            .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        final UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfig = new CorsConfiguration()
                .applyPermitDefaultValues();
        corsConfig.setAllowedMethods(
            List.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
        );
        source.registerCorsConfiguration("/**", corsConfig);
        return source;
    }
}
