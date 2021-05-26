package recapproject.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_activations")
@AllArgsConstructor
@NoArgsConstructor
public class UserActivation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private int id;

	@Column(name = "activation_code")
	private String activationCode;

	@Column(name = "is_confirmed")
	private boolean isConfirmed;

	@Column(name = "confirmation_date")
	private Date confirmationDate;

	@Column(name = "user_id")
	private int userId;

}
