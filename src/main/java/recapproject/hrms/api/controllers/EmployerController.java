package recapproject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import recapproject.hrms.business.abstracts.EmployerService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employercontroller/")
public class EmployerController {

	private final EmployerService employerService;

	public EmployerController(EmployerService employerService) {

		this.employerService = employerService;
	}

	@GetMapping("getall")
	public DataResult<List<Employer>> getAll() {

		return employerService.getAll();
	}

	@GetMapping("getById")
	public DataResult<Employer> getById(@RequestParam int employerId) {

		return employerService.getById(employerId);
	}

	@PostMapping("add")
	public Result add(@RequestBody Employer employer) {

		return employerService.add(employer);
	}

	@PostMapping("update")
	public Result update(@RequestBody Employer employer) {

		return employerService.update(employer);
	}

	@PostMapping("delete")
	public Result delete(@RequestBody Employer employer) {

		return employerService.delete(employer);
	}
}
