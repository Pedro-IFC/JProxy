package com.jproxy.app.Controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.jproxy.app.Entity.Produto;
import com.jproxy.app.Service.ProdutoService;

@RestController
@RequestMapping("/")
public class JProxyController {
	@Autowired
	private ProdutoService produtoService;
	
    @PostMapping("/inserir")
    public Produto inserirProduto(@RequestBody Produto produto) {
    	return this.produtoService.saveData(produto);
    }

    @PostMapping("/produto")
    public Produto getProduto(@RequestBody int id) {
    	return this.produtoService.getProduto(id);
    }
}