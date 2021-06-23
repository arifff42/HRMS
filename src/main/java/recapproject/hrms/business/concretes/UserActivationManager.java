package recapproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recapproject.hrms.business.abstracts.UserActivationService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.core.utilities.results.SuccessDataResult;
import recapproject.hrms.core.utilities.results.SuccessResult;
import recapproject.hrms.dataAccess.abstracts.UserActivationDao;
import recapproject.hrms.entities.concretes.UserActivation;

@Service
public class UserActivationManager implements UserActivationService {

	private final UserActivationDao userActivationDao;

	@Autowired
	public UserActivationManager(UserActivationDao userActivationDao) {

		this.userActivationDao = userActivationDao;
	}

	@Override
	public Result add(UserActivation userActivation) {

		this.userActivationDao.save(userActivation);

		return new SuccessResult("Ürün Eklendi.");
	}

	@Override
	public Result update(UserActivation userActivation) {

		this.userActivationDao.save(userActivation);

		return new SuccessResult("Ürün Güncellendi.");
	}

	@Override
	public Result delete(UserActivation userActivation) {

		this.userActivationDao.delete(userActivation);

		return new SuccessResult("Ürün Silindi.");
	}

	@Override
	public DataResult<UserActivation> getById(int id) {

		return new SuccessDataResult<UserActivation>(userActivationDao.getById(id), "Ürünler Listelendi.");
	}

	@Override
	public DataResult<List<UserActivation>> getAll() {

		return new SuccessDataResult<List<UserActivation>>(userActivationDao.findAll(), "Ürünler Listelendi.");
	}
}
