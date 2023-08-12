package medicalshifts.medicalshifts.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true) //PreAuthorize, PostAuthorize, PreFilter, PostFiter
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    @Order(1)
//    public SecurityFilterChain allFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf().disable().build();
//    }

//    @Bean
//    @Order(2)
//    public SecurityFilterChain permitAllFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeRequests()
//                .requestMatchers(HttpMethod.POST, "/register").permitAll()
//                .and().csrf().disable().build();
//    }
//
    @Bean
    @Order(1)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic()
                .and().authorizeRequests()
                .anyRequest().authenticated()
                .and().csrf().disable().build();
    }
    /*
        return http.csrf().disable().build();
                //.httpBasic()
                //.and()
//                .authorizeHttpRequests()
//                .requestMatchers("/**").authenticated()
//                .requestMatchers(HttpMethod.POST, "/register").permitAll()
                //.anyRequest().permitAll()
                //.anyRequest().denyAll()
                //.anyRequest().hasRole("ADMIN")
                //.anyRequest().hasAuthority("ADMIN")
                //.anyRequest().access(new WebExpressionAuthorizationManager("hasAuthority('ADMIN') OR hasAuthority('WRITE')"))
                //.requestMatchers("/auth/register").permitAll()
                //.anyRequest().authenticated()
                //.requestMatchers(HttpMethod.POST, "/register").permitAll()
                //.requestMatchers("/auth/login").permitAll()
                //.requestMatchers("/profiles").authenticated()
//                .and().csrf().disable().build();
    }
     */
}