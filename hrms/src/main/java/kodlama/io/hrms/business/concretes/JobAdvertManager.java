package kodlama.io.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.JobAdvertService;
import kodlama.io.hrms.core.utilities.imageUpload.ImageUploadService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertDao;

import kodlama.io.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {
	
	private JobAdvertDao jobAdvertDao;
	private ImageUploadService imageUploadService;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, ImageUploadService imageUploadService) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.imageUploadService = imageUploadService;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Yeni iş ilânı eklendi!");
	}
	
	@Override
	public Result saveImage(MultipartFile file, int jobAdvertId) {
		try {
			Map<String, String> uploader = (Map<String, String>) imageUploadService.uploadImageFile(file).getData();
            String imageUrl= uploader.get("url");
            JobAdvert jobAdvert = jobAdvertDao.getOne(jobAdvertId);
            jobAdvert.setPhoto(imageUrl);
            jobAdvertDao.save(jobAdvert);
			
		} catch (Exception e) {
			return new ErrorResult("Geçersiz İçerik !");
		}
		return new SuccessResult("Fotoğraf eklendi");
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

	@Override
	public DataResult<JobAdvert> getByJobAdvertId(int jobAdvertId) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.findAllByIdAndIsActiveTrue(jobAdvertId),"Id ye Göre Başarıyla Getirildi.");
	}

	

}
