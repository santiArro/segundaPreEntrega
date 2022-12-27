package com.after.crud.repository;

import com.after.crud.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//estendermos los repositorios y llaves de tipo long
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
