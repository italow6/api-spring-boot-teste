package com.italoiran.cadastroclientes.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.italoiran.cadastroclientes.model.Cliente;
import com.italoiran.cadastroclientes.repository.ClienteRepository;





@Service
@Transactional
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;	
	
	@Autowired
	private EnderecoService enderecoService;
	
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> listarPorId(Long id) {
		return this.clienteRepository.findById(id);
	}
	
	public List<Cliente> listarEmail(String email) {
		return this.clienteRepository.findByEmail(email);
	}
	
	//public List<Cliente> listarCPF(String cpf) {
	//	return this.clienteRepository.findByCPF(cpf);
	//}
	
	public Cliente criar(Cliente cliente) {
		enderecoService.criar(cliente.getEndereco()); 
		return clienteRepository.save(cliente);
	}
	
}
