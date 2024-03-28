package harjoitustyo.Turnaus.web;

import org.slf4j.Logger;
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

import harjoitustyo.Turnaus.domain.AppUserRepository;
import harjoitustyo.Turnaus.domain.JoukkueRepository;
import harjoitustyo.Turnaus.domain.KuntaRepository;
import harjoitustyo.Turnaus.domain.Ottelu;
import harjoitustyo.Turnaus.domain.OtteluRepository;
import harjoitustyo.Turnaus.domain.SeuraRepository;
import jakarta.validation.Valid;

@Controller
public class OtteluController {
	
	private static final Logger log = LoggerFactory.getLogger(OtteluController.class);
	
	@Autowired
	OtteluRepository orepository;
	
	@Autowired
	JoukkueRepository jrepository;
	
	@Autowired
	SeuraRepository srepository;
	
	@Autowired
	AppUserRepository urepository;
	
	@Autowired
	KuntaRepository krepository;


	//Listaa
 	@GetMapping("ottelulistaus")
	public String getOttelut (Model model) {
		log.info("Näytä kaikki ottelut");
		model.addAttribute("ottelut", orepository.findAll());
		return "ottelulistaus";
	}
 	
	//Lisää	
 	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value="/lisaaottelu")
	public String lisaaOttelu(Model model) {
		model.addAttribute("ottelu", new Ottelu());
		model.addAttribute("seurat", srepository.findAll());
    	model.addAttribute("kunnat", krepository.findAll());
    	model.addAttribute("joukkueet", jrepository.findAll());
    	model.addAttribute("ottelut", orepository.findAll());
		return "lisaaottelu";
	}
	
	
	//TALLENNA
 	@PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/tallennaottelu")
    public String save(@Valid @ModelAttribute("ottelu") Ottelu ottelu, BindingResult bindingResult, Model model, Object joukkue){
    	
    	if(bindingResult.hasErrors()) {
  
    		log.info("validation error, ottelu: " + ottelu);
    	  		model.addAttribute("ottelu", ottelu);
    	  		model.addAttribute("seurat", srepository.findAll());
    	  		model.addAttribute("kunnat", krepository.findAll());
    	  		model.addAttribute("joukkueet", jrepository.findAll());
    	  		return "lisaaottelu";
    	}

    	orepository.save(ottelu);
       // return "redirect:ottelulistaus";
    	return "redirect:lisaaottelu";
    } 
    
 	@PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/tallennaottelutulos")
    public String savetulos(@Valid @ModelAttribute("ottelu") Ottelu ottelu, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("Validation error, ottelu: " + ottelu);
            model.addAttribute("ottelu", ottelu);
            model.addAttribute("seurat", srepository.findAll());
            model.addAttribute("kunnat", krepository.findAll());
            model.addAttribute("joukkueet", jrepository.findAll());
            return "redirect:ottelulistaus";
        }

        // Tarkista, että koti- ja vierasmaalit ovat syötetty
        if (ottelu.getKotimaalit() == null || ottelu.getVierasmaalit() == null) {
            return "redirect:ottelulistaus";
        }

        // Tallenna vain koti- ja vierasmaalit uusina tietoina
        Ottelu existingOttelu = orepository.findById(ottelu.getOttelu_id()).orElse(null);
        if (existingOttelu != null) {
            existingOttelu.setKotimaalit(ottelu.getKotimaalit());
            existingOttelu.setVierasmaalit(ottelu.getVierasmaalit());
            orepository.save(existingOttelu);
        }

        return "redirect:ottelulistaus";
    }

    
    //MUOKKAA / LISÄÄ TULOS
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/tulos/{id}", method = RequestMethod.GET)
    public String muokkaaTulos(@PathVariable("id") Long otteluID, Model model) {
    	model.addAttribute("ottelu", orepository.findById(otteluID));
    	model.addAttribute("joukkueet", jrepository.findAll());
    	model.addAttribute("seurat", srepository.findAll());
    	model.addAttribute("kunnat", krepository.findAll());
    	return "muokkaaottelutulos";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("poistaottelu/{id}")
	public String poistaOttelu(@PathVariable("id") Long id, Model model) {
		System.out.println("poista ottelu " + id);
		if(orepository.findById(id).get().getJoukkueet().isEmpty()) {
			orepository.deleteById(id);
		}else {
			System.out.println("Ottelua ei voi poistaa, kun siinä on joukkueita.");
		}
		return "redirect:/ottelulistaus";
	}

	public OtteluController() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
}
