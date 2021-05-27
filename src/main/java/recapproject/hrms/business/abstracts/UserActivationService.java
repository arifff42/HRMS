package recapproject.hrms.business.abstracts;

import java.util.List;

import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.UserActivation;

public interface UserActivationService {

	Result add(UserActivation userActivation);

	Result update(UserActivation userActivation);

	Result delete(UserActivation userActivation);
	
	DataResult<List<UserActivation>> getAll();
	
	DataResult<UserActivation> getById(int id);
}
