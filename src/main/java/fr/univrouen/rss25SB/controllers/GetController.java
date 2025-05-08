package fr.univrouen.rss25SB.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.univrouen.rss25SB.model.*;

@RestController
public class GetController {
	@GetMapping("/resume")
	public String getListRSSinXML() {
		return "Envoi de la liste des flux RSS";
	}
	
	@GetMapping("/guid")
	public String getRSSinXML(@RequestParam(value = "guid") String texte) {
	return ("Détail du flux RSS demandé : " + texte);
	}
	
	@GetMapping("/test")
	public String getRSSTestinXML(@RequestParam(value = "nb") Integer nb, @RequestParam(value = "search") String search) {
	//return ("Détail du flux RSS demandé : " + nb + search);
    return String.format("<pre>Test :\nguid = %s\ntitre = %s</pre>", nb, search);
	}
	
	@RequestMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody Item getXML() {
	Item it = new Item("12345678","Test item","2022-05-01T11:22:33");
	return it;
	}
}
