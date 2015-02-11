package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ForeignKey;

@NamedQueries({@NamedQuery(name="UECapabilityLookup.getAll",query="select o from UECapabilityLookup o"),
	
})

@Entity
public class UECapabilityLookup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ueCapabilityId;
	
	private int tacId;

	private int capabilityId;
	
	
	
	public UECapabilityLookup(int tacId) {
		super();
		this.tacId = tacId;
	}



	public UECapabilityLookup() {
		// TODO Auto-generated constructor stub
	}


	
	public int getTacId() {
		return tacId;
	}



	public void setTacId(int tacId) {
		this.tacId = tacId;
	}


	
	public int getCapabilityId() {
		return capabilityId;
	}



	public void setCapabilityId(int capabilityId) {
		this.capabilityId = capabilityId;
	}



	public int getUeCapabilityId() {
		return ueCapabilityId;
	}



	public void setUeCapabilityId(int ueCapabilityId) {
		this.ueCapabilityId = ueCapabilityId;
	}
	
	

}
