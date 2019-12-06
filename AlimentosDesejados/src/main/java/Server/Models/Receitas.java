package Server.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "receitas")
public class Receitas implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	//atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	
	
	@ManyToMany(mappedBy="receitas")
	private List<Alimentos> alimentos;
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "receitas_user", joinColumns = @JoinColumn(name = "receitas_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))	
	@Nullable
	private List<User> users;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	
	//getters n setters
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Alimentos> getAlimentos() {
		return alimentos;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setAlimentos(List<Alimentos> alimentos) {
		this.alimentos = alimentos;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//controllers
	


	public Receitas() {
		super();
	}

	public Receitas(Integer id, String nome, String descricao, List<Alimentos> alimentos, List<User> users) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.alimentos = alimentos;
		this.users = users;
	}

	//hashcode
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alimentos == null) ? 0 : alimentos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	
	//equals
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receitas other = (Receitas) obj;
		if (alimentos == null) {
			if (other.alimentos != null)
				return false;
		} else if (!alimentos.equals(other.alimentos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
}
