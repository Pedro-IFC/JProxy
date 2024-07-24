package com.jproxy.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@Table(name="produtos")
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
	@Id
	@Column(name="id")
	@GeneratedValue
	public int id;
	
	@Column(name="nome")
	public String nome;
	
	
	@Column(name="preco")
	public int preco;
	
	@Column(name="quantidade")
	public int quantidade;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Produto [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", preco=");
		builder.append(preco);
		builder.append(", quantidade=");
		builder.append(quantidade);
		builder.append("]");
		return builder.toString();
	}
	
}
