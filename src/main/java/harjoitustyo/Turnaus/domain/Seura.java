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
import jakarta.validation.constraints.Size;

@Entity
public class Seura {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long seura_id;
	
	@Size(min=1, max = 50)
	@Column(name="nimi")
	private String nimi;
	
	@Size(max=50)
	private String verkkosivu;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="seura")
	@JsonIgnore
	private List<Joukkue> joukkueet;
	
	@ManyToOne
	@JoinColumn(name="kunta")
	private Kunta kunta;

	public Seura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seura(String nimi, String verkkosivu) {
		super();
		this.nimi = nimi;
		this.verkkosivu = verkkosivu;
	}
	
	public Seura(String nimi, String verkkosivu, Kunta kunta) {
		super();
		this.nimi = nimi;
		this.kunta = kunta;
		this.verkkosivu = verkkosivu;
	}
	
	public Seura(String nimi, Kunta kunta, String verkkosivu, List<Joukkue> joukkueet) {
		super();
		this.nimi = nimi;
		this.kunta = kunta;
		this.verkkosivu = verkkosivu;
		this.joukkueet = joukkueet;
	}
	



	public Long getSeura_id() {
		return seura_id;
	}

	public void setSeura_id(Long seura_id) {
		this.seura_id = seura_id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public Kunta getKunta() {
		return kunta;
	}

	public void setKunta(Kunta kunta) {
		this.kunta = kunta;
	}

	public String getVerkkosivu() {
		return verkkosivu;
	}

	public void setVerkkosivu(String verkkosivu) {
		this.verkkosivu = verkkosivu;
	}
	
	public List<Joukkue> getJoukkueet() {
		return joukkueet;
	}

	public void setJoukkueet(List<Joukkue> joukkueet) {
		this.joukkueet = joukkueet;
	}

	
	@Override
	public String toString() {
		return "Seura [id=" + seura_id + ", nimi=" + nimi + ", kunta=" + kunta + ", verkkosivu=" + verkkosivu + "]";
	}
	
	/*
	 	@OneToMany(cascade = CascadeType.ALL, mappedBy="category")
	@JsonIgnore
	private List<Book> books;

	 */
	
}
