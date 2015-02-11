package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IMSI {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int imsiId;
	
	private long imsi;
	
	
	public IMSI() {
		// TODO Auto-generated constructor stub
	}


	public IMSI(int imsiId, long imsi) {
		super();
		this.imsiId = imsiId;
		this.imsi = imsi;
	}


	public int getImsiId() {
		return imsiId;
	}


	public void setImsiId(int imsiId) {
		this.imsiId = imsiId;
	}


	public long getImsi() {
		return imsi;
	}


	public void setImsi(long imsi) {
		this.imsi = imsi;
	}
	
	

}
