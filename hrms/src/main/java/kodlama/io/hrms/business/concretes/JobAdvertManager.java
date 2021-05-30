package kodlama.io.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertDao;

import kodlama.io.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {
	
	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Yeni iş ilânı eklendi!");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByIsActiveTrue(boolean isActive) {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getAllByIsActiveTrue(isActive), "Tüm güncel iş ilânları listelendi!");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByIsActiveTrueAndPublishedAtDesc(boolean isActive, LocalDate publishedAt) {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getAllByIsActiveTrueAndPublishedAtDesc(isActive, publishedAt), "Son yayımlanan güncel iş ilânları listelendi!");
	}

	@Override
	public DataResult<List<JobAdvert>> getActiveJobAdvertByEmployer(boolean isActive, int employerId) {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getActiveJobAdvertByEmployer(isActive, employerId), "Firmanın güncel ilânları listelendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByDeadline(LocalDate deadline) {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getAllByDeadline(deadline));
	}

}
