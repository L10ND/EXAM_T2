package edu.cibertec.T2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.cibertec.T2.model.Orden;
import edu.cibertec.T2.service.OrdenService;

@Controller
public class OrdenController {
	
	@Autowired
	private OrdenService ordenService;
	
	@GetMapping("/listarOrdenes")
	public String listarOrden(Model model){
		List<Orden> ordenes = ordenService.listarOrden();
		model.addAttribute("ordenes", ordenes);
		
		return "ordenes";
	}
	
	@GetMapping("/nuevaOrden")
	public String nuevaOrden(Model model) {
		model.addAttribute("orden", new Orden());
		return "OrdenForm";
	}
	
	@GetMapping("/mostrarOrden/{id}")
	public String mostrarOrden(@PathVariable int id, Model model) {
		model.addAttribute("orden", ordenService.hallarOrden(id));
		return "OrdenForm";
	}
	
	@PostMapping("/saveOrden")
	public String guardarOrden(@ModelAttribute Orden orden) {
		ordenService.guardarOrden(orden);
		return "redirect:/listarOrdenes";
	}
	
	@GetMapping("/ordenDelete/{id}")
	public String eliminarOrden(@PathVariable int id) {
		ordenService.eliminarOrden(id);
		return "redirect:/listarOrdenes";
	}
	
}
