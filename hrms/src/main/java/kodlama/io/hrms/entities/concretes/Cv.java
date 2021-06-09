package kodlama.io.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="cvs")
public class Cv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = Candidate.class)
    @JoinColumn(name = "candidate_id", referencedColumnName = "user_id", nullable = false)
    private Candidate candidate;
	
	@Column(name="photo_url")
	private String protoUrl;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedin_link")
	private String linkedinLink;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@Column(name="is_active")
	private boolean isActive = true;
	
	@Column(name="is_deleted")
	private boolean isDeleted = false;
	
	@Column(name="latest_update")
	private Date latestUpdate;
	
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@OneToMany(mappedBy = "cv")
	private List<Language> languages;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@OneToMany(mappedBy = "cv")
	private List<ProgrammingSkill> programmingSkills;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@OneToMany(mappedBy = "cv")
	private List<School> schools;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@OneToMany(mappedBy = "cv")
	private List<JobExperience> jobExperiences;
	

}
