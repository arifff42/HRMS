package recapproject.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@EqualsAndHashCode(callSuper = false)

//@JsonIgnoreProperties({ "hibenateLazyInitializer", "handler", "users" })

public class Candidate extends User {

	// @Id
	/*@GeneratedValue (strategy =  GenerationType.IDENTITY)
	@Column(name = "candidate_id", unique = true, nullable = false)
	private int candidateId;*/

	@Column(name = "first_name", updatable = true, nullable = false)
	private String firstName;

	@Column(name = "last_name", updatable = true, nullable = false)
	private String lastName;

	@Column(name = "national_id", updatable = true, nullable = false, unique = true, length = 11)
	private String nationalId;

	@Column(name = "date_of_birth", updatable = true, nullable = false)
	private LocalDate dateOfBirth;
}
