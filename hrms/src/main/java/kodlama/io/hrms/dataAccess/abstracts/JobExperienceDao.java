package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {
//	JobExperience findById(int id);
//	List<JobExperience> findAllByCandidate_IdOrderByEndingDateDesc(int id);
//	List<JobExperience> findAllByCandidate_Id(int id);
}
