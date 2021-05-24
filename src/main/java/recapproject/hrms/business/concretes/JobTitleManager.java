package recapproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recapproject.hrms.business.abstracts.JobTitleService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.SuccessDataResult;
import recapproject.hrms.dataAccess.abstracts.JobTitleDao;
import recapproject.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {

		return new SuccessDataResult<List<JobTitle>>(jobTitleDao.findAll(),"Ürünler Listelendi.");
	}
}
