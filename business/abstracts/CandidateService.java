package kodlama.io.hrms.business.abstracts;

import java.util.List;



import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidate;

public interface CandidateService  {
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getByIdentityNumber(String identityNumber);
	
	Result add(Candidate candidate);

}
