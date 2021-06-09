package kodlama.io.hrms.entities.dtos;

import java.util.List;

import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.JobExperience;
import kodlama.io.hrms.entities.concretes.Language;
import kodlama.io.hrms.entities.concretes.ProgrammingSkill;
import kodlama.io.hrms.entities.concretes.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	private Candidate candidate;
	
	private List<School> schools;
	
	private List<JobExperience> jobExperinces;
	
	private List<ProgrammingSkill> programmingskills;
	
	private List<Language> languages;
	
	private String photo;

}
