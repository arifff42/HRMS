package recapproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import recapproject.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer>{


}
