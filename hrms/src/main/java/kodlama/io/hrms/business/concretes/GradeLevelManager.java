package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.GradeLevelService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.GradeLevelDao;
import kodlama.io.hrms.entities.concretes.GradeLevel;

@Service
public class GradeLevelManager implements GradeLevelService {
	
	private GradeLevelDao gradeLevelDao; 

	@Autowired
	public GradeLevelManager(GradeLevelDao gradeLevelDao) {
		super();
		this.gradeLevelDao = gradeLevelDao;
	}

	@Override
	public DataResult<List<GradeLevel>> getAll() {
		return new SuccessDataResult<List<GradeLevel>>(this.gradeLevelDao.findAll());
	}

	@Override
	public Result add(GradeLevel gradeLevel) {
		this.gradeLevelDao.save(gradeLevel);
		return new SuccessResult("Okul düzeyi başarıyla eklendi");
	}

}
