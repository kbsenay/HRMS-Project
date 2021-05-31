package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.findAll(), "İş pozisyonları listelendi");
	}
	
	@Override
	public DataResult<JobPosition> findByPositionIs(String position) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByPositionIs(position));
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if (findByPositionIs(jobPosition.getPosition()) !=null) {
			return new ErrorResult(jobPosition.getPosition() + " zaten var!");
		}else {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("İş pozisyonu eklendi!");
		}
		
	}

	@Override
	public Result update(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu güncellendi");
	}

	@Override
	public Result delete(JobPosition jobPosition) {
		this.jobPositionDao.deleteById(jobPosition.getId());
		return new SuccessResult("İş pozisyonu silindi");
	}

	
	
	

}
