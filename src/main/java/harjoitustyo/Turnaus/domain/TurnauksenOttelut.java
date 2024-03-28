package harjoitustyo.Turnaus.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class TurnauksenOttelut {
	
	@ManyToOne
	@JoinColumn(name="turnaus_id")
	private Turnaus turnaus;
	
	@ManyToOne
	@JoinColumn(name="ottelu_id")
	private Ottelu ottelu;

	public TurnauksenOttelut(Turnaus turnaus, Ottelu ottelu) {
		super();
		this.turnaus = turnaus;
		this.ottelu = ottelu;
	}

	public Turnaus getTurnaus() {
		return turnaus;
	}

	public void setTurnaus(Turnaus turnaus) {
		this.turnaus = turnaus;
	}

	public Ottelu getOttelu() {
		return ottelu;
	}

	public void setOttelu(Ottelu ottelu) {
		this.ottelu = ottelu;
	}

	@Override
	public String toString() {
		return "TurnauksenOttelut [turnaus=" + turnaus + ", ottelu=" + ottelu + "]";
	}
	
	

}
