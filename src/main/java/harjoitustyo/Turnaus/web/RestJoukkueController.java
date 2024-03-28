package harjoitustyo.Turnaus.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import harjoitustyo.Turnaus.domain.Joukkue;
import harjoitustyo.Turnaus.domain.JoukkueRepository;
import harjoitustyo.Turnaus.domain.SeuraRepository;

@RestController
public class RestJoukkueController {
	
	
	private static final Logger log = LoggerFactory.getLogger(RestJoukkueController.class);
	
	@Autowired //injektoitu repositoryt käyttöön 
	JoukkueRepository jrepository;
	@Autowired
	SeuraRepository srepository;
	
	@RequestMapping("/joukkueet")
	public Iterable<Joukkue> getJoukkueet() {
		log.info("Kaikki joukkueet JSON:ina");
		return jrepository.findAll();

	}

	@GetMapping("/joukkue/{joukkue_id}")
	public Optional<Joukkue> getOneJoukkue(@PathVariable("id") Long joukkueId) {
		log.info("fetch one book from db and return to client as json " + joukkueId);
		return jrepository.findById(joukkueId);
	}

	@PostMapping("/joukkue")
	Joukkue uusiJoukkue(@RequestBody Joukkue uusiJoukkue) {
		log.info("Tallenna uusi " + uusiJoukkue);
		return jrepository.save(uusiJoukkue);
	}

	@PutMapping("/joukkue/{joukkue_id}")
	Joukkue muokkaaJoukkuetta(@RequestBody Joukkue muokattuJoukkue, @PathVariable Long joukkue_id) {
		log.info("Muokattu joukkue: " + muokattuJoukkue);
		log.info("Muokkaa joukkuetta, id = " + joukkue_id);
		muokattuJoukkue.setJoukkue_id(joukkue_id);
		log.info("muokattu joukkue = " + muokattuJoukkue);
		return jrepository.save(muokattuJoukkue);
	}
	
	@DeleteMapping("/joukkue/@{joukkue_id}")
	Joukkue poistaJoukkue(@RequestBody Joukkue poistettuJoukkue, @PathVariable Long joukkue_id) {
		log.info("Poista joukkue: "+ poistettuJoukkue + joukkue_id);
		poistettuJoukkue.setJoukkue_id(joukkue_id);
		log.info("Poistettu joukkue: " + poistettuJoukkue);
		return jrepository.save(poistettuJoukkue);
	}
	

}
