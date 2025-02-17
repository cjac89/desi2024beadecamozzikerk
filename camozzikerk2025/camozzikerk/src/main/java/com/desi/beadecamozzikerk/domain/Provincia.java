package com.desi.beadecamozzikerk.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "provincias")
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long idProvincia;
	
	@Column(nullable = false)
	private String nombre;

    @OneToMany(mappedBy = "provincia")
    private List<Ciudad> ciudades;
    
	//Constructores
	public Provincia() {
		super();		
	}
	
	public Provincia(Long idProvincia, String nombre) {
		super();
		this.idProvincia = idProvincia;
		this.nombre = nombre; 
	}
	
	//Getters and Setters
	
	public Long getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
	    return nombre; 
	}

}
