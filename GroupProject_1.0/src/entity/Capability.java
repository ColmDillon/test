package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="Capability.getAllCapabilities", query = "select o from Capability o"),
	@NamedQuery(name="Capability.findCapabilityById",query = "select o from Capability o where o.capability=:capability"),
})
@Entity
public class Capability {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int capabilityId;
	
	@Lob
	@Column(columnDefinition="VARCHAR(255)")
	private String capability;
	
	public Capability() {
		// TODO Auto-generated constructor stub
	}
	
	public Capability(String capability){
		this.capability=capability;
	}

	public int getCapability_id() {
		return capabilityId;
	}

	public void setCapability_id(int capabilityId) {
		this.capabilityId = capabilityId;
	}

	public String getCapability() {
		return capability;
	}

	public void setCapability(String capability) {
		this.capability = capability;
	}
	
}
