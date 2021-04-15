package com.italoiran.cadastroclientes.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.italoiran.cadastroclientes.model.Cliente;

import com.italoiran.cadastroclientes.service.ClienteService;



@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteService.listarClientes();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Cliente> listarPorIdCliente(@PathVariable long id){
	   return clienteService.listarPorId(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = {"/email/{email}"})
	public List<Cliente> listarPorEmail(@PathVariable String email){
	   return clienteService.listarEmail(email);
	}
	
	//@GetMapping(path = {"/cpf/{cpf}"})
	//public List<Cliente> listarPorCPF(@PathVariable String cpf){
	//   return clienteService.listarCPF(cpf);
	//}	
	
	@PostMapping
	public Cliente criar(@RequestBody Cliente cliente) {
		return clienteService.criar(cliente);
	}
	
		
}
