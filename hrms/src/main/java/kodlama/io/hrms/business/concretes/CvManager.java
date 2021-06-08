package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvDao;
import kodlama.io.hrms.entities.concretes.Cv;

@Service
public class CvManager implements CvService {
	private CvDao cvdao;

	@Autowired
	public CvManager(CvDao cvdao) {
		super();
		this.cvdao = cvdao;
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvdao.findAll(), "Tüm cvler getirildi.");
	}

	@Override
	public Result add(Cv cv) {
		this.cvdao.save(cv);
		return new SuccessResult("Cv kaydı başarıyla gerçekleşti.");
	}

}
