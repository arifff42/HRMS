package recapproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recapproject.hrms.business.abstracts.UserActivationByAdminUserService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.core.utilities.results.SuccessDataResult;
import recapproject.hrms.core.utilities.results.SuccessResult;
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

		this.userActivationByAdminUserDao.save(userActivationByAdminUser);

		return new SuccessResult("Ürün Eklendi.");
	}

	@Override
	public Result update(UserActivationByAdminUser userActivationByAdminUser) {

		this.userActivationByAdminUserDao.save(userActivationByAdminUser);

		return new SuccessResult("Ürün Güncellendi.");
	}

	@Override
	public Result delete(UserActivationByAdminUser userActivationByAdminUser) {

		this.userActivationByAdminUserDao.delete(userActivationByAdminUser);

		return new SuccessResult("Ürün Silindi.");
	}

	@Override
	public DataResult<UserActivationByAdminUser> getById(int id) {

		return new SuccessDataResult<UserActivationByAdminUser>(userActivationByAdminUserDao.getById(id),
				"Ürünler Listelendi.");
	}

	@Override
	public DataResult<List<UserActivationByAdminUser>> getAll() {

		return new SuccessDataResult<List<UserActivationByAdminUser>>(userActivationByAdminUserDao.findAll(),
				"Ürünler Listelendi.");
	}
}
