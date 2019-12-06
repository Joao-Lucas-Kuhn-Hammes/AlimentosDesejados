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

import Server.Models.Fornecedor;
import Server.Repository.FornecedorRepository;

@CrossOrigin
@RestController
@RequestMapping("/fornecedor/")
public class FornecedorController {
	@Autowired
	private FornecedorRepository fornecedorR;

	@GetMapping("{id}")
	public Fornecedor getFornecedor(@PathVariable(name = "id") Integer id) {
		return fornecedorR.findById(id).get();
	}
	@GetMapping("{nome}")
	public List<Fornecedor> getForcedorByNome(@PathVariable(name = "nome") String nome) {
		return fornecedorR.findByNome(nome);
	}
	
	@GetMapping("{email}/{senha}")
	public Fornecedor login(@PathVariable(name="email")String email,@PathVariable(name="senha")String senha) {
		return fornecedorR.findByEmailAndSenhaIn(email, senha);
	}
	@GetMapping()
	public List<Fornecedor> getAll() {
		return fornecedorR.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Fornecedor> adicionar(@RequestBody Fornecedor novo) {
		return ResponseEntity.ok(fornecedorR.save(novo));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		if (fornecedorR.existsById(id)) {
			fornecedorR.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping()
	public ResponseEntity<Fornecedor> atualizar(@RequestBody Fornecedor novo) {
			Fornecedor old = fornecedorR.getOne(novo.getId());
			old = novo;

			old = fornecedorR.save(old);

			return ResponseEntity.ok(old);

	}
}
