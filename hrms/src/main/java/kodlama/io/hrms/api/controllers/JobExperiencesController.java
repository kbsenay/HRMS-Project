package kodlama.io.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping("/app/jobexperience")
public class JobExperiencesController {
	
	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobExperience>> getAll(){
		return this.jobExperienceService.getAll();
	}
	
//	@GetMapping("/getById")
//	public DataResult<JobExperience> getById(@RequestParam int id) {
//		return this.jobExperienceService.getById(id);
//	}
//	
//	@GetMapping("/getAllByCandidate_idOrderByEndingDateDesc")
//	public DataResult<List<JobExperience>>getAllByCandidate_idOrderByEndingDateDesc(@RequestParam int id) {
//		return this.jobExperienceService.getAllByCandidate_idOrderByEndingDateDesc(id);
//	}
//	
//	@GetMapping("/getAllByCandidate_id")
//	public DataResult<List<JobExperience>> getAllByCandidate_id(@RequestParam int id) {
//		return this.jobExperienceService.getAllByCandidate_id(id);
//	}
//	
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobExperience jobExperience){
		return this.jobExperienceService.add(jobExperience);
	}

}

