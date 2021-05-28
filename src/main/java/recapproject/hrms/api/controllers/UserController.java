package recapproject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import recapproject.hrms.business.abstracts.UserService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/user/")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {

		this.userService = userService;
	}

	@GetMapping("getall")
	public DataResult<List<User>> getAll() {

		return userService.getAll();
	};

	@GetMapping("getById")
	public DataResult<User> getById(@RequestParam int userId) {

		return userService.getById(userId);
	}

	@PostMapping("add")
	public Result add(@RequestBody User user) {

		return userService.add(user);
	}

	@PostMapping("update")
	public Result update(@RequestBody User user) {

		return userService.update(user);
	}

	@PostMapping("delete")
	public Result delete(@RequestBody User user) {

		return userService.delete(user);
	}
}
