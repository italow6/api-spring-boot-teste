package com.italoiran.cadastroclientes.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.italoiran.cadastroclientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findByEmail(String email);
	
	//List<Cliente> findByCPF(String cpf);
	
}