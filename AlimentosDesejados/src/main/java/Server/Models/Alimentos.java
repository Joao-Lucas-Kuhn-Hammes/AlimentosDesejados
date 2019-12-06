package Server.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "alimentos")
public class Alimentos implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	//atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private double preco;

	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	@JsonIgnore
	private Fornecedor fornecedor;
	
	@ManyToMany
	@JoinTable(name = "alimentos_receitas", joinColumns = @JoinColumn(name = "alimentos_id"), inverseJoinColumns = @JoinColumn(name = "receitas_id"))	
	@JsonIgnore
	@Nullable
	private List<Receitas> receitas;

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

	public Fornecedor getEmpresas() {
		return fornecedor;
	}

	public void setEmpresas(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}



	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Receitas> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receitas> receitas) {
		this.receitas = receitas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//construtores
	
	

	public Alimentos() {
		super();
	}

	public Alimentos(Integer id, String nome, double preco, Fornecedor fornecedor, List<Receitas> receitas) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.fornecedor = fornecedor;
		this.receitas = receitas;
	}
	
	//hash code

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((receitas == null) ? 0 : receitas.hashCode());
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
		Alimentos other = (Alimentos) obj;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
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
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (receitas == null) {
			if (other.receitas != null)
				return false;
		} else if (!receitas.equals(other.receitas))
			return false;
		return true;
	}

	
	
	
	
}
