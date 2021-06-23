package recapproject.hrms.entities.concretes;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "admin_users")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@EqualsAndHashCode(callSuper = false)

public class AdminUser extends User {

	// @Id
	/*@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_user_id", unique = true, nullable = false)
	private int adminUserId;*/

	@Column(name = "first_name", updatable = true, nullable = false)
	private String firstName;

	@Column(name = "last_name", updatable = true, nullable = false)
	private String lastName;

}
