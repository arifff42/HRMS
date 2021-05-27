package recapproject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import recapproject.hrms.business.abstracts.UserActivationService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.UserActivation;

@RestController
@RequestMapping("/api/useractivation/")
public class UserActivationController {

	private UserActivationService userActivationService;

	public UserActivationController(UserActivationService userActivationService) {

		this.userActivationService = userActivationService;
	}

	@GetMapping("getall")
	public DataResult<List<UserActivation>> getAll() {

		return userActivationService.getAll();
	};

	@GetMapping("getById")
	public DataResult<UserActivation> getById(int userActivationId) {

		return userActivationService.getById(userActivationId);
	}

	@PostMapping("add")
	public Result add(@RequestBody UserActivation userActivation) {

		return userActivationService.add(userActivation);
	}

	@PostMapping("update")
	public Result update(@RequestBody UserActivation userActivation) {

		return userActivationService.update(userActivation);
	}

	@PostMapping("delete")
	public Result delete(@RequestBody UserActivation userActivation) {

		return userActivationService.delete(userActivation);
	}
}
