package harjoitustyo.Turnaus.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Ottelu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ottelu_id;
	
    @NotNull(message = "Anna ottelulle alkamisaika.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime alkaa;
	
    @NotNull(message = "Anna ottelulle päättymisaika.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime loppuu;
	
	@ManyToOne
	@JoinColumn(name="kotijoukkue")
	private Joukkue kotijoukkue;
	
	@ManyToOne
	@JoinColumn(name="vierasjoukkue")
	private Joukkue vierasjoukkue;
	
	
	@Min(value = 0, message ="Maalien määrä ei voi olla negatiivinen.")
	private Integer kotimaalit;

	@Min(value = 0, message ="Maalien määrä ei voi olla negatiivinen.")
	private Integer vierasmaalit;
		
	public Ottelu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ottelu(LocalDateTime alkaa, LocalDateTime loppuu, Joukkue kotijoukkue, Joukkue vierasjoukkue, Integer kotimaalit,
			Integer vierasmaalit, List<Joukkue> joukkueet) {
		super();
		this.alkaa = alkaa;
		this.loppuu = loppuu;
		this.kotijoukkue = kotijoukkue;
		this.vierasjoukkue = vierasjoukkue;
		this.kotimaalit = kotimaalit;
		this.vierasmaalit = vierasmaalit;

	}

	public Long getOttelu_id() {
		return ottelu_id;
	}

	public void setOttelu_id(Long ottelu_id) {
		this.ottelu_id = ottelu_id;
	}

	public LocalDateTime getAlkaa() {
		return alkaa;
	}

	public void setAlkaa(LocalDateTime alkaa) {
		this.alkaa = alkaa;
	}

	public LocalDateTime getLoppuu() {
		return loppuu;
	}

	public void setLoppuu(LocalDateTime loppuu) {
		this.loppuu = loppuu;
	}

	public Joukkue getKotijoukkue() {
		return kotijoukkue;
	}

	public void setKotijoukkue(Joukkue kotijoukkue) {
		if(kotijoukkue.equals(vierasjoukkue)) {
			throw new IllegalArgumentException("Kotijoukkue ja vierasjoukkue eivät voi olla sama.");
		}
		this.kotijoukkue = kotijoukkue;
	}

	public Joukkue getVierasjoukkue() {
		return vierasjoukkue;
	}

	public void setVierasjoukkue(Joukkue vierasjoukkue) {
		if(vierasjoukkue.equals(kotijoukkue)) {
			throw new IllegalArgumentException("Kotijoukkue ja vierasjoukkue eivät voi olla sama.");
		}
		this.vierasjoukkue = vierasjoukkue;
	}

	public Integer getKotimaalit() {
		return kotimaalit;
	}

	public void setKotimaalit(int kotimaalit) {
		this.kotimaalit = kotimaalit;
	}

	public Integer getVierasmaalit() {
		return vierasmaalit;
	}

	public void setVierasmaalit(int vierasmaalit) {
		this.vierasmaalit = vierasmaalit;
	}


	@Override
	public String toString() {
		return "Ottelu [ottelu_id=" + ottelu_id + ", alkaa=" + alkaa + ", loppuu=" + loppuu + ", kotijoukkue="
				+ kotijoukkue + ", vierasjoukkue=" + vierasjoukkue + ", kotimaalit=" + kotimaalit + ", vierasmaalit="
				+ vierasmaalit +  "]";
	}
	
}
