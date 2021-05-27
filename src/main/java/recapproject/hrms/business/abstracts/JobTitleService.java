package recapproject.hrms.business.abstracts;

import java.util.List;

import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	
	Result add(JobTitle jobTitle);
	
	Result update(JobTitle jobTitle);

	Result delete(JobTitle jobTitle);	

	DataResult<List<JobTitle>> getAll();
	
	DataResult<JobTitle> getById(int jobTitleId);
}
