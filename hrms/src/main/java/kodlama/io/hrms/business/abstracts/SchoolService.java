package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.School;

public interface SchoolService {
	DataResult<List<School>> getAll();
//	DataResult<School> getById(int id);
//	DataResult<List<School>> getAllByCandidateIdOrderByGraduationDateDesc(int id);
//	DataResult<List<School>> getAllByCandidateId(int id);
	
	Result add(School school);
}
