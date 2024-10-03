
import com.ascoder1109.securekey.DTO.UserLoginDTO
import com.ascoder1109.securekey.DTO.UserRegistrationDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(private val userService: UserService) {

    @PostMapping("/register")
    fun register(@RequestBody userRegistrationDTO: UserRegistrationDTO): ResponseEntity<User> {
        val user = User(
            name = userRegistrationDTO.name,
            email = userRegistrationDTO.email,
            password = userRegistrationDTO.password // Hash this before saving
        )
        return ResponseEntity(userService.registerUser(user), HttpStatus.CREATED)
    }

    @PostMapping("/login")
    fun login(@RequestBody userLoginDTO: UserLoginDTO): ResponseEntity<String> {
        val user = userService.getUserByEmail(userLoginDTO.email)
            ?: return ResponseEntity("Invalid credentials", HttpStatus.UNAUTHORIZED)

        if (!userService.checkPassword(userLoginDTO.password, user.password)) {
            return ResponseEntity("Invalid credentials", HttpStatus.UNAUTHORIZED)
        }
        return ResponseEntity.ok("Login successful")
    }
}