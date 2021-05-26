package recapproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import recapproject.hrms.entities.concretes.AdminUser;

public interface AdminUserDao extends JpaRepository<AdminUser,Integer>{

}
