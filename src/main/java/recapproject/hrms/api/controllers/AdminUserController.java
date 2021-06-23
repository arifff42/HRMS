package recapproject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import recapproject.hrms.business.abstracts.AdminUserService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.AdminUser;

@RestController
@RequestMapping("/api/adminusercontroller/")
public class AdminUserController {

	private final AdminUserService adminUserService;

	public AdminUserController(AdminUserService adminUserService) {

		this.adminUserService = adminUserService;
	}

	@GetMapping("getall")
	public DataResult<List<AdminUser>> getAll() {

		return adminUserService.getAll();
	}

	@GetMapping("getById")
	public DataResult<AdminUser> getById(@RequestParam int adminUserId) {

		return adminUserService.getById(adminUserId);
	}

	@PostMapping("add")
	public Result add(@RequestBody AdminUser adminUser) {

		return adminUserService.add(adminUser);
	}

	@PostMapping("update")
	public Result update(@RequestBody AdminUser adminUser) {

		return adminUserService.update(adminUser);
	}

	@PostMapping("delete")
	public Result delete(@RequestBody AdminUser adminUser) {

		return adminUserService.delete(adminUser);
	}
}
