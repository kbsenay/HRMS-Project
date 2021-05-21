package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="job_positions")
public class JobPosition {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="position")
	private String position;
	
	public JobPosition() {
		
	}
	
	public JobPosition(int id, String position) {
		super();
		this.id = id;
		this.position = position;
	}
	
	

}
