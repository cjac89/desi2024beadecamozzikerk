package com.desi.beadecamozzikerk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.desi.beadecamozzikerk.domain.Provincia;
import com.desi.beadecamozzikerk.service.IProvinciaService;

@Controller
@RequestMapping("/api/provincias")
public class ProvinciaController {
	 @Autowired
	    private IProvinciaService provinciaService;

	    
	    @GetMapping
	    public List<Provincia> getProvincias() {
	        return provinciaService.listarProvincias();
	    }

	    
	    @GetMapping("/id/{id}")
	    public ResponseEntity<?> getProvinciaPorId(@PathVariable Long id) {
	        try {
	            Provincia provincia = provinciaService.buscarPorId(id);
	            return ResponseEntity.status(HttpStatus.OK).body(provincia);
	        } catch (Exception e) {
	            Map<String, String> errorResponse = new HashMap<>();
	            errorResponse.put("message", "Error al obtener la provincia: " + e.getMessage());
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	        }
	    }

	    
	    @GetMapping("/nombre")
	    public ResponseEntity<?> getProvinciaPorNombre(@RequestParam String nombre) {
	        try {
	            Provincia provincia = provinciaService.buscarPorNombre(nombre);
	            return ResponseEntity.status(HttpStatus.OK).body(provincia);
	        } catch (Exception e) {
	            Map<String, String> errorResponse = new HashMap<>();
	            errorResponse.put("message", "Error al obtener la provincia: " + e.getMessage());
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	        }
	    }

	   
	    @PostMapping
	    public ResponseEntity<?> crearProvincia(@RequestBody Provincia provincia) {
	        try {
	            Provincia nuevaProvincia = provinciaService.guardarProvincia(provincia);
	            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaProvincia);
	        } catch (Exception e) {
	            Map<String, String> errorResponse = new HashMap<>();
	            errorResponse.put("message", "Error al guardar la provincia: " + e.getMessage());
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	        }
	    }

	    
	    @DeleteMapping("/id/{id}")
	    public ResponseEntity<?> eliminarProvincia(@PathVariable Long id) {
	        try {
	            provinciaService.eliminarProvincia(id);
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	        } catch (Exception e) {
	            Map<String, String> errorResponse = new HashMap<>();
	            errorResponse.put("message", "Error al eliminar la provincia: " + e.getMessage());
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	        }
	    }
}
