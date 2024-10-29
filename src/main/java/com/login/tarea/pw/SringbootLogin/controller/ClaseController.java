package com.login.tarea.pw.SringbootLogin.controller;

import com.login.tarea.pw.SringbootLogin.dto.ClaseDTO;
import com.login.tarea.pw.SringbootLogin.model.Clase;
import com.login.tarea.pw.SringbootLogin.model.EstadoClase;
import com.login.tarea.pw.SringbootLogin.model.Usuario;
import com.login.tarea.pw.SringbootLogin.service.ClaseService;
import com.login.tarea.pw.SringbootLogin.service.UsuarioService;
import com.login.tarea.pw.SringbootLogin.service.EstadoClaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

@Controller
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    @Autowired
    private EstadoClaseService estadoClaseServicio;
    
	@Autowired
	private UsuarioService servicio;

	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}

	@GetMapping("/")
	public String redirect() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String showIndex(Model model, Principal principal) {
		String username = principal.getName();
		Usuario usuario = servicio.findByUsername(username);
		model.addAttribute("usuario", usuario);
        List<Clase> clases = claseService.getAllClases();
        model.addAttribute("clases", clases);
		return "index";
	}

    @GetMapping("/nueva")
    public String showNewClaseForm(Model model) {
        ClaseDTO claseDTO = new ClaseDTO();
        model.addAttribute("claseDTO", claseDTO);

        List<EstadoClase> estados = estadoClaseServicio.findAll();
        model.addAttribute("estadoClases", estados);

        return "crearclase";
    }

    @PostMapping("/guardar")
    public String saveClase(@ModelAttribute ClaseDTO claseDTO, Model model) {
        try {
            claseService.saveClase(claseDTO);
            model.addAttribute("successMessage", "La clase se creó correctamente");
            claseDTO = new ClaseDTO();
        } catch (Exception e) {
            System.out.println("Error al guardar la clase: " + e.getMessage());
            model.addAttribute("errorMessage", "Error al guardar la clase");
        }
        model.addAttribute("claseDTO", claseDTO);
        return "crearclase";
    }

    @GetMapping("/actualizar")
    public String showUpdateForm(@RequestParam Long id, ModelMap model) {
        Clase clase = claseService.getClaseById(id);
        List<EstadoClase> estadoClases = estadoClaseServicio.findAll();
        model.addAttribute("estadoClases", estadoClases);
        model.put("clase", clase);
        return "actualizarclase";
    }

    @PostMapping("/actualizar")
    public String updateClase(ModelMap model, @Valid Clase clase, BindingResult result) {
        if (result.hasErrors()) {
            return "actualizarclase";
        }

        claseService.updateClase(clase);
        return "redirect:/home";
    }

    @PostMapping("/eliminar")
    public String deleteClase(ModelMap model, @RequestParam Long id) {
        Clase clase = claseService.getClaseById(id);
        if (clase == null) {
            model.addAttribute("error", "Clase no encontrada");
            return "error";
        }

        claseService.deleteClase(clase);
        return "redirect:/home";
    }
}