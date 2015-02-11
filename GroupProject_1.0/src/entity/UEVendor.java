package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries({@NamedQuery(name="UEVendor.getAll",query="select v from UEVendor v"),
			   @NamedQuery(name="UEVendor.findId",query="select v from UEVendor v where v.manufacturer=:manufacturer"),
})


@Entity
public class UEVendor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vendorId;
	
	@Lob
	@Column(columnDefinition="VARCHAR(255)")
	private String manufacturer;
	
	
	public UEVendor() {
		// TODO Auto-generated constructor stub
	}


	public UEVendor(String manufacturer) {
		super();
		this.manufacturer = manufacturer;
	}


	public int getVendorId() {
		return vendorId;
	}


	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	

}
