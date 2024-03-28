package harjoitustyo.Turnaus.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kentta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long kentta_id;
	
	@Column(name="nimi")
	private String nimi;

	public Kentta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kentta(String nimi) {
		super();
		this.nimi = nimi;
	}

	public Long getKentta_id() {
		return kentta_id;
	}

	public void setKentta_id(Long kentta_id) {
		this.kentta_id = kentta_id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	@Override
	public String toString() {
		return "Kentta [kentta_id=" + kentta_id + ", nimi=" + nimi + "]";
	}
	
	

}
