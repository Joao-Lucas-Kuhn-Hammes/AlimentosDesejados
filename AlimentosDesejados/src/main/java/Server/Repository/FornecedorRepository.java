package Server.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Server.Models.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

	Optional<Fornecedor> findById(Integer id);
	
	List<Fornecedor> findAll();
	
	Fornecedor findByEmailAndSenhaIn(String email, String senha);
	
	List<Fornecedor> findByNome(String nome);

	
}
