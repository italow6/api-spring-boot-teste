package com.italoiran.cadastroclientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.italoiran.cadastroclientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}