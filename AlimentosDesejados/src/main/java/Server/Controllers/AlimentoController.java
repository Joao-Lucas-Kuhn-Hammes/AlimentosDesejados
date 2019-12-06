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

import Server.Models.Alimentos;
import Server.Repository.AlimentosRepository;

@CrossOrigin
@RestController
@RequestMapping("/alimento/")
public class AlimentoController {
	@Autowired
	private AlimentosRepository alimentoR;

	@GetMapping("{id}")
	public Alimentos getAlimento(@PathVariable(name = "id") Integer id) {
		return alimentoR.findById(id).get();
	}
	
	@GetMapping()
	public List<Alimentos> getAll() {
		return alimentoR.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Alimentos> adicionar(@RequestBody Alimentos novo) {
		return ResponseEntity.ok(alimentoR.save(novo));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		if (alimentoR.existsById(id)) {
			alimentoR.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping()
	public ResponseEntity<Alimentos> atualizar(@RequestBody Alimentos novo) {
			Alimentos old = alimentoR.getOne(novo.getId());
			old = novo;
			old = alimentoR.save(old);

			return ResponseEntity.ok(old);

	}
}
