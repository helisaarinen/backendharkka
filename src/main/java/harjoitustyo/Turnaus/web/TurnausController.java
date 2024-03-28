package harjoitustyo.Turnaus.web;

import java.lang.System.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import harjoitustyo.Turnaus.domain.AppUserRepository;
import harjoitustyo.Turnaus.domain.Joukkue;
import harjoitustyo.Turnaus.domain.JoukkueRepository;
import harjoitustyo.Turnaus.domain.KuntaRepository;
import harjoitustyo.Turnaus.domain.SeuraRepository;
import harjoitustyo.Turnaus.domain.Turnaus;
import harjoitustyo.Turnaus.domain.TurnausRepository;
import jakarta.validation.Valid;

@Controller
public class TurnausController {
	
	//private static final Logger log = LoggerFactory.getLogger(TurnausController.class);
	
	
	@Autowired
	TurnausRepository trepository;
	
	@Autowired
	JoukkueRepository jrepository;
	
	@Autowired
	SeuraRepository srepository;
	
	@Autowired
	AppUserRepository urepository;
	
	@Autowired
	KuntaRepository krepository;
	
	
	// Näytä kaikki
    @RequestMapping(value= {"/turnauslistaus"})
    public String turnauslistaus(Model model) {	
        model.addAttribute("turnaukset", trepository.findAll());
        return "turnauslistaus";
    }
	
	
	//LISÄÄ UUSI TURNAUS
    @RequestMapping(value = "/lisaatur")
    public String lisaaTurnaus(Model model){
    	model.addAttribute("turnaus", new Turnaus());
    	model.addAttribute("joukkueet", jrepository.findAll());
    	model.addAttribute("seurat", srepository.findAll());
    	model.addAttribute("kunnat", krepository.findAll());
        return "lisaaturnaus";
    } 
    
    
        //TALLENNA
    @PostMapping("/tallennatur")
    public String save(@Valid @ModelAttribute("turnaus") Turnaus turnaus, BindingResult bindingResult, Model model){
    	
    	if(bindingResult.hasErrors()) {
  
 //   		log.info("validation error, turnaus: " + turnaus);
    	  		model.addAttribute("turnaus", turnaus);
    	  		model.addAttribute("joukkueet", jrepository.findAll());
    	  		model.addAttribute("seurat", srepository.findAll());
    	  		model.addAttribute("kunnat", krepository.findAll());
    	  		return "lisaaturnaus";
    	}
    	trepository.save(turnaus);
        return "redirect:turnauslistaus";
    } 
	
	
	
	
}
