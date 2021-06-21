package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
	City findAllById(int id);
	List<City> findAll();

}
