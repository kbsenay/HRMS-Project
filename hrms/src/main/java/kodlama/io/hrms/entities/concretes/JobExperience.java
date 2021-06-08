package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_experiences")
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Cv.class)
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="starting_date")
	private LocalDate startingDate;
	
	@Column(name="ending_date")
	private LocalDate endingDate;
	
	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@Column(name="is_active")
	private boolean isActive = true;
	
	@Column(name="is_deleted")
	private boolean isDeleted = false;
	

}
