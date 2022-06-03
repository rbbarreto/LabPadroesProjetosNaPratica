package one.digitalInnovation.gof.service;

import one.digitalInnovation.gof.model.Cliente;

/*
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. com 
 * isso, se necessário, podemos ter multiplas implementações dessa mesma 
 * interface.
 * 
 * @author Ricardo araujo
 * @Data : 01/06/2022
 */

public interface ClienteService {
	
	Iterable<Cliente> buscaTodos();
	
	Cliente buscaPorId(Long id);
	
	void inserir(Cliente cliente);
	
	void atualizar(Long id, Cliente cliente);
	
	void deletar(Long id);

}
