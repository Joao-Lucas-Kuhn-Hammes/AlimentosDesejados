package Server.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Server.Models.Alimentos;

public interface AlimentosRepository extends JpaRepository<Alimentos, Integer> {

	Optional<Alimentos> findById(Integer id);
	
	List<Alimentos> findAll();
	

	
}
