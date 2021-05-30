package kodlama.io.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	
	@Query("From JobAdvert where isActive = true")
	List<JobAdvert> getAllByIsActiveTrue(boolean isActive);
	
	@Query("From JobAdvert where isActive = true and Order By publishedAt Desc ")
	List<JobAdvert> getAllByIsActiveTrueAndPublishedAtDesc(boolean isActive, LocalDate publishedAt);
	
	@Query("From JobAdvert where isActive = true and employer_id =: id")
	List<JobAdvert> getActiveJobAdvertByEmployer(boolean isActive, int employerId);
	
	@Query("From JobAdvert where deadline =: deadline and employerId =: employerId")
	List<JobAdvert> getAllByDeadline(LocalDate deadline);

	
	

}
