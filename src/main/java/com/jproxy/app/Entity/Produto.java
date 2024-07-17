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
@Table(name="produto")
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	
	@Column(name="preco")
	private int preco;
	
	@Column(name="quantidade")
	private int quantidade;
}
