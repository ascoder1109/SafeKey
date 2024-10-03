import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() } // Disable CSRF protection
            .authorizeHttpRequests { requests ->
                requests
                    .requestMatchers("/api/auth/register", "/api/auth/login").permitAll() // Allow access to these endpoints
                    .anyRequest().authenticated() // Any other request requires authentication
            }
            .formLogin { it.permitAll() } // Enables default form-based login
            .logout { it.permitAll() } // Enables default logout functionality

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
