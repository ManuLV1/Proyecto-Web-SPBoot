package com.proyecto.proyecto.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "clientes")
public class Cliente {

     
    @Column(name = "nombre_cliente")
    private String nombre_cliente;
    
    @Column(name = "apellido_cliente")
    private String apellido_cliente;
    
    @Column(name = "email_cliente")
    private String email_cliente;
    @Id
    @Column(name = "telefono_cliente")
    private BigInteger telefono_cliente;

	public Cliente(BigInteger telefono_cliente, String nombre_cliente, String apellido_cliente, String email_cliente) {
		this.telefono_cliente = telefono_cliente;
		this.nombre_cliente = nombre_cliente;
		this.apellido_cliente = apellido_cliente;
		this.email_cliente = email_cliente;
	}
        public Cliente(){
            
        }

	public BigInteger getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(BigInteger telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getApellido_cliente() {
		return apellido_cliente;
	}

	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
    
}
