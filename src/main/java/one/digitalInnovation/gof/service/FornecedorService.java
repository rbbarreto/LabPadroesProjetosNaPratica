package one.digitalInnovation.gof.service;

import org.springframework.stereotype.Service;

import one.digitalInnovation.gof.model.Cliente;
import one.digitalInnovation.gof.model.Fornecedor;

@Service
public interface FornecedorService {

	Iterable<Fornecedor> buscaTodos();
	
	Fornecedor BuscaPorId(Long id);
	
	void inserir(Fornecedor fornecedor);
	
	void atualizar(Long id, Fornecedor fornecedor);
	
	void deletar(Long id);
	
}
