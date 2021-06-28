package recapproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recapproject.hrms.adapters.mernis.MernisVerificationManager;
import recapproject.hrms.business.abstracts.AdminUserService;
import recapproject.hrms.business.abstracts.UserService;
import recapproject.hrms.core.utilities.business.BusinessRules;
import recapproject.hrms.core.utilities.results.*;
import recapproject.hrms.core.validation.UserValidation;
import recapproject.hrms.dataAccess.abstracts.AdminUserDao;
import recapproject.hrms.entities.concretes.AdminUser;

@Service
public class AdminUserManager implements AdminUserService {

	private final AdminUserDao adminUserDao;
	private UserService userService;

	UserValidation userValidation = new UserValidation(new MernisVerificationManager());

	@Autowired
	public AdminUserManager(AdminUserDao adminUserDao, UserService userService) {

		this.adminUserDao = adminUserDao;
		this.userService = userService;
	}

	@Override
	public Result add(AdminUser adminUser) {

		AdminUser adminUserAddDB = new AdminUser();

		adminUserAddDB.setFirstName(userValidation.CapitalizeFirstLetterofWord(adminUser.getFirstName()));

		adminUserAddDB.setLastName(adminUser.getLastName().toUpperCase());

		adminUserAddDB.setEmail(adminUser.getEmail());

		adminUserAddDB.setPassword(adminUser.getPassword());

		adminUserAddDB.setPasswordAgain(adminUser.getPasswordAgain());

		adminUserAddDB.setCreatedAt(adminUser.getCreatedAt());

		adminUserAddDB.setDeleted(adminUser.isDeleted());

		adminUserAddDB.setVerified(adminUser.isVerified());

		var result = BusinessRules.run(this.userService.checkDBEmails(adminUserAddDB.getEmail())
		,this.userValidation.checkPasswords(adminUserAddDB.getPassword(), adminUserAddDB.getPasswordAgain()));

		if (!result.isSuccess()) {

			return new ErrorResult(result.getMessage());

		} else {

			this.adminUserDao.save(adminUser);

			return new SuccessResult("Ürün Eklendi.");
		}


	}

	@Override
	public Result update(AdminUser adminUser) {

		this.adminUserDao.save(adminUser);

		return new SuccessResult("Ürün Güncellendi.");
	}

	@Override
	public Result delete(AdminUser adminUser) {

		this.adminUserDao.delete(adminUser);

		return new SuccessResult("Ürün Silindi.");
	}

	@Override
	public DataResult<AdminUser> getById(int id) {

		return new SuccessDataResult<AdminUser>(adminUserDao.getById(id), "Ürünler Listelendi.");
	}

	@Override
	public DataResult<List<AdminUser>> getAll() {

		return new SuccessDataResult<List<AdminUser>>(adminUserDao.findAll(), "Ürünler Listelendi.");
	}
}
