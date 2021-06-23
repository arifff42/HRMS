package recapproject.hrms.entities.concretes;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@EqualsAndHashCode(callSuper = false)

public class Employer extends User {

	// @Id
	/*@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employer_id", unique = true, nullable = false)
	private int employerId;*/

	@Column(name = "company_name", updatable = true, nullable = false)
	private String companyName;

	@Column(name = "web_address", updatable = true, nullable = false)
	private String webAddress;

	@Column(name = "phone_number", updatable = true, nullable = false)
	private String phoneNumber;

}
