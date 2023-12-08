package br.ufpr.sisped.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import br.ufpr.sisped.model.Cliente;
import br.ufpr.sisped.model.ClienteDTO;
import br.ufpr.sisped.model.ItemPedido;
import br.ufpr.sisped.model.ItemPedidoDTO;
import br.ufpr.sisped.repository.ClienteRepository;
import br.ufpr.sisped.repository.ItemPedidoRepository;
import br.ufpr.sisped.model.Pedido;
import br.ufpr.sisped.model.PedidoDTO;
import br.ufpr.sisped.model.Produto;
import br.ufpr.sisped.model.ProdutoDTO;
import br.ufpr.sisped.repository.PedidoRepository;
import br.ufpr.sisped.repository.ProdutoRepository;

@CrossOrigin
@RestController
public class SisPedRest {
	
	@Autowired
	private ClienteRepository _clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/clientes")
	List<ClienteDTO> listarClientesTodos() {
		List<Cliente> lc = _clienteRepository.findAll();
		return lc.stream()
				.map(c -> mapper.map(c, ClienteDTO.class))
				.collect(Collectors.toList());
	}
	/*
	 * public List<Cliente> Get() { return _clienteRepository.findAll();
	 * 
	 * }
	 */
	
	@GetMapping("/clientes/{id}")
	public Cliente listarClientesId2(@PathVariable("id") Long id) {
		Cliente c = _clienteRepository.findById(id).stream()
				.filter(client -> client.getId() == id)
				.findAny().orElse(null);
		return c;
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDTO inserirCliente(@RequestBody ClienteDTO cliente) {
		_clienteRepository.save(mapper.map(cliente, Cliente.class));
		Optional<Cliente> cli = _clienteRepository.findByCpf(cliente.getCpf());
		return mapper.map(cli.get(), ClienteDTO.class);
	}
	/*
	 * public Cliente Post(@RequestBody Cliente cliente) { return
	 * _clienteRepository.save(cliente);
	 * 
	 * }
	 */
	
	/*@RequestMapping(value = {"/cliente/{id}"}, 
			  produces = "application/json", 
			  method=RequestMethod.PUT)*/
	
	/*
	 * @PutMapping("/clientes/{id}") public ResponseEntity<Object>
	 * Put(@PathVariable(value = "id") Long id, @RequestBody Cliente newCliente) {
	 * Optional<Cliente> oldCliente = _clienteRepository.findById(id);
	 * 
	 * if (oldCliente.isPresent()) { Cliente cliente = oldCliente.get();
	 * cliente.setNome(newCliente.getNome()); _clienteRepository.save(cliente);
	 * return new ResponseEntity<Object>(cliente, HttpStatus.OK); } else { return
	 * new ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 */
	 
	@PutMapping("/clientes/{id}")
	public ClienteDTO alterarClienteId(@PathVariable("id") Long id, @RequestBody ClienteDTO cliente) {
		Cliente cu = _clienteRepository.findById(id).stream()
				.filter(clie -> clie.getId() == id)
				.findAny().orElse(null);
		
		if (cu != null) { 
			cu.setCpf(cliente.getCpf());
			cu.setNome(cliente.getNome());
			cu.setSobrenome(cliente.getSobrenome());
			_clienteRepository.save(cu);
		}
		return mapper.map(cu, ClienteDTO.class);
	}
	/*
	 * @PutMapping("/clientes/{id}") public Cliente
	 * alterarCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
	 * Cliente upcli = _clienteRepository.findById(id).stream() .filter(upclient ->
	 * upclient.getId() == id) .findAny().orElse(null);
	 * 
	 * if (upcli != null) { upcli.setCpf(cliente.getCpf());
	 * upcli.setNome(cliente.getNome()); upcli.setSobrenome(cliente.getSobrenome());
	 * }
	 * 
	 * return upcli; }
	 */
		/*
		 * List<ClienteDTO> listarTodos() { List<Cliente> lista =
		 * _clienteRepository.findAll(); return lista.stream() .map(c -> mapper.map(c,
		 * ClienteDTO.class)) .collect(Collectors.toList()); }
		 */
	
	
	  @DeleteMapping("/clientes/{id}")
		/*
		 * public Cliente removerClientesId(@PathVariable("id") Long id) { Cliente rc =
		 * _clienteRepository.findById(id).stream() .filter(clientr -> clientr.getId()
		 * == id) .findAny().orElse(null);
		 * 
		 * if (rc != null) { _clienteRepository.deleteAllById(rc.getId()==id);
		 * 
		 * return rc;
		 * 
		 * } }
		 */
	  
	  
	  public ResponseEntity<Object> Delete(@PathVariable(value = "id") Long id) {
	    Optional<Cliente> cliente = _clienteRepository.findById(id);

	    if (cliente.isPresent()) {
	    	_clienteRepository.delete(cliente.get());
	      return new ResponseEntity<>(HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @GetMapping("/clientes/pedidos")
		List<PedidoDTO> listarPedidosTodos() {
			List<Pedido> ped = pedidoRepository.findAll();
			return ped.stream()
					.map(p -> mapper.map(p, PedidoDTO.class))
					.collect(Collectors.toList());
		}
		
		@GetMapping("/clientes/pedidos/{id}")
		public Pedido listarPedidosId(@PathVariable("id") Long id) {
			Pedido p = pedidoRepository.findById(id).stream()
					.filter(ped -> ped.getId() == id)
					.findAny().orElse(null);
			return p;
		}
		
		@PostMapping("/clientes/pedidos")
		public PedidoDTO inserirPedido(@RequestBody PedidoDTO pedido) {
			pedidoRepository.save(mapper.map(pedido, Pedido.class));
			Optional<Pedido> ped = pedidoRepository.findById(pedido.getId());
			return mapper.map(ped, PedidoDTO.class);
		}
		
		@PutMapping("/clientes/pedidos/{id}")
		public PedidoDTO alterarPedidoId(@PathVariable("id") Long id, @RequestBody PedidoDTO pedido) {
			Pedido pa = pedidoRepository.findById(id).stream()
					.filter(peda -> peda.getId() == id)
					.findAny().orElse(null);
			
			if (pa != null) { 
				pa.setData(pedido.getData());
				pa.setIdcliente(pedido.getIdcliente());
				pedidoRepository.save(pa);
			}
			return mapper.map(pa, PedidoDTO.class);
		}
		
		@DeleteMapping("/clientes/pedidos/{id}")
		public ResponseEntity<Object> DeletePedido(@PathVariable(value = "id") Long id) {
	    Optional<Pedido> pedido = pedidoRepository.findById(id);

	    if (pedido.isPresent()) {
	    	pedidoRepository.delete(pedido.get());
	      return new ResponseEntity<>(HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
		}
	    
		@GetMapping("/clientes/pedidos/itenspedidos")
		List<PedidoDTO> listarItensPedidosTodos() {
			List<Pedido> ped = pedidoRepository.findAll();
			return ped.stream()
					.map(p -> mapper.map(p, PedidoDTO.class))
					.collect(Collectors.toList());
		}
		
		@GetMapping("/clientes/pedidos/itenspedidos/{id}")
		public ItemPedido listarItensPedidosId(@PathVariable("id") Long id) {
			ItemPedido ip = itemPedidoRepository.findById(id).stream()
					.filter(pedit -> pedit.getId() == id)
					.findAny().orElse(null);
			return ip;
		}
		
		@PostMapping("/clientes/pedidos/itenspedidos")
		public ItemPedidoDTO inserirItemPedido(@RequestBody ItemPedidoDTO itempedido) {
			itemPedidoRepository.save(mapper.map(itempedido, ItemPedido.class));
			Optional<ItemPedido> pedit = itemPedidoRepository.findById(itempedido.getId());
			return mapper.map(pedit, ItemPedidoDTO.class);
		}
		
		@PutMapping("/clientes/pedidos/itenspedidos/{id}")
		public ItemPedidoDTO alterarItemPedidoId(@PathVariable("id") Long id, @RequestBody ItemPedidoDTO itempedido) {
			ItemPedido pai = itemPedidoRepository.findById(id).stream()
					.filter(pedai -> pedai.getId() == id)
					.findAny().orElse(null);
			
			if (pai != null) { 
				pai.setIdproduto(itempedido.getIdproduto());
				pai.setQtdade(itempedido.getQtdade());
				itemPedidoRepository.save(pai);
			}
			return mapper.map(pai, ItemPedidoDTO.class);
		}
		
		@DeleteMapping("/clientes/pedidos/itenspedidos/{id}")
		public ResponseEntity<Object> DeleteItemPedido(@PathVariable(value = "id") Long id) {
	    Optional<ItemPedido> itempedido = itemPedidoRepository.findById(id);

	    if (itempedido.isPresent()) {
	    	itemPedidoRepository.delete(itempedido.get());
	      return new ResponseEntity<>(HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
		}
		
		@GetMapping("/produtos")
		List<ProdutoDTO> listarProdutosTodos() {
			List<Produto> prod = produtoRepository.findAll();
			return prod.stream()
					.map(pd -> mapper.map(pd, ProdutoDTO.class))
					.collect(Collectors.toList());
		}
		
		@GetMapping("/produtos/{id}")
		public Produto listarProdutosId(@PathVariable("id") Long id) {
			Produto prd = produtoRepository.findById(id).stream()
					.filter(prod -> prod.getId() == id)
					.findAny().orElse(null);
			return prd;
		}
		
		@PostMapping("/produtos")
		public ProdutoDTO inserirProduto(@RequestBody ProdutoDTO produto) {
			produtoRepository.save(mapper.map(produto, Produto.class));
			Optional<Produto> prodi = produtoRepository.findById(produto.getId());
			return mapper.map(prodi, ProdutoDTO.class);
		}
		
		@PutMapping("/produtos/{id}")
		public ProdutoDTO alterarProdutoId(@PathVariable("id") Long id, @RequestBody ProdutoDTO produto) {
			Produto pda = produtoRepository.findById(id).stream()
					.filter(proda -> proda.getId() == id)
					.findAny().orElse(null);
			
			if (pda != null) { 
				pda.setDescricao(produto.getDescricao());
				produtoRepository.save(pda);
			}
			return mapper.map(pda, ProdutoDTO.class);
		}
		
		@DeleteMapping("/produtos/{id}")
		public ResponseEntity<Object> DeleteProduto(@PathVariable(value = "id") Long id) {
	    Optional<Produto> produto = produtoRepository.findById(id);

	    if (produto.isPresent()) {
	    	produtoRepository.delete(produto.get());
	      return new ResponseEntity<>(HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
		}

}
