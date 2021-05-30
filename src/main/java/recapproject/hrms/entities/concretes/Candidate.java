package recapproject.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
//@JsonIgnoreProperties({ "hibenateLazyInitializer", "handler", "users" })
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "candidate_id")//, nullable = false)
	private int candidateId;

	@Column(name = "first_name")//, updatable = true, nullable = false)
	private String firstName;

	@Column(name = "last_name")//, updatable = true, nullable = false)
	private String lastName;

	@Column(name = "national_id")//, updatable = true, nullable = false)
	private String nationalId;

	@Column(name = "date_of_birth")//, updatable = true, nullable = false)
	private LocalDate dateOfBirth;

	//@Column(name = "user_id")//, updatable = true, nullable = false)
	//private int userId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;
}
