package recapproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import recapproject.hrms.entities.concretes.JobTitle;


public interface JobTitleDao extends JpaRepository<JobTitle,Integer>{

}
