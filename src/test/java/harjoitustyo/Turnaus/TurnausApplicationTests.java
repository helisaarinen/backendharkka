package harjoitustyo.Turnaus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import harjoitustyo.Turnaus.web.JoukkueController;

@SpringBootTest
class TurnausApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private JoukkueController controller;

}
