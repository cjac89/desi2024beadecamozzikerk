package com.desi.beadecamozzikerk.service;

import java.util.List;


import com.desi.beadecamozzikerk.domain.Provincia;

public interface IProvinciaService {
	
	  List<Provincia> listarProvincias();
	  
	    Provincia buscarPorId(Long id);
	    
	    Provincia buscarPorNombre(String nombre);
	    
	    Provincia guardarProvincia(Provincia provincia);
	    
	    void eliminarProvincia(Long id);
	}
	

