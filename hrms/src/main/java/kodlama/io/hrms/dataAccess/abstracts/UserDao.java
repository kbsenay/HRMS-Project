package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.abstracts.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);

}
