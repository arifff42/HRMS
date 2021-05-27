package recapproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recapproject.hrms.business.abstracts.EmployeeService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.core.utilities.results.SuccessDataResult;
import recapproject.hrms.core.utilities.results.SuccessResult;
import recapproject.hrms.dataAccess.abstracts.EmployeeDao;
import recapproject.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {

		this.employeeDao = employeeDao;
	}

	@Override
	public Result add(Employee employee) {

		this.employeeDao.save(employee);

		return new SuccessResult("Ürün Eklendi.");
	}

	@Override
	public Result update(Employee employee) {

		this.employeeDao.save(employee);

		return new SuccessResult("Ürün Güncellendi.");
	}

	@Override
	public Result delete(Employee employee) {

		this.employeeDao.delete(employee);

		return new SuccessResult("Ürün Silindi.");
	}

	@Override
	public DataResult<Employee> getById(int id) {

		return new SuccessDataResult<Employee>(employeeDao.getById(id), "Ürünler Listelendi.");
	}

	@Override
	public DataResult<List<Employee>> getAll() {

		return new SuccessDataResult<List<Employee>>(employeeDao.findAll(), "Ürünler Listelendi.");
	}
}
