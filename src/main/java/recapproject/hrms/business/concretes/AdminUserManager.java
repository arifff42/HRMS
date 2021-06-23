package recapproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recapproject.hrms.business.abstracts.AdminUserService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.core.utilities.results.SuccessDataResult;
import recapproject.hrms.core.utilities.results.SuccessResult;
import recapproject.hrms.dataAccess.abstracts.AdminUserDao;
import recapproject.hrms.entities.concretes.AdminUser;

@Service
public class AdminUserManager implements AdminUserService {

	private final AdminUserDao adminUserDao;

	@Autowired
	public AdminUserManager(AdminUserDao adminUserDao) {

		this.adminUserDao = adminUserDao;
	}

	@Override
	public Result add(AdminUser adminUser) {

		this.adminUserDao.save(adminUser);

		return new SuccessResult("Ürün Eklendi.");
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
