package one.digitalInnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalInnovation.gof.Repository.ClienteRepository;
import one.digitalInnovation.gof.Repository.EnderecoRepository;
import one.digitalInnovation.gof.model.Cliente;
import one.digitalInnovation.gof.model.Endereco;
import one.digitalInnovation.gof.service.ClienteService;
import one.digitalInnovation.gof.service.ViaCepService;

/*
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). com issso, como essa classe é um 
 * {@link Service}, ela será tratada com um <b>Singleton </b>
 * 
 * @author Ricardo Araujo
 */

@Service
public class ClienteServiceImpl implements ClienteService {

	// TODO Singleton: Injetar os componentes do Spring com @Autowired
	// TODO Strategy: Implementar os métodos definidos na interface
	// TODO Facade: Abstrair integrações com SubSistemas, provendo uma interface simples
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	
	@Override
	public Iterable<Cliente> buscaTodos() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscaPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);	
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvaClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvaClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}

	private void salvaClienteComCep(Cliente cliente) {
		// TODO Auto-generated method stub
		// TODO verificar se o endereco existe do cliente já existe (pelo cep)
		 String cep = cliente.getEndereco().getCep();
		 Endereco endereco = enderecoRepository.findById(cep).orElseGet(()-> {
			 Endereco novoEndereco = viaCepService.consultarCep(cep);
			 enderecoRepository.save(novoEndereco);
			 return novoEndereco;
		 });
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

	
}
