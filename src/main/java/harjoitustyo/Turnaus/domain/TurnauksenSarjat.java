package harjoitustyo.Turnaus.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class TurnauksenSarjat {
	
	@ManyToOne
	@JoinColumn(name="turnaus_id")
	private Turnaus turnaus;
	
	@ManyToOne
	@JoinColumn(name="sarja_id")
	private Sarja sarja;

	public TurnauksenSarjat(Turnaus turnaus, Sarja sarja) {
		super();
		this.turnaus = turnaus;
		this.sarja = sarja;
	}

	public Turnaus getTurnaus() {
		return turnaus;
	}

	public void setTurnaus(Turnaus turnaus) {
		this.turnaus = turnaus;
	}

	public Sarja getSarja() {
		return sarja;
	}

	public void setSarja(Sarja sarja) {
		this.sarja = sarja;
	}

	@Override
	public String toString() {
		return "TurnauksenSarjat [turnaus=" + turnaus + ", sarja=" + sarja + "]";
	}

	
}
