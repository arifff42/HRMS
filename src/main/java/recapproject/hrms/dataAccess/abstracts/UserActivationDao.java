package recapproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import recapproject.hrms.entities.concretes.UserActivation;

public interface UserActivationDao extends JpaRepository<UserActivation,Integer>{

}
