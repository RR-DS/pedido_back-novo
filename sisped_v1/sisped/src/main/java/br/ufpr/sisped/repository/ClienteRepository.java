package br.ufpr.sisped.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;

import br.ufpr.sisped.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);

}
