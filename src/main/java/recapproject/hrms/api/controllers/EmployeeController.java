package recapproject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import recapproject.hrms.business.abstracts.EmployeeService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employeecontroller/")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {

		this.employeeService = employeeService;
	}

	@GetMapping("getall")
	public DataResult<List<Employee>> getAll() {

		return employeeService.getAll();
	}

	@GetMapping("getById")
	public DataResult<Employee> getById(@RequestParam int employeeId) {

		return employeeService.getById(employeeId);
	}

	@PostMapping("add")
	public Result add(@RequestBody Employee employee) {
		
		return employeeService.add(employee);
		
	}

	@PostMapping("update")
	public Result update(@RequestBody Employee employee) {

		return employeeService.update(employee);
	}

	@PostMapping("delete")
	public Result delete(@RequestBody Employee employee) {

		return employeeService.delete(employee);
	}
}
