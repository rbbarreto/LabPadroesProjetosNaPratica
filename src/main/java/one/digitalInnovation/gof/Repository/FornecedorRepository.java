package one.digitalInnovation.gof.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import one.digitalInnovation.gof.model.Fornecedor;

@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, Long> {

}
