package harjoitustyo.Turnaus.web;

import org.slf4j.LoggerFactory;

import java.util.List;

import org.slf4j.Logger;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import harjoitustyo.Turnaus.domain.AppUserRepository;
import harjoitustyo.Turnaus.domain.Joukkue;
import harjoitustyo.Turnaus.domain.JoukkueRepository;
import harjoitustyo.Turnaus.domain.KuntaRepository;
import harjoitustyo.Turnaus.domain.OtteluRepository;
import harjoitustyo.Turnaus.domain.SeuraRepository;
import jakarta.validation.Valid;

@Controller
public class JoukkueController {
	
	private static final Logger log = LoggerFactory.getLogger(JoukkueController.class);
	
	@Autowired
	private final JoukkueRepository jrepository;
	
	@Autowired
	private final SeuraRepository srepository;
	
	@Autowired
	private final AppUserRepository urepository;
	
	@Autowired
	private final KuntaRepository krepository;
	
	@Autowired
	private final OtteluRepository orepository;
	
	public JoukkueController(JoukkueRepository jrepository, SeuraRepository srepository,
			AppUserRepository urepository, KuntaRepository krepository, OtteluRepository orepository) {
		super();
		this.jrepository = jrepository;
		this.srepository = srepository;
		this.urepository = urepository;
		this.krepository = krepository;
		this.orepository = orepository;
	}

	@RequestMapping("main")
	@ResponseBody
	public String returnmsg()
	{
		return "Turnaussovellus!!!";
	}
	
	@RequestMapping(value={"/", "/etusivu"} )
	public String etusivu() {
		return "etusivu";
	}
	
	
	//JOUKKUELISTAUS
	/*
    @RequestMapping(value= {"/joukkuelistaus"})
    public String joukkueListaus(Model model) {	
        model.addAttribute("joukkueet", jrepository.findAll());
        model.addAttribute("seurat", srepository.findAll());
        model.addAttribute("kunnat", krepository.findAll());
        return "joukkuelistaus";
    }
*/
	
    @GetMapping("/joukkuelistaus")
    public String joukkueListaus(Model model, @RequestParam(name = "jarjestys", defaultValue = "asc") String jarjestys) {
        List<Joukkue> joukkueet;
        if (jarjestys.equals("asc")) {
            joukkueet = jrepository.findAllByOrderByNimiAsc();
        } else {
            joukkueet = jrepository.findAllByOrderByNimiDesc();
        }
        model.addAttribute("joukkueet", joukkueet);
        model.addAttribute("seurat", srepository.findAll());
        model.addAttribute("kunnat", krepository.findAll());
        return "joukkuelistaus";
    }
    
	//JSON
	@RequestMapping(value="/listaajoukkueet", method=RequestMethod.GET )
	public @ResponseBody List<Joukkue> restJoukkuelista() {
		return (List<Joukkue>) jrepository.findAll();
	}
	
    // Lisää uusi
    @RequestMapping(value = "/lisaa")
    public String lisaaJoukkue(Model model){
    	model.addAttribute("joukkue", new Joukkue());
    	model.addAttribute("seurat", srepository.findAll());
    	model.addAttribute("kunnat", krepository.findAll());
        return "lisaajoukkue";
    }  
	
    //TALLENNA
    @PostMapping("/tallenna")
    public String save(@Valid @ModelAttribute("joukkue") Joukkue joukkue, BindingResult bindingResult, Model model){
    	
    	if(bindingResult.hasErrors()) {
  
    		log.info("validation error, joukkue: " + joukkue);
    	  		model.addAttribute("joukkue", joukkue);
    	  		model.addAttribute("seurat", srepository.findAll());
    	  		model.addAttribute("kunnat", krepository.findAll());
    	  		model.addAttribute("ottelut", orepository.findAll());
    	  		return "lisaajoukkue";
    	}
    	jrepository.save(joukkue);
        return "redirect:joukkuelistaus";
    } 
    
    //MUOKKAA
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/muokkaa/{id}", method = RequestMethod.GET)
    public String muokkaaJoukkue(@PathVariable("id") Long joukkueID, Model model) {
    	model.addAttribute("joukkue", jrepository.findById(joukkueID));
    	model.addAttribute("seurat", srepository.findAll());
    	model.addAttribute("kunnat", krepository.findAll());
    	return "muokkaajoukkuetta";
    }
    
    
    //POISTA
	@PreAuthorize("hasAuthority('ADMIN')") 
	//Ainoastaan Admin-rooli voi poistaa tyypin. Muussa tapauksessa requestina voisi poistaa (/delete/{id})
    @RequestMapping(value = "/poista/{joukkue_id}", method = RequestMethod.GET)
    public String deleteJoukkue(@PathVariable("joukkue_id") Long joukkueId, Model model) {
    	jrepository.deleteById(joukkueId);
        return "redirect:../joukkuelistaus";
    }
    
    


}
