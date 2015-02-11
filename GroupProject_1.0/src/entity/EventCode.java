package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class EventCode {
	@Id
	private int eventCauseId;
	
	@Lob
	@Column(columnDefinition="VARCHAR(255)")
	private String description;
	
	public EventCode() {
		
	}
	

	public EventCode(int eventCauseId, String description) {
		super();
		this.eventCauseId = eventCauseId;
		this.description = description;
	}


	public int getEventCauseId() {
		return eventCauseId;
	}

	public void setEventCauseId(int eventCauseId) {
		this.eventCauseId = eventCauseId;
	}

}
