import jakarta.persistence.*
import lombok.Data
import javax.annotation.processing.Generated

@Entity
@Data
@Table(name="user")
data class User(
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    val id: Long = 0,

    @Column(name="name")
    val name: String,

    @Column(name="email")
    val email: String,

    @Column(name="password")
    var password: String,
)