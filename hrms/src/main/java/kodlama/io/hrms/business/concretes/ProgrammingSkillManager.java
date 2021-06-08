package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.ProgrammingSkillService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ProgrammingSkillDao;
import kodlama.io.hrms.entities.concretes.ProgrammingSkill;

@Service
public class ProgrammingSkillManager implements ProgrammingSkillService {
	
	private ProgrammingSkillDao programmingSkillDao;

	@Autowired
	public ProgrammingSkillManager(ProgrammingSkillDao programmingSkillDao) {
		super();
		this.programmingSkillDao = programmingSkillDao;
	}

	@Override
	public DataResult<List<ProgrammingSkill>> getAll() {
		return new SuccessDataResult<List<ProgrammingSkill>>(this.programmingSkillDao.findAll());
	}

	@Override
	public Result add(ProgrammingSkill programmingSkill) {
		this.programmingSkillDao.save(programmingSkill);
		return new SuccessResult("Programlama yeteneği başarıyla eklendi");
	}

}
