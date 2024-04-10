package harjoitustyo.Turnaus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.Turnaus.domain.AppUser;
import harjoitustyo.Turnaus.domain.AppUserRepository;
import harjoitustyo.Turnaus.domain.Joukkue;
import harjoitustyo.Turnaus.domain.JoukkueRepository;
import harjoitustyo.Turnaus.domain.Kunta;
import harjoitustyo.Turnaus.domain.KuntaRepository;
import harjoitustyo.Turnaus.domain.Ottelu;
import harjoitustyo.Turnaus.domain.OtteluRepository;
import harjoitustyo.Turnaus.domain.Seura;
import harjoitustyo.Turnaus.domain.SeuraRepository;
import harjoitustyo.Turnaus.domain.Turnaus;
import harjoitustyo.Turnaus.domain.TurnausRepository;


@SpringBootApplication
public class TurnausApplication {
	private static final Logger log = LoggerFactory.getLogger(TurnausApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TurnausApplication.class, args);
	}

	
	
	/*KOMMENTOI POIS, KUN KÄYTÄT TIETOKANTAA
		
	@Bean
	public CommandLineRunner demoData(
			JoukkueRepository jrepository, 
			SeuraRepository srepository,
			AppUserRepository urepository,
			KuntaRepository krepository,
			TurnausRepository trepository,
			OtteluRepository orepository) {
		
		return (args) -> {
			
			
			log.info("tallennetaan turnauksia");
			
			trepository.save(new Turnaus("Peräkylän turnaus", LocalDate.parse("2024-03-21"), LocalDate.parse("2024-03-21")));
			trepository.save(new Turnaus("Toinenkin turnaus", LocalDate.parse("2024-03-21"), LocalDate.parse("2024-03-21")));
			trepository.save(new Turnaus("Kolmaskin turnaus", LocalDate.parse("2024-03-21"), LocalDate.parse("2024-03-21")));

			
			log.info("Tulostetaan kunnat");
			for (Kunta kunta: krepository.findAll()) {
				log.info(kunta.toString());
			}

			log.info("tallennetaan kuntia");
			krepository.save(new Kunta ("Kunnannimi"));
			krepository.save(new Kunta ("Kokkola"));
			krepository.save(new Kunta ("Vantaa"));
			krepository.save(new Kunta ("Espoo"));
			krepository.save(new Kunta ("Helsinki"));
			krepository.save(new Kunta ("Teuva"));
			krepository.save(new Kunta ("Ylitornio"));
			
			log.info("Tulostetaan kunnat");
			for (Kunta kunta: krepository.findAll()) {
				log.info(kunta.toString());
			}
			
			
			log.info("tallennetaan seuroja");
			srepository.save(new Seura ("NIMI", "VERKKOSIVU", krepository.findByKunnannimi("Ylitornio").get(0)));
			srepository.save(new Seura ("Itä-Hakkilan kilpa", "www.google.fi", krepository.findByKunnannimi("Vantaa").get(0)));
			srepository.save(new Seura ("Koips", "www.google.fi", krepository.findByKunnannimi("Vantaa").get(0) ));
			srepository.save(new Seura ("Huips", "www.google.fi", krepository.findByKunnannimi("Vantaa").get(0)));
			srepository.save(new Seura ("Tepa","www.google.fi", krepository.findByKunnannimi("Teuva").get(0)));
			
			log.info("Tulostetaan seurat");
			for (Seura seura: srepository.findAll()) {
				log.info(seura.toString());
			}
			
			jrepository.save(new Joukkue("JoukkueenNIMI", "LOGO", "YHTEYSHENKILÖ", "email", "PUHELINNUMERO", srepository.findByNimi("Koips").get(0)));
			jrepository.save(new Joukkue("Koipsi", "LOGO", "Harri Petteri", "email", "4545454554", srepository.findByNimi("Koips").get(0)));
			jrepository.save(new Joukkue("KolmasNimi", "LOGO", "Nakki Makkara", "email", "4545454554",srepository.findByNimi("Huips").get(0)));
			jrepository.save(new Joukkue("NeljäsJoukkue", "LOGO", "Kukalie", "email", "05055555555", srepository.findByNimi("Tepa").get(0)));

			
			log.info("tallennetaan ottelut");
			orepository.save(new Ottelu (LocalDateTime.parse("2024-03-25T12:00:00"), LocalDateTime.parse("2024-03-25T12:20:00"), jrepository.findByNimi("JoukkueenNIMI").get(0), jrepository.findByNimi("Koipsi").get(0), 3, 3, null));
			
			log.info("Tulostetaan ottelut");
			for (Ottelu ottelu: orepository.findAll()) {
				log.info(ottelu.toString());
			}
			
			// Create users: admin/admin user/user
			AppUser user = new AppUser("user", "$2a$10$kqkYxLSIRm.0qnXc9Oqqze6U0XKwLcUMK3DQaxeEJmpKLFlgE6x92", "email@mail.com", "USER"); //Rooli voi olla vaikka kukka ja keppi
			AppUser admin = new AppUser("admin", "$2a$10$xaTrOfrX4FSPxx22LYx/7uoJQ.3v.7CBdtwyGh/lwfzaFq/vIZHRO", "email2@mail.com", "ADMIN");
			urepository.save(user);
			urepository.save(admin);
			
			log.info("kaikki joukkueet");
			for (Joukkue joukkue : jrepository.findAll()) {
				log.info(joukkue.toString());
			}
		};
		};
	
*/
}
