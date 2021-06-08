package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{
//	School findById(int id);
//	List<School> findAllByCandidate_idOrderByGraduationDateDesc(int id);
//	List<School> findAllByCandidate_id(int id);
//
}
