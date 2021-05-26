package recapproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recapproject.hrms.business.abstracts.UserActivationByAdminUserService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.dataAccess.abstracts.UserActivationByAdminUserDao;
import recapproject.hrms.entities.concretes.UserActivationByAdminUser;

@Service
public class UserActivationByAdminUserManager implements UserActivationByAdminUserService {

	private UserActivationByAdminUserDao userActivationByAdminUserDao;

	@Autowired
	public UserActivationByAdminUserManager(UserActivationByAdminUserDao userActivationByAdminUserDao) {

		this.userActivationByAdminUserDao = userActivationByAdminUserDao;
	}

	@Override
	public Result add(UserActivationByAdminUser userActivationByAdminUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(UserActivationByAdminUser userActivationByAdminUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(UserActivationByAdminUser userActivationByAdminUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<UserActivationByAdminUser>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<UserActivationByAdminUser> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
