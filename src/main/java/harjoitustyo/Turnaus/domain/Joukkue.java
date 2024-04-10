package harjoitustyo.Turnaus.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Joukkue {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long joukkue_id;
	
	@NotEmpty(message= "Joukkueella on oltava nimi.")
	@Size(min=2, max = 250, message="Nimessä oltava merkkejä 2-250." )
	private String nimi;
	
	private String logo; //miten logo tallennetaan? 
	
	private String yhteyshlo;
	
	private String email;
	
	private String puh;
	
	@ManyToOne
	@JoinColumn(name="seura")
	private Seura seura;
	
    @OneToMany(mappedBy = "kotijoukkue")
    private List<Ottelu> kotijoukkue;
    
    @OneToMany(mappedBy = "vierasjoukkue")
    private List<Ottelu> vierasjoukkue;
    
  	public Joukkue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Joukkue(
			@NotEmpty(message = "Joukkueella on oltava nimi.") @Size(min = 2, max = 250, message = "Nimessä oltava merkkejä 2-250.") String nimi,
			String logo, String yhteyshlo, String email, String puh, Seura seura, List<Ottelu> kotijoukkue,
			List<Ottelu> vierasjoukkue, Ottelu ottelu) {
		super();
		this.nimi = nimi;
		this.logo = logo;
		this.yhteyshlo = yhteyshlo;
		this.email = email;
		this.puh = puh;
		this.seura = seura;
		this.kotijoukkue = kotijoukkue;
		this.vierasjoukkue = vierasjoukkue;
	}
	
	public Joukkue(
			@NotEmpty(message = "Joukkueella on oltava nimi.") @Size(min = 2, max = 250, message = "Nimessä oltava merkkejä 2-250.") String nimi,
			String logo, String yhteyshlo, String email, String puh, Seura seura) {
		super();
		this.nimi = nimi;
		this.logo = logo;
		this.yhteyshlo = yhteyshlo;
		this.email = email;
		this.puh = puh;
		this.seura = seura;
}
	
	public Joukkue(
			@NotEmpty(message = "Joukkueella on oltava nimi.") @Size(min = 2, max = 250, message = "Nimessä oltava merkkejä 2-250.") String nimi,
			String logo, String yhteyshlo, String email, String puh) {
		super();
		this.nimi = nimi;
		this.logo = logo;
		this.yhteyshlo = yhteyshlo;
		this.email = email;
		this.puh = puh;
}

	public long getJoukkue_id() {
		return joukkue_id;
	}

	public void setJoukkue_id(long joukkue_id) {
		this.joukkue_id = joukkue_id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getYhteyshlo() {
		return yhteyshlo;
	}

	public void setYhteyshlo(String yhteyshlo) {
		this.yhteyshlo = yhteyshlo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPuh() {
		return puh;
	}

	public void setPuh(String puh) {
		this.puh = puh;
	}

	public Seura getSeura() {
		return seura;
	}

	public void setSeura(Seura seura) {
		this.seura = seura;
	}

	public List<Ottelu> getKotijoukkue() {
		return kotijoukkue;
	}

	public void setKotijoukkue(List<Ottelu> kotijoukkue) {
		this.kotijoukkue = kotijoukkue;
	}

	public List<Ottelu> getVierasjoukkue() {
		return vierasjoukkue;
	}

	public void setVierasjoukkue(List<Ottelu> vierasjoukkue) {
		this.vierasjoukkue = vierasjoukkue;
	}

	@Override
	public String toString() {
		return "Joukkue [joukkue_id=" + joukkue_id + ", nimi=" + nimi + ", logo=" + logo + ", yhteyshlo=" + yhteyshlo
				+ ", email=" + email + ", puh=" + puh + ", seura=" + seura + "]";
	}
  
    

}