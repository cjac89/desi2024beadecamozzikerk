package com.desi.beadecamozzikerk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desi.beadecamozzikerk.domain.Camion;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface ICamionRepository extends JpaRepository<Camion, Long> {
    List<Camion> findByPatenteContaining(String patente);
    List<Camion> findByCiudadActualCodigoPostal(Integer codigoPostal);
}



