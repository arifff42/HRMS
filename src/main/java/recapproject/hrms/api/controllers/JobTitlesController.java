package recapproject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import recapproject.hrms.business.abstracts.JobTitleService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles/")
public class JobTitlesController {

	private JobTitleService jobTitleService;

	public JobTitlesController(JobTitleService jobTitleService) {

		this.jobTitleService = jobTitleService;
	}

	@GetMapping("getall")
	public DataResult<List<JobTitle>> getAll() {

		return jobTitleService.getAll();
	};

	@GetMapping("getById")
	public DataResult<JobTitle> getById(int jobTitleId){
		
		return jobTitleService.getById(jobTitleId);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody JobTitle jobTitle) {

		return jobTitleService.add(jobTitle);
	}

	@PostMapping("update")
	public Result update(@RequestBody JobTitle jobTitle) {
		
		return jobTitleService.update(jobTitle);
	}

	@PostMapping("delete")
	public Result delete(@RequestBody JobTitle jobTitle) {
		
		return jobTitleService.delete(jobTitle);
	}
}
