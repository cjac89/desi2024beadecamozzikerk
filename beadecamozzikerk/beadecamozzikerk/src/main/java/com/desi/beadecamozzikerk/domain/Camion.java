package com.desi.beadecamozzikerk.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "camiones")
public class Camion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementar ID
	@Column(name = "camion_id")
	private Long id;

	@Column(name = "patente", unique = true, nullable = false)
	private String patente;

	
	@Column(nullable = false)
	private String marca;

	@Column(nullable = false, length = 4)
	private int modelo; // Año de fabricación
	
	@ManyToOne
    @JoinColumn(name = "ciudad_actual_id")
    private Ciudad ciudadActual;
	
	public Camion() {
	    // Constructor vacío necesario para la deserialización
	}


	public Camion(Long id, String patente, String marca, int modelo, Ciudad ciudadActual) {
		super();
		this.id = id;
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.ciudadActual = ciudadActual;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public Ciudad getCiudadActual() {
		return ciudadActual;
	}

	public void setCiudadActual(Ciudad ciudadActual) {
		this.ciudadActual = ciudadActual;
	}

	
}
