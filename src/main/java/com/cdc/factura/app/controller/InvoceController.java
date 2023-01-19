package com.cdc.factura.app.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdc.factura.app.model.invoceModel;
import com.cdc.factura.app.service.impl.invoceServiceImpl;

@Controller
@RequestMapping("/")
public class InvoceController {
	
	@Autowired
	private invoceServiceImpl invoceServiceImpl;
	
	@GetMapping("/facturacion")
	public String welcome(Model model) throws Exception {
		String mensaje = "Bienvenido al Sistema Unico de Facturación.";
		model.addAttribute("mensaje", mensaje);
		   
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
		Calendar cal = Calendar.getInstance();
		model.addAttribute("fecha",dateFormat.format(cal.getTime()));
		
        return "facturacion";
    }
	
	
	@GetMapping("/facturacion/consulta")
	public String listaVentas(Model model) {
		List<invoceModel> lista = invoceServiceImpl.listar();
		model.addAttribute("lista",lista);
		
		return "listar";
	}
	
	@PostMapping("/facturacion/consulta")
	public String listaVentas(@RequestParam("numeroOtorgante") String numeroOtorgante, Model model) {
		if (numeroOtorgante.trim() =="") {
			List<invoceModel> lista = invoceServiceImpl.listar();
			model.addAttribute("lista",lista);
		}
		else {
			try {
				List<invoceModel> lista = invoceServiceImpl.listarPorID(numeroOtorgante);
				model.addAttribute("lista",lista);
			} catch (Exception e) {
				
			}			
		}		
		return "listar";
	}

	@GetMapping("/facturacion/mesvencido")
	public String listaMesVencido(Model model) {
		List<invoceModel> lista = invoceServiceImpl.listar();
		model.addAttribute("lista",lista);
		
		return "prefacturasMesVencido";
	}
	
	@PostMapping("/facturacion/mesvencido")
	public String listaMesVencido(@RequestParam("numeroOtorgante") String numeroOtorgante, Model model) {
		if (numeroOtorgante.trim() =="") {
			List<invoceModel> lista = invoceServiceImpl.listar();
			model.addAttribute("lista",lista);
		}
		else {
			try {
				List<invoceModel> lista = invoceServiceImpl.listarPorID(numeroOtorgante);
				model.addAttribute("lista",lista);
			} catch (Exception e) {
				
			}
		}
		return "prefacturasMesVencido";
	}

	@GetMapping("/facturacion/extraordinaria")
	public String listaExtraordinaria(Model model) {
		List<invoceModel> lista = invoceServiceImpl.listar();
		model.addAttribute("lista",lista);
		
		return "prefacturaExtraordinaria";
	}
	
	@PostMapping("/facturacion/extraordinaria")
	public String listaExtraordinaria(@RequestParam("numeroOtorgante") String numeroOtorgante, Model model) {
		if (numeroOtorgante.trim() =="") {
			List<invoceModel> lista = invoceServiceImpl.listar();
			model.addAttribute("lista",lista);
		}
		else {
			try {
				List<invoceModel> lista = invoceServiceImpl.listarPorID(numeroOtorgante);
				model.addAttribute("lista",lista);
			} catch (Exception e) {
				
			}
		}
		return "prefacturaExtraordinaria";
	}
	
}
