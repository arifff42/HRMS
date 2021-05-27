package recapproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recapproject.hrms.business.abstracts.EmployerService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.core.utilities.results.SuccessDataResult;
import recapproject.hrms.core.utilities.results.SuccessResult;
import recapproject.hrms.dataAccess.abstracts.EmployerDao;
import recapproject.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {

		this.employerDao = employerDao;
	}

	@Override
	public Result add(Employer employer) {

		this.employerDao.save(employer);

		return new SuccessResult("Ürün Eklendi.");
	}

	@Override
	public Result update(Employer employer) {

		this.employerDao.save(employer);

		return new SuccessResult("Ürün Güncellendi.");
	}

	@Override
	public Result delete(Employer employer) {

		this.employerDao.delete(employer);

		return new SuccessResult("Ürün Silindi.");
	}

	@Override
	public DataResult<Employer> getById(int id) {

		return new SuccessDataResult<Employer>(employerDao.getById(id), "Ürünler Listelendi.");
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "Ürünler Listelendi.");
	}
}
