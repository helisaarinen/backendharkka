package harjoitustyo.Turnaus;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import harjoitustyo.Turnaus.web.JoukkueController;
import harjoitustyo.Turnaus.web.SeuraController;

@SpringBootTest
class TurnausApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private JoukkueController jcontroller;
	
	@Test
	public void contexLoads() throws Exception {
		assertThat(jcontroller).isNotNull();
	}
	
	@Autowired
	private SeuraController scontroller;
	
	@Test
	public void catcontexLoads()throws Exception {
		assertThat(scontroller).isNotNull();
	}
	
	

}
