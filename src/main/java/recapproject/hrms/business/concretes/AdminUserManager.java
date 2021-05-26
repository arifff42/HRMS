package recapproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recapproject.hrms.business.abstracts.AdminUserService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.dataAccess.abstracts.AdminUserDao;
import recapproject.hrms.entities.concretes.AdminUser;

@Service
public class AdminUserManager implements AdminUserService {

	private AdminUserDao adminUserDao;

	@Autowired
	public AdminUserManager(AdminUserDao adminUserDao) {

		this.adminUserDao = adminUserDao;
	}

	@Override
	public Result add(AdminUser adminUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(AdminUser adminUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(AdminUser adminUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<AdminUser> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public DataResult<List<AdminUser>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
