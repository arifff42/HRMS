package recapproject.hrms.business.abstracts;

import java.util.List;

import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.Employer;

public interface EmployerService {

	Result add(Employer employer);

	Result update(Employer employer);

	Result delete(Employer employer);
	
	DataResult<List<Employer>> getAll();
	
	DataResult<Employer> findById(int id);
}
