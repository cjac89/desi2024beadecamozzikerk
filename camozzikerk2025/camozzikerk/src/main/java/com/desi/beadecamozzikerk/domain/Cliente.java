package com.desi.beadecamozzikerk.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(unique = true, nullable = false, length = 8)
	private Long dni;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String apellido;

	@Column(nullable = false)
	private String email; 
	
	  @OneToMany(mappedBy = "remitente")
	    private List<Paquete> paquetesEnviados; // Relación con Paquete enviadaos

	    @OneToMany(mappedBy = "destinatario")
	    private List<Paquete> paquetesRecibidos; // Relación con Paquete recibidos
	
	public Cliente() {
		super();
		
	}
	
	 public Cliente(Long id, Long dni, String nombre, String apellido) {
			super();
			this.id = id;
			this.dni = dni; 
			this.nombre = nombre; 
			this.apellido= apellido;
		}
	//Getters and Setters
	public Long getId() {
		return id;
	}

	

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Paquete> getPaquetesEnviados() {
        return paquetesEnviados;
    }

    public void setPaquetesEnviados(List<Paquete> paquetesEnviados) {
        this.paquetesEnviados = paquetesEnviados;
    }

    public List<Paquete> getPaquetesRecibidos() {
        return paquetesRecibidos;
    }

    public void setPaquetesRecibidos(List<Paquete> paquetesRecibidos) {
        this.paquetesRecibidos = paquetesRecibidos;
    }
	
	

}
