package recapproject.hrms.entities.concretes;

import java.time.LocalDate;
//import recapproject.hrms.entities.concretes.*;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
//@JsonIgnoreProperties({ "hibenateLazyInitializer", "handler", "ss" })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private int userId;

	@Column(name = "email", updatable = true, nullable = false, unique = true)
	private String email;

	@Column(name = "password", updatable = true, nullable = false)
	private String password;

	@Column(name = "password_again", updatable = true, nullable = false)
	private String passwordAgain;

	@Column(name = "created_at", updatable = true, nullable = false)
	private LocalDate createdAt = LocalDate.now();

	@Column(name = "is_verified", updatable = true, nullable = false)
	private boolean isVerified = false;

	@Column(name = "is_deleted", updatable = true, nullable = false)
	private boolean isDeleted = false;

	@OneToMany(mappedBy = "userId")
	private List<UserActivation> userActivation;

}
