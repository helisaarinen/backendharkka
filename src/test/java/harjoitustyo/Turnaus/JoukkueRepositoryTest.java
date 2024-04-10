package harjoitustyo.Turnaus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import harjoitustyo.Turnaus.domain.Joukkue;
import harjoitustyo.Turnaus.domain.JoukkueRepository;
import harjoitustyo.Turnaus.domain.SeuraRepository;


@SpringBootTest(classes = TurnausApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JoukkueRepositoryTest {
	
	@Autowired
	private JoukkueRepository jrepository;
	
	@Autowired
	private SeuraRepository srepostitory;

	@Test
	public void findByNimiShouldReturnJoukkue() {
		List<Joukkue> joukkueet = jrepository.findByNimi("Koipsi");
		assertThat(joukkueet).hasSize(1);
		assertThat(joukkueet.get(0).getSeura().getNimi()).isEqualTo("Koips");
	}
	
}
