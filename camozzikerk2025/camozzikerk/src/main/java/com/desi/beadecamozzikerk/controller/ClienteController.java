package com.desi.beadecamozzikerk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desi.beadecamozzikerk.domain.Cliente;
import com.desi.beadecamozzikerk.service.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    // Mostrar todos los clientes
    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.obtenerTodosClientes();
        model.addAttribute("clientes", clientes); 
        return "gestionar_clientes";  
    }

    // Agregar un cliente
    @PostMapping("/agregar")
    public String crearCliente(@ModelAttribute Cliente cliente, RedirectAttributes redirectAttributes) {
        try {
            clienteService.crearCliente(cliente); // ACá se guarda el nuevo client.
            redirectAttributes.addFlashAttribute("success", "Cliente agregado correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Hubo un error al agregar el cliente: " + e.getMessage());
        }
        return "redirect:/clientes"; // Se redirige a la lista de los clientes
    }

    // Eliminar un cliente
    @PostMapping("/borrar/{id}")
    public String eliminarCliente(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            clienteService.eliminarCliente(id);
            redirectAttributes.addFlashAttribute("success", "Cliente eliminado correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el cliente: " + e.getMessage());
        }
        return "redirect:/clientes";  // Redirige a la lista de clientes
    }
}
