package recapproject.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_activations_by_admin_users")
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class UserActivationByAdminUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "admin_activation_id")
	private int adminActivationId;

	@Column(name = "confirmed_admin_id")
	private int confirmedAdminId;
	
	@Column(name = "confirmed_employer_id")
	private int confirmedEmployerId;

	@Column(name = "confirmation_date")
	private Date confirmationDate;

	@Column(name = "is_confirmed")
	private boolean isConfirmed;
}
