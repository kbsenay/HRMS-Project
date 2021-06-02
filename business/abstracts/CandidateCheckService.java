package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.entities.concretes.Candidate;


public interface CandidateCheckService {
	boolean checkIfRealPerson(Candidate candidate);
	

}
