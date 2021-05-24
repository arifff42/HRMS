package recapproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		@Column(name="id")
		private int id;
		
		@Column(name="first_name")
		private String firstName;
		
		@Column(name="last_name")
		private String lastName;
		
		@Column(name="identity_number")
		private String nationalIdentity;
		
		@Column(name="date_of_birth")
		private int dateOfYear;
		
		@Column(name="user_type_id")
		private int userTypeId;
		
		@Column(name="user_id")
		private int userId;
		
	
}
