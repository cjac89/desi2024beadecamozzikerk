package com.desi.beadecamozzikerk.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desi.beadecamozzikerk.domain.Camion;
import com.desi.beadecamozzikerk.domain.Ciudad;
import com.desi.beadecamozzikerk.repository.ICamionRepository;
import com.desi.beadecamozzikerk.service.ICamionService;
import com.desi.beadecamozzikerk.service.ICiudadService;

@Controller
@RequestMapping("/camiones") 
public class CamionController {

    @Autowired
    private ICamionService camionService;

    @Autowired
    private ICiudadService ciudadService;
    
    @Autowired
    private ICamionRepository camionRepository; // Asegúrate de agregar esto

    
    //Muestra los camiones
    @GetMapping
    public String listarCamiones(Model model) {
        List<Camion> camiones = camionService.getCamiones();
        List<Ciudad> ciudades = ciudadService.getCiudades();
        System.out.println("Lista de camiones: " + camiones);

        model.addAttribute("camiones", camiones);
        model.addAttribute("ciudades", ciudades);
        return "gestionar_camiones"; 
    }
    

    @PostMapping("/agregar")
    public String agregarCamion(@ModelAttribute Camion camion, @RequestParam("ciudadActual.id") Long ciudadId, RedirectAttributes redirectAttributes) {
        try {
            Ciudad ciudad = ciudadService.buscarPorId(ciudadId);
            camion.setCiudadActual(ciudad);
            camionService.guardar(camion);
            redirectAttributes.addFlashAttribute("success", "Camión agregado correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al agregar el camión: " + e.getMessage());
        }
        return "redirect:/camiones";
    }


    @PostMapping("/borrar/{id}")
    public String eliminarCamion(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            camionService.borrar(id);
            redirectAttributes.addFlashAttribute("success", "Camión eliminado correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el camión: " + e.getMessage());
        }
        return "redirect:/camiones";
    }

    @GetMapping("/ubicacion")
    public String buscarPorUbicacion(
            @RequestParam(required = false) String patente,
            @RequestParam(required = false) Integer codigoPostal,
            Model model,
            RedirectAttributes redirectAttributes) {
        try {
            List<Camion> camiones = null;
            if (patente != null && !patente.isEmpty()) {
                camiones = camionRepository.findByPatenteContaining(patente);
            } else if (codigoPostal != null) {
                camiones = camionRepository.findByCiudadActualCodigoPostal(codigoPostal);
            }
            model.addAttribute("camiones", camiones);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al buscar camiones: " + e.getMessage());
            return "redirect:/camiones";
        }
        return "gestionar_ubicacion";
    }


}

