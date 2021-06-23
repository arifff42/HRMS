package recapproject.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_activations")
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate

public class UserActivation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "activation_id", unique = true, nullable = false)
	private int activationId;

	@Column(name = "activation_code", updatable = false, nullable = false)
	private String activationCode;

	@Column(name = "is_confirmed", updatable = true, nullable = false)
	private boolean isConfirmed = false;

	@Column(name = "confirmation_date", updatable = true, nullable = false)
	private LocalDate confirmationDate;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User userId;

}
