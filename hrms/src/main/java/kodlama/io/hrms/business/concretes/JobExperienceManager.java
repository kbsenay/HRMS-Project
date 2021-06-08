package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlama.io.hrms.entities.concretes.JobExperience;
import kodlama.io.hrms.entities.concretes.School;

@Service
public class JobExperienceManager implements JobExperienceService{
	
	private JobExperienceDao jobExperienceDao;

	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(), "İş deneyimleri listelendi.");
	}
	
//	@Override
//	public DataResult<JobExperience> getById(int id) {
//		return new SuccessDataResult<JobExperience>(this.jobExperienceDao.findById(id));
	//}

//	@Override
//	public DataResult<List<JobExperience>> getAllByCandidate_idOrderByEndingDateDesc(int id) {
//		if (CheckEndingDate(null)) {
//			return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAllByCandidate_idOrderByEndingDateDesc(id));
//		}
//		return this.getAllByCandidate_idOrderByEndingDateDesc(id);
//	}

//	@Override
//	public DataResult<List<JobExperience>> getAllByCandidate_id(int id) {
//		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAllByCandidate_id(id));
//	}

	@Override
	public Result add(JobExperience jobExperince) {
		this.jobExperienceDao.save(jobExperince);
		return new SuccessResult("İş deneyimi başarıyla eklendi");
	}
	
//	private boolean CheckEndingDate(JobExperience jobExperience) {
//		if (jobExperience.getEndingDate() == null) {
//			System.out.println("Devam ediyor");
//		}
//		return true;
//	}

	

}
