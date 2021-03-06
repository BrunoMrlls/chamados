package br.com.chamadosweb.service.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name="empresa")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nomeEmpresa")
	private String nomeEmpresa;	
	
	@Column(name = "palavraPasse")
	private String palavraPasse;

	public Empresa() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}		

	public String getPalavraPasse() {
		return palavraPasse;
	}

	public void setPalavraPasse(String palavraPasse) {
		this.palavraPasse = palavraPasse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}