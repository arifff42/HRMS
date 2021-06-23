package recapproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recapproject.hrms.adapters.mernis.MernisVerificationManager;
import recapproject.hrms.business.abstracts.UserService;
import recapproject.hrms.core.utilities.business.BusinessRules;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.ErrorResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.core.utilities.results.SuccessDataResult;
import recapproject.hrms.core.utilities.results.SuccessResult;
import recapproject.hrms.core.validation.UserValidation;
import recapproject.hrms.dataAccess.abstracts.UserDao;
import recapproject.hrms.entities.concretes.Employer;
import recapproject.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private final UserDao userDao;
	
	UserValidation userValidation = new UserValidation(new MernisVerificationManager());


	@Autowired
	public UserManager(UserDao userDao) {

		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {

		User  userAddInDB = new User();
		
		userAddInDB.setEmail(user.getEmail().toString());
		
		userAddInDB.setPassword(user.getPassword());
		
		userAddInDB.setPasswordAgain(user.getPasswordAgain());
		
		userAddInDB.setCreatedAt(user.getCreatedAt());
		
		userAddInDB.setDeleted(user.isDeleted());
		
		userAddInDB.setVerified(user.isVerified());
		
		var result = BusinessRules.run();

		if (!result.isSuccess()) {

			return new ErrorResult(result.getMessage());

		} else {

			this.userDao.save(userAddInDB);
			return new SuccessResult("Kullanıcı Eklendi.");
		}
		
	}

	@Override
	public Result update(User user) {

		this.userDao.save(user);

		return new SuccessResult("Ürün Güncellendi.");
	}

	@Override
	public Result delete(User user) {

		this.userDao.delete(user);

		return new SuccessResult("Ürün Silindi.");
	}

	@Override
	public DataResult<User> getById(int id) {

		return new SuccessDataResult<User>(userDao.getById(id), "Ürünler Listelendi.");
	}

	@Override
	public DataResult<List<User>> getAll() {

		return new SuccessDataResult<List<User>>(userDao.findAll(), "Ürünler Listelendi.");
	}
}
