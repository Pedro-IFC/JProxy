package com.jproxy.app.Service;

import org.springframework.stereotype.Service;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;

import com.jproxy.app.Entity.Produto;
import com.jproxy.app.ProdutoCacheado.ProdutoCacheado;
import com.jproxy.app.ProdutoCacheado.ProdutoTimestamp;
import com.jproxy.app.Repository.ProdutoRepo;
@Service 
public class ProdutoService {
	@Autowired
	private ProdutoRepo produtoRepo;
	
	public Produto saveData(Produto produto) {
		return this.produtoRepo.save(produto);
	}
	public Produto getProduto(int id) {
		ProdutoTimestamp prod = ProdutoCacheado.getInstance().getById(id);
        System.out.println("Verifica se o produto está em cache");
		if(prod!=null) {
	        System.out.println("Está em cache");
			Instant now = Instant.now();
	        Instant prodTimestampInstant = Instant.ofEpochSecond(prod.getTimestamp().getSeconds(), prod.getTimestamp().getNanos());
	        Instant fiveMinutesAgo = now.minusSeconds(20);
	        System.out.println("Verifica se o produto está no tempo válido");
	        if (prodTimestampInstant.isAfter(fiveMinutesAgo)) {
		        System.out.println("Está inválido e atualiza antes de retornar");
	    		Produto findById=produtoRepo.findById(id).orElse(null);
	    		prod.atualizar(findById);
	    		return findById;
	        }
	        System.out.println("Está válido");
	        return prod.getProduto();
		}
        System.out.println("Não está em cache");
		Produto findById=produtoRepo.findById(id).orElse(null);
        System.out.println("Adiciona ao cache");
		ProdutoCacheado.getInstance().getProdutos().add(new ProdutoTimestamp(findById));
        return findById;
	}
}
