package recapproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import recapproject.hrms.entities.concretes.UserActivationByAdminUser;

public interface UserActivationByAdminUserDao extends JpaRepository<UserActivationByAdminUser,Integer>{

}
