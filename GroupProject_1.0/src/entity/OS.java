package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({@NamedQuery(name="OS.getAll",query="select o from OS o"),
			   @NamedQuery(name="OS.findID",query="select o from OS o where o.OSname=:OSname")})


@Entity
public class OS {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int OSid;
	
	private String OSname;
	
	
	
	public OS() {
		// TODO Auto-generated constructor stub
	}
	
	public OS(String OSname){
		this.OSname = OSname;
	}

	public int getOSid() {
		return OSid;
	}

	public void setOSid(int oSid) {
		OSid = oSid;
	}

	public String getOSName() {
		return OSname;
	}

	public void setOSName(String OSname) {
		this.OSname = OSname;
	}
	

}
