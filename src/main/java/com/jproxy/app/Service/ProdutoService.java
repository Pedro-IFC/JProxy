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
		if(prod!=null) {
	        Instant now = Instant.now();
	        Instant prodTimestampInstant = Instant.ofEpochSecond(prod.getTimestamp().getSeconds(), prod.getTimestamp().getNanos());
	        Instant fiveMinutesAgo = now.minusSeconds(5 * 60);
	        if (prodTimestampInstant.isAfter(fiveMinutesAgo)) {
	    		Produto findById=produtoRepo.findById(id).orElse(null);
	    		prod.atualizar(findById);
	    		return findById;
	        }
	        return prod.getProduto();
		}
		Produto findById=produtoRepo.findById(id).orElse(null);
		ProdutoCacheado.getInstance().getProdutos().add(new ProdutoTimestamp(findById));
        return findById;
	}
}
