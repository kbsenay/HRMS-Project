package kodlama.io.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.GradeLevelService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.GradeLevel;

@RestController
@RequestMapping("/app/gradelevel")
public class GradeLevelsController {
	
	private GradeLevelService gradeLevelService;

	@Autowired
	public GradeLevelsController(GradeLevelService gradeLevelService) {
		super();
		this.gradeLevelService = gradeLevelService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<GradeLevel>> getAll(){
		return this.gradeLevelService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody GradeLevel gradeLevel){
		return this.gradeLevelService.add(gradeLevel);
	}

}

