package com.desi.beadecamozzikerk.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desi.beadecamozzikerk.domain.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
	 Optional<Cliente> findByDni(Long dni);
	}




