package recapproject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import recapproject.hrms.business.abstracts.JobTitleService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitlesController {

	private JobTitleService jobTitleService;

	public JobTitlesController(JobTitleService jobTitleService) {

		this.jobTitleService = jobTitleService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll() {

		return jobTitleService.getAll();
	};
}
