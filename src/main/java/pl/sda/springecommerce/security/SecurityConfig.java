package pl.sda.springecommerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig{


    @Bean
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/**")
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().hasRole("USER")
                )
                .httpBasic(withDefaults());
        return http.build();
    }




//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth -> auth
//                       .requestMatchers("/login", "/register", "/register/**", "/css/**","/h2-console/**").permitAll()
//                        .anyRequest().authenticated());
//
//                return http.build();
//    }
}



//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//
//
//               http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/login", "/register", "/clubs", "/register/**", "/css/**", "/js/**","/h2-console/**")
//                .permitAll()
//                .and()
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/")
//                        .loginProcessingUrl("/login")
//                        .failureUrl("/login?error=true")
//                        .permitAll()
//                ).logout(
//                        logout -> logout
//                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
//                );
//
//        return http.build();
//    }
