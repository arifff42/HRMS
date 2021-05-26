package recapproject.hrms.business.abstracts;

import java.util.List;

import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.AdminUser;

public interface AdminUserService {
	
	Result add(AdminUser adminUser);

	Result update(AdminUser adminUser);
	
	Result delete(AdminUser adminUser);

	DataResult<List<AdminUser>> getAll();

	DataResult<AdminUser> findById(int id);

}
