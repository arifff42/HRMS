package recapproject.hrms.business.abstracts;

import java.util.List;

import recapproject.hrms.entities.concretes.JobTitle;

public interface JobTitleService {

	List<JobTitle> getAll();
}
