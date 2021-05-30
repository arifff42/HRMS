package recapproject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import recapproject.hrms.business.abstracts.CandidateService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/employeecontroller/")
public class CandidateController {

	private CandidateService candidateService;

	public CandidateController(CandidateService candidateService) {

		this.candidateService = candidateService;
	}

	@GetMapping("getall")
	public DataResult<List<Candidate>> getAll() {

		return candidateService.getAll();
	}

	@GetMapping("getById")
	public DataResult<Candidate> getById(@RequestParam int employeeId) {

		return candidateService.getById(employeeId);
	}

	@PostMapping("add")
	public Result add(@RequestBody Candidate candidate) {
		
		return candidateService.add(candidate);
		
	}

	@PostMapping("update")
	public Result update(@RequestBody Candidate candidate) {

		return candidateService.update(candidate);
	}

	@PostMapping("delete")
	public Result delete(@RequestBody Candidate candidate) {

		return candidateService.delete(candidate);
	}
}
