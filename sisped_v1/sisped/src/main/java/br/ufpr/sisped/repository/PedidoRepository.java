package br.ufpr.sisped.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpr.sisped.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
