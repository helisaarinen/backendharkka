package harjoitustyo.Turnaus.web;

import java.lang.System.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import harjoitustyo.Turnaus.domain.JoukkueRepository;
import harjoitustyo.Turnaus.domain.KuntaRepository;
import harjoitustyo.Turnaus.domain.Seura;
import harjoitustyo.Turnaus.domain.SeuraRepository;
import jakarta.validation.Valid;



@Controller
public class SeuraController {
	
	//private static final Logger log = LoggerFactory.getLogger(SeuraController.class);
	
	@Autowired
	SeuraRepository srepository;
	
	@Autowired
	JoukkueRepository jrepository;
	
	@Autowired
	KuntaRepository krepository;
	
	@GetMapping("seuralistaus")
	public String getSeurat (Model model) {
		//log.info("Näytä kaikki seurat");
		model.addAttribute("seurat", srepository.findAll());
		return "seuralistaus";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("lisaaseura")
	public String lisaaSeura(Model model) {
		model.addAttribute("uusiSeura", new Seura());
		model.addAttribute("kunnat", krepository.findAll());
		return "lisaaseura";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("tallennaSeura")
	public String tallennaSeura(@Valid @ModelAttribute("uusiSeura") Seura seura, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("error tallennuksessa");
			return "joukkuelistaus";
		}
		srepository.save(seura);
		return "redirect:/joukkuelistaus";
	}
	
	
	//MUOKKAA
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/muokkaaseura/{id}", method = RequestMethod.GET)
    public String muokkaaSeura(@PathVariable("id") Long seuraID, Model model) {
    	model.addAttribute("seura", srepository.findById(seuraID));
    	model.addAttribute("kunnat", krepository.findAll());
    	return "muokkaaseuraa";
    }
    
	
    @PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("poistaSeura/{id}")
	public String poistaSeura(@PathVariable("id") Long id, Model model) {
		System.out.println("poista seura " + id);
		if(srepository.findById(id).get().getJoukkueet().isEmpty()) {
			srepository.deleteById(id);
		}else {
			System.out.println("Seuraa ei voi poistaa, kun siinä on joukkueita.");
		}
		return "redirect:/joukkuelistaus";
	}
	
	
	
	
	public SeuraController() {
		// TODO Auto-generated constructor stub
	}

}
