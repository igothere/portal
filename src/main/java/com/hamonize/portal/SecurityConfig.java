package com.hamonize.portal;

import com.hamonize.portal.social.CustomOAuth2UserService;
import com.hamonize.portal.user.SecurityUserDetailsService;
import com.hamonize.portal.util.SHA256Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LoginSuccessHandler authSuccessHandler;

    @Autowired
    LoginFailureHandler authFailureHandler;

    @Autowired
    SecurityUserDetailsService userDetailService;
    
    @Autowired
    CustomOAuth2UserService customOAuth2UserService;

    @Autowired
    private CustomAuthenticationProvider authProvider;
    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     SHA256Util sha256 = new SHA256Util();
    //     // sha256.getEncrypt(message, salt);

    //     return new BCryptPasswordEncoder();
    // }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     SHA256Util sha256 = new SHA256Util();
        
    //     return sha256;
    // }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers("/resources/**")
            .antMatchers("/css/**")
            .antMatchers("/js/**")
            .antMatchers("/img/**")
            .antMatchers("/images/**")
            .antMatchers("/vendors/**")
            .antMatchers("/argon/**");

            
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/**", "/signup/**", "/login/**","/","/setsession/**").permitAll()
            .anyRequest()
            .authenticated();
        
        http.formLogin()
            .loginPage("/login")
            .usernameParameter("userid")
            .passwordParameter("passwd")
            .loginProcessingUrl("/login/login")
            .successHandler(authSuccessHandler)
            .failureHandler(authFailureHandler);

        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/login/logout")).logoutSuccessUrl("/")
            .invalidateHttpSession(true);

        }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
        // auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
        // auth.userDetailsService(userDetailService);
        
    }



}
