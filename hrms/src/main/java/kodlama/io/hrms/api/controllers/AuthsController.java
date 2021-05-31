package kodlama.io.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.AuthService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auth")
public class AuthsController {
	
	private AuthService authService;

	@Autowired
	public AuthsController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	public Result registerEmployer(@RequestBody Employer employer, String confirmPassword) {
		return  authService.registerEmployer(employer, confirmPassword);
	}
	
	public Result registerCandidate(@RequestBody Candidate candidate, String confirmPassword) {
		return  authService.registerCandidate(candidate, confirmPassword);
	}

}
