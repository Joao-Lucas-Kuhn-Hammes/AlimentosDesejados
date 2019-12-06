package Server.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Server.Models.Receitas;

public interface ReceitasRepository extends JpaRepository<Receitas, Integer> {

	Optional<Receitas> findById(Integer id);
	
	List<Receitas> findAll();
	

	
}
