package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({@NamedQuery(name="MCC.getAll",query="select m from MCC m"),
			   @NamedQuery(name="MCC.findId",query="select m from MCC m where m.country=:country"),
			   })

@Entity
public class MCC {
	
	@Id
	private int mmcId;
	
	@Lob
	@Column(columnDefinition="VARCHAR(255)")
	private String country;
	
	
	public MCC() {
		// TODO Auto-generated constructor stub
	}


	public MCC(int mmcId, String country) {
		super();
		this.mmcId = mmcId;
		this.country = country;
	}


	public int getMmcId() {
		return mmcId;
	}


	public void setMmcId(int mmcId) {
		this.mmcId = mmcId;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}
	
    

}
