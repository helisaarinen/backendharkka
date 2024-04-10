package harjoitustyo.Turnaus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import harjoitustyo.Turnaus.domain.KuntaRepository;
import harjoitustyo.Turnaus.domain.Seura;
import harjoitustyo.Turnaus.domain.SeuraRepository;

@SpringBootTest(classes = TurnausApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SeuraRepositoryTest {
	
	@Autowired
	private SeuraRepository srepository;
	
	@Autowired
	private KuntaRepository krepository;
	
	@Test
	public void findByNimiShouldReturnSeura() {
		List<Seura> seurat = srepository.findByNimi("Tepa");
		assertThat(seurat).hasSize(1);
		assertThat(seurat.get(0).getKunta().getKunnannimi()).isEqualTo("Teuva");
	}

	
	

	
	
}
