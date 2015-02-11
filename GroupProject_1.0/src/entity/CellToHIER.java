package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CellToHIER {
	
	@Id
	private int cellId;
	private long HIER3Id;
	private long HIER32Id;
	private long HIER321Id;
	
	public CellToHIER() {
		// TODO Auto-generated constructor stub
	}

	public CellToHIER(int cellId, long hIER3Id, long hIER32Id, long hIER321Id) {
		super();
		this.cellId = cellId;
		HIER3Id = hIER3Id;
		HIER32Id = hIER32Id;
		HIER321Id = hIER321Id;
	}

	public int getCellId() {
		return cellId;
	}

	public void setCellId(int cellId) {
		this.cellId = cellId;
	}

	public long getHIER3Id() {
		return HIER3Id;
	}

	public void setHIER3Id(long hIER3Id) {
		HIER3Id = hIER3Id;
	}

	public long getHIER32Id() {
		return HIER32Id;
	}

	public void setHIER32Id(long hIER32Id) {
		HIER32Id = hIER32Id;
	}

	public long getHIER321Id() {
		return HIER321Id;
	}

	public void setHIER321Id(long hIER321Id) {
		HIER321Id = hIER321Id;
	}
	
	

}
