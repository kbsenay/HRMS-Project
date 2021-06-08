package kodlama.io.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.ProgrammingSkillService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.ProgrammingSkill;

@RestController
@RequestMapping("/app/programmingSkill")
public class ProgrammingSkillsController {
	
	private ProgrammingSkillService programmingSkillService;

	@Autowired
	public ProgrammingSkillsController( ProgrammingSkillService programmingSkillService) {
		super();
		this.programmingSkillService = programmingSkillService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ProgrammingSkill>> getAll(){
		return this.programmingSkillService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody ProgrammingSkill programmingSkill){
		return this.programmingSkillService.add(programmingSkill);
	}

}

