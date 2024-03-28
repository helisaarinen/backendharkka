package harjoitustyo.Turnaus.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Sarja {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long sarja_id;
	
	@Size(min=1, max = 30)
	@Column(name="nimi")
	private String nimi;

	public Sarja() {
		// TODO Auto-generated constructor stub
	}

	public Sarja(@Size(min = 1, max = 30) String nimi) {
		super();
		this.nimi = nimi;
	}

	public Long getSarja_id() {
		return sarja_id;
	}

	public void setSarja_id(Long sarja_id) {
		this.sarja_id = sarja_id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	@Override
	public String toString() {
		return "Sarja [sarja_id=" + sarja_id + ", nimi=" + nimi + "]";
	}
	
	

}
