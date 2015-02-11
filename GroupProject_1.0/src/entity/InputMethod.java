package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({@NamedQuery(name="InputMethod.getAll",query="select i from InputMethod i"),
			   @NamedQuery(name="InputMethod.findId,",query="select i from InputMethod i where i.inputMethod=:inputMethod"),
})
@Entity
public class InputMethod {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int inputMethodId;
	
	@Lob
	@Column(columnDefinition="VARCHAR(255)")
	private String inputMethod;
	
	public InputMethod() {
		// TODO Auto-generated constructor stub
	}

	public InputMethod(String inputMethod) {
		super();
		this.inputMethod = inputMethod;
	}

	public int getInputMethodId() {
		return inputMethodId;
	}

	public void setInputMethodId(int inputMethodId) {
		this.inputMethodId = inputMethodId;
	}

	public String getInputMethod() {
		return inputMethod;
	}

	public void setInputMethod(String inputMethod) {
		this.inputMethod = inputMethod;
	}
	

}
