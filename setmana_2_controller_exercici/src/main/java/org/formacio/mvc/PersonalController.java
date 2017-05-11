package org.formacio.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller @RequestMapping(path="/personal")
public class PersonalController {

	// no toqueu la declaracio de baseDeDades ni el metode getBaseDeDades
	// 
	// als metodes que anau afegint, tracteu aquest array com si fos la base de dades
	//
	// per exemple, obtenir la persona amb id 1 sera fer baseDeDades.get(1), etc etc 
	
	private List<String> baseDeDades = new ArrayList<>(Arrays.asList("Joana","Antonia","Pere"));
	
	public List<String> getBaseDeDades() {
		return baseDeDades;
	}

	// Poseu a partir d'aqui els vostre metodes
	@RequestMapping(path="/info")
	@ResponseBody
	public String infoBaseDeDades()
	{
		int numPersones = getBaseDeDades().size();
		
		String missatge = "Hi ha " + numPersones + " persones";
		
		return missatge;
	}
	
	@RequestMapping(path="/consulta")
	@ResponseBody
	public String getNameByParam(@RequestParam(name="id", defaultValue = "0") Integer id)
	{
		String nombrePersona = getBaseDeDades().get(id);
		
		return nombrePersona;
	}
	
	@RequestMapping(path="/persona/{idPersona}")
	@ResponseBody
	public String getNameByPath(@PathVariable int idPersona)
	{
		String nombrePersona = getBaseDeDades().get(idPersona);
		
		return nombrePersona;
	}
	
	
	@RequestMapping(path="/afegir", method=RequestMethod.POST)
	@ResponseBody
	public String afegirPersona(@RequestParam String nom)
	{
		getBaseDeDades().add(nom);
		return "ok";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
