package recapproject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import recapproject.hrms.business.abstracts.UserActivationByAdminUserService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.UserActivationByAdminUser;

@RestController
@RequestMapping("/api/useractivationbyadminusercontroller/")
public class UserActivationByAdminUserController {

	private final UserActivationByAdminUserService userActivationByAdminUserService;

	public UserActivationByAdminUserController(UserActivationByAdminUserService userActivationByAdminUserService) {

		this.userActivationByAdminUserService = userActivationByAdminUserService;
	}

	@GetMapping("getall")
	public DataResult<List<UserActivationByAdminUser>> getAll() {

		return userActivationByAdminUserService.getAll();
	}

	@GetMapping("getById")
	public DataResult<UserActivationByAdminUser> getById(@RequestParam int userActivationByAdminUserId) {

		return userActivationByAdminUserService.getById(userActivationByAdminUserId);
	}

	@PostMapping("add")
	public Result add(@RequestBody UserActivationByAdminUser userActivationByAdminUser) {

		return userActivationByAdminUserService.add(userActivationByAdminUser);
	}

	@PostMapping("update")
	public Result update(@RequestBody UserActivationByAdminUser userActivationByAdminUser) {

		return userActivationByAdminUserService.update(userActivationByAdminUser);
	}

	@PostMapping("delete")
	public Result delete(@RequestBody UserActivationByAdminUser userActivationByAdminUser) {

		return userActivationByAdminUserService.delete(userActivationByAdminUser);
	}
}
