package recapproject.hrms.business.abstracts;

import java.util.List;

import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.Employee;

public interface EmployeeService {
	
	Result add(Employee employee);
	
	Result update(Employee employee);
	
	Result delete(Employee employee);
	
	DataResult<List<Employee>> getAll();
	
	DataResult<Employee> findById(int id);

}
