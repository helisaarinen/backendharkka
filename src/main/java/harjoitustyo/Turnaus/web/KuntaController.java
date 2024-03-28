package harjoitustyo.Turnaus.web;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import harjoitustyo.Turnaus.domain.Kunta;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class KuntaController {
	
	@GetMapping("/kunnat/kunnat")
    public String showKunnat(Model model) {
        List<String> kunnat = readExcel(); // Tämä on funktio, joka lukee Excel-tiedoston ja palauttaa kunnat listana
        model.addAttribute("kunnat", kunnat);
        return "kunnat"; // Palauttaa Thymeleaf-mallin nimen
    }

	private List<String> readExcel() {
		// TODO Auto-generated method stub
		return null;
	}  


}
