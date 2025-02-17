package com.desi.beadecamozzikerk.service;

import com.desi.beadecamozzikerk.domain.Paquete;

import java.util.List;

import org.springframework.stereotype.Service;



@Service
public interface IPaqueteService {


    
	void guardarPaquete(Paquete paquete);

    
    List<Paquete> obtenerTodosLosPaquetes();

   
    Paquete obtenerPaquetePorId(Long id);

    
    void eliminarPaquete(Long id);

	Paquete obtenerPaquetePorDni(Long id);
}
