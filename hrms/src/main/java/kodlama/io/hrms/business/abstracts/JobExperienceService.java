package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
	DataResult<List<JobExperience>> getAll();
	//DataResult<JobExperience> getById(int id);
	//DataResult<List<JobExperience>> getAllByCandidate_idOrderByEndingDateDesc(int id);
	//DataResult<List<JobExperience>> getAllByCandidate_id(int id);
	
	Result add(JobExperience jobExperince);
}
