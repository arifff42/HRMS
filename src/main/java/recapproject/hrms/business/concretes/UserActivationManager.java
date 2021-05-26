package recapproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recapproject.hrms.business.abstracts.UserActivationService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.dataAccess.abstracts.UserActivationDao;
import recapproject.hrms.entities.concretes.UserActivation;

@Service
public class UserActivationManager implements UserActivationService {

	private UserActivationDao userActivationDao;

	@Autowired
	public UserActivationManager(UserActivationDao userActivationDao) {

		this.userActivationDao = userActivationDao;
	}

	@Override
	public Result add(UserActivation userActivation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(UserActivation userActivation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(UserActivation userActivation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<UserActivation>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<UserActivation> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
