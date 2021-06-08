package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.GradeLevel;

public interface GradeLevelDao extends JpaRepository<GradeLevel, Integer>{
	List<GradeLevel> findAll();

}
