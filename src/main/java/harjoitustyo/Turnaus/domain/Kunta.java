package harjoitustyo.Turnaus.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class Kunta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long kunta_id;
	
	@Column (name="kunnannimi")
	private String kunnannimi;
		
	@OneToMany(cascade = CascadeType.ALL, mappedBy="kunta")
	@JsonIgnore
	private List<Seura> seurat;

	public Kunta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kunta(String kunnannimi) {
		super();
		this.kunnannimi = kunnannimi;
	}

	
	public Kunta(String kunnannimi, List<Seura> seurat) {
		super();
		this.kunnannimi = kunnannimi;
		this.seurat = seurat;
	}

	

	public long getKunta_id() {
		return kunta_id;
	}

	public void setKunta_id(long kunta_id) {
		this.kunta_id = kunta_id;
	}

	public String getKunnannimi() {
		return kunnannimi;
	}

	public void setKunnannimi(String kunnannimi) {
		this.kunnannimi = kunnannimi;
	}

	public List<Seura> getSeurat() {
		return seurat;
	}

	public void setSeurat(List<Seura> seurat) {
		this.seurat = seurat;
	}

	@Override
	public String toString() {
		return "Kunta [id=" + kunta_id + ", kunnannimi=" + kunnannimi + "]";
	}
	

	

}
