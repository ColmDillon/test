package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries({@NamedQuery(name="UEType.getAll",query="select t from UEType t"),
			   @NamedQuery(name="UEType.findId",query="select t from UEType t where t.ueType=:ueType"),})

@Entity
public class UEType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ueId;
	
	@Lob
	@Column(columnDefinition="VARCHAR(255)")
	private String ueType;
	
	
	public UEType() {
		// TODO Auto-generated constructor stub
	}


	public UEType(String ueType) {
		super();
		this.ueType = ueType;
	}


	public int getUeId() {
		return ueId;
	}


	public void setUeId(int ueId) {
		this.ueId = ueId;
	}


	public String getUeType() {
		return ueType;
	}


	public void setUeType(String ueType) {
		this.ueType = ueType;
	}
	
	

}
