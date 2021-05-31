package recapproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import recapproject.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate,Integer>{
	
	@Query("from Candidate where nationalId=:nationalId")
	Candidate getByNationalId(String nationalId);

}
