package com.jproxy.app.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.jproxy.app.Entity.Produto;
import com.jproxy.app.Repository.ProdutoRepo;
@Service 
public class ProdutoService {
	@Autowired
	private ProdutoRepo produtoRepo;
	
	public Produto saveData(Produto produto) {
		return this.produtoRepo.save(produto);
	}
}
