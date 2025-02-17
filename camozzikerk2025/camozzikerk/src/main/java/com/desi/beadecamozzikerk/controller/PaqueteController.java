package com.desi.beadecamozzikerk.controller;

import com.desi.beadecamozzikerk.domain.Paquete;
import com.desi.beadecamozzikerk.domain.Ciudad;
import com.desi.beadecamozzikerk.domain.Cliente;
import com.desi.beadecamozzikerk.service.IPaqueteService;
import com.desi.beadecamozzikerk.service.ICiudadService;
import com.desi.beadecamozzikerk.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/paquetes")
public class PaqueteController {

    @Autowired
    private IPaqueteService paqueteService;

    @Autowired
    private ICiudadService ciudadService;

    @Autowired
    private IClienteService clienteService;

    // Método para cargar la página con el formulario y la lista de las ciudades que tengo en la Base de Datos
    @GetMapping
    public String mostrarFormulario(Model model) {
        // Obtener la lista de las ciudades y agregarla al modelo
        List<Ciudad> ciudades = ciudadService.getCiudades();
        model.addAttribute("ciudades", ciudades);

        // Agregar los paquetes al modelo para que puedan ser mostrados en la vista html
        List<Paquete> paquetes = paqueteService.obtenerTodosLosPaquetes();
        model.addAttribute("paquetes", paquetes);

        // Si hay mensajes de éxito o de error, esto los agrega al modelo
        if (model.containsAttribute("success")) {
            model.addAttribute("success", model.getAttribute("success"));
        }
        if (model.containsAttribute("error")) {
            model.addAttribute("error", model.getAttribute("error"));
        }

        return "paquetes";
    }

    // Método para registrar el paquete cargado
    @PostMapping
    public String registrarPaquete(@ModelAttribute Paquete paquete,
                                    @RequestParam Long dniRemitente,
                                    @RequestParam Long dniDestinatario,
                                    Model model) {

        // Obtener la lista de ciudades para volver a cargarla en caso de error, ya que sino no las vuelve a cargar
        List<Ciudad> ciudades = ciudadService.getCiudades();
        model.addAttribute("ciudades", ciudades);
        

        // Validar que el DNI del remitente sea válido sino informar con mensaje de error
        Cliente remitente = obtenerClientePorDni(dniRemitente, "remitente");
        if (remitente == null) {
            model.addAttribute("errorRemitente", "El DNI del remitente no está registrado.");
            return "paquetes"; // Volver a mostrar el formulario con el error
        }

        // Validar que el DNI del destinatario sea válido, acá lo mismo que antes
        Cliente destinatario = obtenerClientePorDni(dniDestinatario, "destinatario");
        if (destinatario == null) {
            model.addAttribute("errorDestinatario", "El DNI del destinatario no está registrado.");
            return "paquetes"; // Volver a mostrar el formulario con el error
        }
        

        // Asignar los clientes al paquete
        paquete.setRemitente(remitente);
        paquete.setDestinatario(destinatario);

        try {
            // Guardar el paquete cargado
            paqueteService.guardarPaquete(paquete);
            model.addAttribute("success", "Paquete registrado exitosamente.");
        } catch (Exception e) {
            model.addAttribute("error", "Hubo un error al registrar el paquete: " + e.getMessage());
            return "paquetes"; // Mostrar el error en el formulario
        }

        // Redirige a la misma página para ver el paquete registrado actualizado
        return "redirect:/paquetes"; // 
    }

   
    private Cliente obtenerClientePorDni(Long dni, String tipo) {
        Cliente cliente = clienteService.buscarPorDni(dni).orElse(null);
        if (cliente == null) {
            throw new IllegalArgumentException("El DNI del " + tipo + " no está registrado.");
        }
        return cliente;
    }
}
