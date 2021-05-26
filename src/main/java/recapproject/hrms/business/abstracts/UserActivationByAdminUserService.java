package recapproject.hrms.business.abstracts;

import java.util.List;

import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.UserActivationByAdminUser;

public interface UserActivationByAdminUserService {

	Result add(UserActivationByAdminUser userActivationByAdminUser);

	Result update(UserActivationByAdminUser userActivationByAdminUser);

	Result delete(UserActivationByAdminUser userActivationByAdminUser);
	
	DataResult<List<UserActivationByAdminUser>> getAll();
	
	DataResult<UserActivationByAdminUser> findById(int id);
}
