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
	public DataResult<List<JobAdvert>> getAllByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByIsActiveTrue(), "Tüm güncel iş ilânları listelendi!");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByIsActiveTrueAndPublishedAtDesc() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByIsActiveTrueOrderByPublishedDateDesc(), "Son yayımlanan güncel iş ilânları listelendi!");
	}

	@Override
	public DataResult<List<JobAdvert>> getActiveJobAdvertByEmployer(int employerId) {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByEmployer_IdAndIsActiveTrue(employerId), "Firmanın güncel ilânları listelendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByDeadline(LocalDate deadline) {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByDeadline(deadline));
	}

}
