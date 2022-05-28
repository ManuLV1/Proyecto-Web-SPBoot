package com.proyecto.proyecto.controlador;

import com.proyecto.proyecto.dto.GeneralResponseDTO;
import com.proyecto.proyecto.entidad.Cliente;
import com.proyecto.proyecto.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping("/")
    public ResponseEntity<List<Cliente>> getAllClients() {
        return ResponseEntity.ok().body(clientesService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> getClientById(@PathVariable BigInteger id) {
        return ResponseEntity.ok().body(clientesService.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity<GeneralResponseDTO> createClient(@RequestBody Cliente client) {
        try {
            if (client.getTelefono_cliente() == null) {
                GeneralResponseDTO response = new GeneralResponseDTO();
                response.setMessage("La cédula del cliente es obligatoria");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            Cliente clientExist = clientesService.getById(client.getTelefono_cliente()).orElse(null);
            if (clientExist != null) {
                GeneralResponseDTO response = new GeneralResponseDTO();
                response.setMessage("Este cliente ya existe");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
            }
            clientesService.create(client);
            GeneralResponseDTO response = new GeneralResponseDTO();
            response.setMessage("Registro creado satisfactoriamente");
            return ResponseEntity.ok().body(response);
        } catch (Exception exception) {
            GeneralResponseDTO response = new GeneralResponseDTO();
            response.setMessage("ERROR INTERNO EN EL SERVIDOR EXCEPCIÓN DE TIPO: " + exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
}
