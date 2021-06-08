package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.SchoolService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.SchoolDao;
import kodlama.io.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {
	
	private SchoolDao schoolDao;

	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
	}
	
//	@Override
//	public DataResult<School> getById(int id) {
//		return new SuccessDataResult<School>(this.schoolDao.findById(id));
//	}
//
//	@Override
//	public DataResult<List<School>> getAllByCandidateIdOrderByGraduationDateDesc(int id) {
//		if (CheckGraduationDate(null)) {
//			return new SuccessDataResult<List<School>>(this.schoolDao.findAllByCandidate_idOrderByGraduationDateDesc(id));
//		}
//		return this.getAllByCandidateIdOrderByGraduationDateDesc(id);
//	}
//
//	@Override
//	public DataResult<List<School>> getAllByCandidateId(int id) {
//		return new SuccessDataResult<List<School>>(this.schoolDao.findAllByCandidate_id(id));
//	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul bilgisi başarıyla eklendi."); 
	}
	
//	private boolean CheckGraduationDate(School school) {
//		if (school.getGraduationDate() == null) {
//			System.out.println("Devam ediyor");
//		}
//		return true;
//	}

	

}
