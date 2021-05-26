package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName="id")
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User {
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name="user_id") private int id;
	 */
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String LastName;
	@Column(name="identity_number")
	private String identityNumber;
	@Column(name="birth_year")
	private LocalDate birthYear;
	@Column(name="is_active", columnDefinition ="boolean default false")
	private Boolean isActive = false;

}
