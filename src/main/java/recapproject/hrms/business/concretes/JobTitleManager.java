package recapproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recapproject.hrms.business.abstracts.JobTitleService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.core.utilities.results.SuccessDataResult;
import recapproject.hrms.core.utilities.results.SuccessResult;
import recapproject.hrms.dataAccess.abstracts.JobTitleDao;
import recapproject.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private final JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {

		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public Result add(JobTitle jobTitle) {

		this.jobTitleDao.save(jobTitle);

		return new SuccessResult("Ürün Eklendi.");
	}

	@Override
	public Result update(JobTitle jobTitle) {

		this.jobTitleDao.save(jobTitle);

		return new SuccessResult("Ürün Güncellendi.");
	}

	@Override
	public Result delete(JobTitle jobTitle) {

		this.jobTitleDao.delete(jobTitle);

		return new SuccessResult("Ürün Silindi.");
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {

		return new SuccessDataResult<List<JobTitle>>(jobTitleDao.findAll(), "Ürünler Listelendi.");
	}

	@Override
	public DataResult<JobTitle> getById(int jobTitleId) {

		return new SuccessDataResult<JobTitle>(jobTitleDao.getById(jobTitleId), "Ürün Geldi.");
		// return null;
	}
}
