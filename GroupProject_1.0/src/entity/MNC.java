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

@NamedQueries({@NamedQuery(name="MNC.getAll",query="select m from MNC m"),
			   @NamedQuery(name="MNC.findMNCId",query="select m from MNC m where m.operator=:operator")})

@Entity
public class MNC {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mncPK;
	
	private int mncId;
	//@OneToOne(targetEntity=MCC.class)
	private int mccId;
	@Lob
	@Column
	private String operator;

	public MNC() {
		// TODO Auto-generated constructor stub
	}

	public MNC(int mncId, int mccId, String operator) {
		super();
		this.mncId = mncId;
		this.mccId = mccId;
		this.operator = operator;
	}

	public int getMncId() {
		return mncId;
	}

	public void setMncId(int mncId) {
		this.mncId = mncId;
	}

	public int getMccId() {
		return mccId;
	}

	public void setMccId(int mccId) {
		this.mccId = mccId;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getMncPK() {
		return mncPK;
	}

	public void setMncPK(int mncPK) {
		this.mncPK = mncPK;
	}
	
	

}
