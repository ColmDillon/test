package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class EventCause {
	
	private int causeCode;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eventCauseId;
	
	public EventCause() {
		// TODO Auto-generated constructor stub
	}
	
	public EventCause(int causeCode) {
		super();
		this.causeCode = causeCode;
	}

	public int getCauseCode() {
		return causeCode;
	}



	public void setCauseCode(int causeCode) {
		this.causeCode = causeCode;
	}



	public int getEventCauseId() {
		return eventCauseId;
	}



	public void setEventCauseId(int eventCauseId) {
		this.eventCauseId = eventCauseId;
	}
	
	
}
