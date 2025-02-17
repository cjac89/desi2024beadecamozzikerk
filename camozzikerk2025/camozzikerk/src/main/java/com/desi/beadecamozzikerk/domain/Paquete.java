package com.desi.beadecamozzikerk.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaquete;

    private double peso;
    
    private boolean fragil =  false; 
       
    @ManyToOne
    @JoinColumn(name = "destino_id", nullable = false) 
    private Ciudad destino;
    
    @ManyToOne
    @JoinColumn(name = "origen_id", nullable = false) 
    private Ciudad origen;

    
    @ManyToOne
    @JoinColumn(name = "remitente_id", nullable = false) // Relación con Cliente remitente del paquete
    private Cliente remitente; // Remitente (Cliente)

    @ManyToOne
    @JoinColumn(name = "destinatario_id", nullable = false) // Relación con Cliente destinatario del paquete
    private Cliente destinatario; 
    
    // Getters y Setters

    public Long getId() {
        return idPaquete;
    }

    public void setId(Long idPaquete) {
        this.idPaquete = idPaquete;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isFragil() {
        return fragil;
    }

    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }
    
    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }
    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public Cliente getRemitente() {
        return remitente;
    }

    public void setRemitente(Cliente remitente) {
        this.remitente = remitente;
    }

    public Cliente getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Cliente destinatario) {
        this.destinatario = destinatario;
    }
}
