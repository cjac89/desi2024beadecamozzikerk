package com.desi.beadecamozzikerk.service;

import java.util.List;
import java.util.Optional;

import com.desi.beadecamozzikerk.domain.Cliente;

public interface IClienteService {
    boolean validarDni(Long dni);  // Es el método para validar el DNI del cliente
    List<Cliente> obtenerTodosClientes();  // Obtener todos los clientes

    void crearCliente(Cliente cliente);  

    void eliminarCliente(Long id);  

    Optional<Cliente> obtenerClientePorId(Long id);  

    void editarCliente(Long id, Cliente cliente);  
    
    Optional<Cliente> buscarPorDni(Long dni);
}

