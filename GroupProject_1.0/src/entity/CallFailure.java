package entity;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CallFailure {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int callFialureID;
	
	private Time timestamp;
	
	private int duration;
	
	private int IMSI_Id;
	
	private int cause_Id;
	
	private int failure_Id;
	
	private int cell_Id;
	
	private int TAC_Id;
	
	private int market_Id;
	
	
	public CallFailure() {
		// TODO Auto-generated constructor stub
	}


	public CallFailure(Time timestamp, int duration, int iMSI_Id,
			int cause_Id, int failure_Id, int cell_Id, int tAC_Id, int market_Id) {
		super();
		this.timestamp = timestamp;
		this.duration = duration;
		IMSI_Id = iMSI_Id;
		this.cause_Id = cause_Id;
		this.failure_Id = failure_Id;
		this.cell_Id = cell_Id;
		TAC_Id = tAC_Id;
		this.market_Id = market_Id;
	}


	public int getCallFialureID() {
		return callFialureID;
	}


	public void setCallFialureID(int callFialureID) {
		this.callFialureID = callFialureID;
	}


	public Time getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Time timestamp) {
		this.timestamp = timestamp;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public int getIMSI_Id() {
		return IMSI_Id;
	}


	public void setIMSI_Id(int iMSI_Id) {
		IMSI_Id = iMSI_Id;
	}


	public int getCause_Id() {
		return cause_Id;
	}


	public void setCause_Id(int cause_Id) {
		this.cause_Id = cause_Id;
	}


	public int getFailure_Id() {
		return failure_Id;
	}


	public void setFailure_Id(int failure_Id) {
		this.failure_Id = failure_Id;
	}


	public int getCell_Id() {
		return cell_Id;
	}


	public void setCell_Id(int cell_Id) {
		this.cell_Id = cell_Id;
	}


	public int getTAC_Id() {
		return TAC_Id;
	}


	public void setTAC_Id(int tAC_Id) {
		TAC_Id = tAC_Id;
	}


	public int getMarket_Id() {
		return market_Id;
	}


	public void setMarket_Id(int market_Id) {
		this.market_Id = market_Id;
	}
	
	

}
