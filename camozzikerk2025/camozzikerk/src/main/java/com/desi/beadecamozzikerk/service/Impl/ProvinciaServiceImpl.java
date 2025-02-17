package com.desi.beadecamozzikerk.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.beadecamozzikerk.domain.Provincia;
import com.desi.beadecamozzikerk.repository.IProvinciaRepository;
import com.desi.beadecamozzikerk.service.IProvinciaService;

@Service
public class ProvinciaServiceImpl implements IProvinciaService {
	
	@Autowired
	private IProvinciaRepository provinciaRepository;

	@Override
	public List<Provincia> listarProvincias() {
		return provinciaRepository.findAll(); 
	}

	@Override
	public Provincia buscarPorId(Long id) {
		return provinciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Provincia no encontrada"));
	}

	@Override
	public Provincia buscarPorNombre(String nombre) {
		return provinciaRepository.findByNombre(nombre).orElseThrow(() -> new RuntimeException("Provincia no encontrada"));
	}

	@Override
	public Provincia guardarProvincia(Provincia provincia) {
		
		return provinciaRepository.save(provincia);
	}

	@Override
	public void eliminarProvincia(Long id) {
		 provinciaRepository.deleteById(id);		
	}

}
