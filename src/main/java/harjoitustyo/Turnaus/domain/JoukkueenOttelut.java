package harjoitustyo.Turnaus.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class JoukkueenOttelut {
	
	@ManyToOne
	@JoinColumn(name="joukkue_id")
	private Joukkue joukkue;
	
	@ManyToOne
	@JoinColumn(name="ottelu_id")
	private Ottelu ottelu;

	public JoukkueenOttelut(Joukkue joukkue, Ottelu ottelu) {
		super();
		this.joukkue = joukkue;
		this.ottelu = ottelu;
	}

	public Joukkue getJoukkue() {
		return joukkue;
	}

	public void setJoukkue(Joukkue joukkue) {
		this.joukkue = joukkue;
	}

	public Ottelu getOttelu() {
		return ottelu;
	}

	public void setOttelu(Ottelu ottelu) {
		this.ottelu = ottelu;
	}

	@Override
	public String toString() {
		return "JoukkueenOttelut [joukkue=" + joukkue + ", ottelu=" + ottelu + "]";
	}
	
	

}
