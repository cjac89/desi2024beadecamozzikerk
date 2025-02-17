package com.desi.beadecamozzikerk.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.beadecamozzikerk.domain.Cliente;
import com.desi.beadecamozzikerk.repository.IClienteRepository;
import com.desi.beadecamozzikerk.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;  

    @Override  // Se usa para indicar que el método está implementando el de la interfaz
    public boolean validarDni(Long dni) {
        Optional<Cliente> cliente = clienteRepository.findByDni(dni);
        
        return cliente.isPresent();
    }
    
    @Override
    public List<Cliente> obtenerTodosClientes() {
        return clienteRepository.findAll();  
    }

    @Override
    public void crearCliente(Cliente cliente) {
        clienteRepository.save(cliente);  
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);  
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);  
    }

    @Override
    public void editarCliente(Long id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {  // Verifica si el cliente existe en al BD
            cliente.setId(id);  
            clienteRepository.save(cliente);  // Guarda el cliente ya actualizado
        }
    }

    
    @Override
    public Optional<Cliente> buscarPorDni(Long dni) {
        return clienteRepository.findByDni(dni);  // Aquí llamas al repositorio para buscar por DNI
    }

    
}
