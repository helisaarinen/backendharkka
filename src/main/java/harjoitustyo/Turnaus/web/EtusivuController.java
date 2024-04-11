package harjoitustyo.Turnaus.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import harjoitustyo.Turnaus.domain.AppUserRepository;
import harjoitustyo.Turnaus.domain.JoukkueRepository;
import harjoitustyo.Turnaus.domain.KuntaRepository;
import harjoitustyo.Turnaus.domain.OtteluRepository;
import harjoitustyo.Turnaus.domain.SeuraRepository;

@Controller
public class EtusivuController {
	

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
 	@GetMapping("etusivu")
	public String getOttelut (Model model) {
		log.info("Näytä kaikki ottelut");
		model.addAttribute("ottelut", orepository.findAll());
		return "etusivu";
	}
 	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }

	public EtusivuController() {
		super();
		// TODO Auto-generated constructor stub
	}
 	


}
