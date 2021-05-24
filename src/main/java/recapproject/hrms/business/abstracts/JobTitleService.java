package recapproject.hrms.business.abstracts;

import java.util.List;

import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.entities.concretes.JobTitle;

public interface JobTitleService {

	DataResult<List<JobTitle>> getAll();
}
