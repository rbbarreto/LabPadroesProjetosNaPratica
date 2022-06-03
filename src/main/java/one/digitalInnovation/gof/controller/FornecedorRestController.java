package one.digitalInnovation.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalInnovation.gof.model.Fornecedor;
import one.digitalInnovation.gof.service.FornecedorService;

@RestController
@RequestMapping("Fornecedor")
public class FornecedorRestController {

	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping
	public ResponseEntity<Iterable<Fornecedor>> buscaTodos(){
		return ResponseEntity.ok(fornecedorService.buscaTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(fornecedorService.BuscaPorId(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> atualizar(@PathVariable Long id, 
											 @RequestBody Fornecedor fornecedor) {
		fornecedorService.atualizar(id, fornecedor);
		return ResponseEntity.ok(fornecedor);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Fornecedor> deletar(@PathVariable Long id) {
		fornecedorService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
