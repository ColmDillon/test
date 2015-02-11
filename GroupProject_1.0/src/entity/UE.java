package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class UE {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ueId;
	
	private int tacId;
	@Lob
	@Column(columnDefinition="VARCHAR(255)")
	private String marketingName;
	@Lob
	@Column(columnDefinition="VARCHAR(255)")
	private String model;
	@OneToOne(targetEntity=OS.class)
	private int osId;
	@OneToOne(targetEntity=UEVendor.class)
	private int vendorId;
	@OneToOne(targetEntity=InputMethod.class)
	private int inputMethodId;
	
	public UE() {
		// TODO Auto-generated constructor stub
	}

	public UE(int tacId, String marketingName, String model, int osId,
			int vendorId, int ueId, int inputMethodId) {
		super();
		this.tacId = tacId;
		this.marketingName = marketingName;
		this.model = model;
		this.osId = osId;
		this.vendorId = vendorId;
		this.ueId = ueId;
		this.inputMethodId = inputMethodId;
	}

	public int getTacId() {
		return tacId;
	}

	public void setTacId(int tacId) {
		this.tacId = tacId;
	}

	public String getMarketingName() {
		return marketingName;
	}

	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getOsId() {
		return osId;
	}

	public void setOsId(int osId) {
		this.osId = osId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getUeId() {
		return ueId;
	}

	public void setUeId(int ueId) {
		this.ueId = ueId;
	}

	public int getInputMethodId() {
		return inputMethodId;
	}

	public void setInputMethodId(int inputMethodId) {
		this.inputMethodId = inputMethodId;
	}
	
	
	

}
