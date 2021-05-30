package kodlama.io.hrms.entities.abstracts;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="created_at", columnDefinition ="Date default CURRENT_Date")
	private LocalDate createdAt = LocalDate.now();
	
	@Column(name="is_deleted", columnDefinition ="boolean default true")
	private boolean isDeleted;
	
	@Column(name="is_active", columnDefinition ="boolean default true")
	private boolean isActive = true;
	
	

}
