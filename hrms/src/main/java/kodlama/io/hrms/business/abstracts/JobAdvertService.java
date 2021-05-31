package kodlama.io.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	
	Result add(JobAdvert jobAdvert);
	
	
	DataResult<List<JobAdvert>> getAllByIsActiveTrue();
	
	
	DataResult<List<JobAdvert>> getAllByIsActiveTrueAndPublishedAtDesc();
	
	
	DataResult<List<JobAdvert>> getActiveJobAdvertByEmployer(int employerId);
	
	
	DataResult<List<JobAdvert>> getAllByDeadline(LocalDate deadline);

}
