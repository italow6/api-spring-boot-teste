package com.italoiran.cadastroclientes.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.italoiran.cadastroclientes.model.Endereco;
import com.italoiran.cadastroclientes.repository.EnderecoRepository;





@Service
@Transactional
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;	
	
	public List<Endereco> listarEndereco(){
		return enderecoRepository.findAll();
	}
	
	public Optional<Endereco> listarPorId(Long id) {
		return this.enderecoRepository.findById(id);
	}
	
	public Endereco criar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
}
