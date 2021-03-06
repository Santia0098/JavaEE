/**
 * 
 */
package com.platzi.ereservation.vista.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.negocio.services.ClienteService;
import com.platzi.ereservation.vista.resources.vo.ClienteVO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author sorth_
 *
 */

@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {

	private final ClienteService clienteService;

	public ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	@ApiOperation(value = "Crear cliente", notes = "Servicio para crear nuevo cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "solicitud invalida") })
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVo) {
		Cliente cliente = new Cliente();
		cliente.setNombreCli(clienteVo.getNombreCli());
		cliente.setApellidoCli(clienteVo.getApellidoCli());
		cliente.setDireccionCli(clienteVo.getDireccionCli());
		cliente.setTelefonoCli(clienteVo.getTelefonoCli());
		cliente.setEmailCli(clienteVo.getEmailCli());

		return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/{identificacion}")
	@ApiOperation(value = "actualizar cliente", notes = "Servicio para actualizar cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public ResponseEntity<Cliente> updateCliente(@PathVariable("identificacion") String identificacion,
			ClienteVO clienteVo) {
		Cliente cliente = this.clienteService.findByIdentificacion(identificacion);
		if (cliente == null) {

			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		} else {
			cliente.setNombreCli(clienteVo.getNombreCli());
			cliente.setApellidoCli(clienteVo.getApellidoCli());
			cliente.setDireccionCli(clienteVo.getDireccionCli());
			cliente.setTelefonoCli(clienteVo.getTelefonoCli());
			cliente.setEmailCli(clienteVo.getEmailCli());

			return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);
		}

	}

	@DeleteMapping("/{identificacion}")
	@ApiOperation(value = "elimniar cliente", notes = "Servicio para eliminar cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no eliminado") })
	public void removeCliente(@PathVariable("identificacion") String identificacion) {
		Cliente cliente = this.clienteService.findByIdentificacion(identificacion);

		if (cliente != null) {
			this.clienteService.delete(cliente);
		}
	}

	@GetMapping
	@ApiOperation(value = "Listar clientes", notes = "Servicio para listar todo cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente encontrado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.ok(this.clienteService.findAll());
	}
}
