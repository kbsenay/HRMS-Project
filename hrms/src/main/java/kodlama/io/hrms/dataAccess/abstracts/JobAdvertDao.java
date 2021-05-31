package kodlama.io.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	
	//@Query("From JobAdvert where isActive = true")
	List<JobAdvert> getByIsActiveTrue();
	
	//@Query("From JobAdvert where isActive = true and Order By publishedDate=: published Desc ")
	List<JobAdvert> getByIsActiveTrueOrderByPublishedDateDesc();
	
	//@Query("From JobAdvert where isActive = true and employer_id =: id")
	List<JobAdvert> getByEmployer_IdAndIsActiveTrue(int employerId);
	
	//@Query("From JobAdvert where deadline =: deadline and employerId =: employerId")
	List<JobAdvert> getByDeadline(LocalDate deadline);

	
	

}
