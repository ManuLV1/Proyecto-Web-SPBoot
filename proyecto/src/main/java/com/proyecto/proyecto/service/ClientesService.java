package com.proyecto.proyecto.service;

import com.proyecto.proyecto.entidad.Cliente;
import com.proyecto.proyecto.repositorio.interfaz.IClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClientesService {

    @Autowired
    private IClientesRepository clientesRepository;

    public ArrayList<Cliente> getAll(){
        return (ArrayList<Cliente>) clientesRepository.findAll();
    }

    public Optional<Cliente> getById(BigInteger id){
        return clientesRepository.findById(id);
    }

    public Cliente create(Cliente cliente){
        return clientesRepository.save(cliente);
    }
}
