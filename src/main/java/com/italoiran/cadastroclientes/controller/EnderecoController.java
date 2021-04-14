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

import com.italoiran.cadastroclientes.model.Endereco;

import com.italoiran.cadastroclientes.service.EnderecoService;



@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	public List<Endereco> listar() {
		return enderecoService.listarEndereco();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Endereco> listarPorIdEndereco(@PathVariable long id){
	   return enderecoService.listarPorId(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Endereco criar(@RequestBody Endereco endereco) {
		return enderecoService.criar(endereco);
	}
	
		
}
