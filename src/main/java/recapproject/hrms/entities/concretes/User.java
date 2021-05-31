package recapproject.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
//@DynamicUpdate
//@JsonIgnoreProperties({ "hibenateLazyInitializer", "handler", "candidates" })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	
	@Column(name = "user_id")
	private int userId;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "password_again")
	private String passwordAgain;
	
	@JsonIgnore
	@OneToMany(mappedBy = "userId")
	private List<Candidate> candidate;
}
