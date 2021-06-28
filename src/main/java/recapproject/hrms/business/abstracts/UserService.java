package recapproject.hrms.business.abstracts;

import java.util.List;

import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.User;

public interface UserService {
	
	Result add(User user);
	
	Result update(User user);

	Result delete(User user);

	DataResult<List<User>> getAll();
	
	DataResult<User> getById(int id);

	Result checkDBEmails(String usermail);
}
