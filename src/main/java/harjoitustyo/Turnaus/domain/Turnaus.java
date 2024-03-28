package harjoitustyo.Turnaus.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Turnaus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long turnaus_id;
	
	private String nimi;
	
	private LocalDate alkupva;
	
	private LocalDate loppupva;

	public Turnaus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Turnaus(String nimi, LocalDate alkupva, LocalDate loppupva) {
		super();
		this.nimi = nimi;
		this.alkupva = alkupva;
		this.loppupva = loppupva;
	}

	public long getId() {
		return turnaus_id;
	}

	public void setId(long id) {
		this.turnaus_id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public LocalDate  getAlkupva() {
		return alkupva;
	}

	public void setAlkupva(LocalDate  alkupva) {
		this.alkupva = alkupva;
	}

	public LocalDate  getLoppupva() {
		return loppupva;
	}

	public void setLoppupva(LocalDate  loppupva) {
		this.loppupva = loppupva;
	}

	@Override
	public String toString() {
		return "Turnaus [id=" + turnaus_id + ", nimi=" + nimi + ", alkupva=" + alkupva + ", loppupva=" + loppupva + "]";
	}
	
	

}
