package Server.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;


@Entity
@Table(name = "user")
public class User implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	//atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique=true, nullable=false) 
	private String email;
	private String senha;
	private String nome;
	private Integer hrLevantar;
	private	Integer hrDormir;
	private int altura;
	private double metaDePeso;
	private int idade;
	private boolean notificar;
	
	@ElementCollection
	private List<Double> pesos;
	
	@ManyToMany(mappedBy="users")
	@Nullable
	private List<Receitas> receitas = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	@Nullable
	private List<Receitas> criadas = new ArrayList<>();
	
	
	//getters n setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getHrLevantar() {
		return hrLevantar;
	}

	public void setHrLevantar(Integer hrLevantar) {
		this.hrLevantar = hrLevantar;
	}

	public int getHrDormir() {
		return hrDormir;
	}

	public void setHrDormir(Integer hrDormir) {
		this.hrDormir = hrDormir;
	}

	public List<Double> getPesos() {
		return pesos;
	}

	public void setPesos(List<Double> pesos) {
		this.pesos = pesos;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public double getMetaDePeso() {
		return metaDePeso;
	}

	public void setMetaDePeso(double metaDePeso) {
		this.metaDePeso = metaDePeso;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public boolean isNotificar() {
		return notificar;
	}

	public void setNotificar(boolean notificar) {
		this.notificar = notificar;
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

	//hash code
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + altura;
		result = prime * result + ((criadas == null) ? 0 : criadas.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + hrDormir;
		result = prime * result + hrLevantar;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + idade;
		long temp;
		temp = Double.doubleToLongBits(metaDePeso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (notificar ? 1231 : 1237);
		result = prime * result + ((pesos == null) ? 0 : pesos.hashCode());
		result = prime * result + ((receitas == null) ? 0 : receitas.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		User other = (User) obj;
		if (altura != other.altura)
			return false;
		if (criadas == null) {
			if (other.criadas != null)
				return false;
		} else if (!criadas.equals(other.criadas))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (hrDormir != other.hrDormir)
			return false;
		if (hrLevantar != other.hrLevantar)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idade != other.idade)
			return false;
		if (Double.doubleToLongBits(metaDePeso) != Double.doubleToLongBits(other.metaDePeso))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (notificar != other.notificar)
			return false;
		if (pesos == null) {
			if (other.pesos != null)
				return false;
		} else if (!pesos.equals(other.pesos))
			return false;
		if (receitas == null) {
			if (other.receitas != null)
				return false;
		} else if (!receitas.equals(other.receitas))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	 
	//construtores
	  
	public User(Integer id, String email, String senha, String nome, Integer hrLevantar, Integer hrDormir, List<Double> pesos,
			int altura, double metaDePeso, int idade, boolean notificar, List<Receitas> receitas) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.hrLevantar = hrLevantar;
		this.hrDormir = hrDormir;
		this.pesos = pesos;
		this.altura = altura;
		this.metaDePeso = metaDePeso;
		this.idade = idade;
		this.notificar = notificar;
		this.receitas = receitas;
	}


	public User() {
		super();
	}

	
	
	
}
