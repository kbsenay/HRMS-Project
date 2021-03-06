package kodlama.io.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.JobAdvertService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvert;


@RestController
@RequestMapping("/app/jobadvert")
@CrossOrigin
public class JobAdvertsController {
	
	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("getByJobAdvertId")
    public DataResult<JobAdvert> getByJobAdvertId(@RequestParam int id){
		return this.jobAdvertService.getByJobAdvertId(id);}
	
	@GetMapping("/getAllByIsActiveTrue")
	public DataResult<List<JobAdvert>>getAllByIsActiveTrue(){
		return this.jobAdvertService.getAllByIsActiveTrue();
	}
	
	@GetMapping("/getAllByIsActiveTrueAndPublishedAtDesc")
	public DataResult<List<JobAdvert>> getAllByIsActiveTrueAndPublishedAtDesc(){
		return this.jobAdvertService.getAllByIsActiveTrueAndPublishedAtDesc();
	}
	
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobAdvert jobAdvert){
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@PostMapping("/uploadImage")
	public Result saveImage(@RequestBody MultipartFile file, @RequestParam int jobAdvertId) {
		return this.jobAdvertService.saveImage(file, jobAdvertId);
	}

}

