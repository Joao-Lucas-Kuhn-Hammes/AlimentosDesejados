package Server.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Server.Models.Receitas;
import Server.Repository.ReceitasRepository;

@CrossOrigin
@RestController
@RequestMapping("/receita/")
public class ReceitaController {
	@Autowired
	private ReceitasRepository receitasR;

	@GetMapping("{id}")
	public Receitas getReceita(@PathVariable(name = "id") Integer id) {
		return receitasR.findById(id).get();
	}
	
	@GetMapping()
	public List<Receitas> getAll() {
		return receitasR.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Receitas> adicionar(@RequestBody Receitas novo) {
		return ResponseEntity.ok(receitasR.save(novo));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		if (receitasR.existsById(id)) {
			receitasR.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping()
	public ResponseEntity<Receitas> atualizar(@RequestBody Receitas novo) {
			Receitas old = receitasR.getOne(novo.getId());
			old = novo;

			old = receitasR.save(old);

			return ResponseEntity.ok(old);

	}
}
