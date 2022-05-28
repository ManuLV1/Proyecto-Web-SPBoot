package com.proyecto.proyecto.repositorio.interfaz;

import com.proyecto.proyecto.entidad.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface IClientesRepository extends CrudRepository<Cliente, BigInteger> {
}
