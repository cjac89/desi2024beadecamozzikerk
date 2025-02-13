package com.desi.beadecamozzikerk.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudades")
public class Ciudad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementar ID
	private Long id;

	@Column(unique = true, nullable = false, length = 4)
	private int codigoPostal;

	@Column(nullable = false)
	private String ciudad;
	
	@Column(nullable = false)
	private String provincia;

	public Ciudad() {
		super();
	}
	
	public Ciudad(Long id, int codigoPostal, String cuidad, String provincia) {
		super();
		this.id = id;
		this.codigoPostal = codigoPostal;
		this.ciudad = cuidad;
		this.provincia = provincia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String cuidad) {
		this.ciudad = cuidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
