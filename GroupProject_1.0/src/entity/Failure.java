package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Failure {
	
	@Id
	private int failureId;
	
	@Lob
	@Column(columnDefinition="VARCHAR(255)")
	private String description;
	
	public Failure() {
		// TODO Auto-generated constructor stub
	}

	public Failure(int failureId, String description) {
		super();
		this.failureId = failureId;
		this.description = description;
	}

	public int getFailureId() {
		return failureId;
	}

	public void setFailureId(int failureId) {
		this.failureId = failureId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
