package com.desi.beadecamozzikerk.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.beadecamozzikerk.domain.Camion;
import com.desi.beadecamozzikerk.repository.ICamionRepository;
import com.desi.beadecamozzikerk.service.ICamionService;

@Service
public class CamionServiceImpl implements ICamionService {

    @Autowired
    private ICamionRepository camionRepository;

    @Override
    public void guardar(Camion camion) {
        camionRepository.save(camion);
    }

    @Override
    public List<Camion> getCamiones() {
        return camionRepository.findAll();
    }

    @Override
    public void borrar(Long id) {
        camionRepository.deleteById(id);
    }
}