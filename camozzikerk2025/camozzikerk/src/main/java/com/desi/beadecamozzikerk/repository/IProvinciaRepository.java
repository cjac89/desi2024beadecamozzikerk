package com.desi.beadecamozzikerk.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desi.beadecamozzikerk.domain.Provincia;


@Repository
public interface IProvinciaRepository extends JpaRepository<Provincia, Long>{
	Optional<Provincia> findByNombre(String nombre);

}
