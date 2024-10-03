import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder // Inject PasswordEncoder
) {

    @Transactional
    fun registerUser(user: User): User {
        if (userRepository.findByEmail(user.email).isPresent) {
            throw IllegalArgumentException("Email already exists")
        }
        user.password = passwordEncoder.encode(user.password)
        return userRepository.save(user)
    }

    fun getUserByEmail(email: String): User? {
        return userRepository.findByEmail(email).orElse(null)
    }

    fun checkPassword(rawPassword: String, encodedPassword: String): Boolean {
        return passwordEncoder.matches(rawPassword, encodedPassword)
    }

    // Other methods remain the same...
}
