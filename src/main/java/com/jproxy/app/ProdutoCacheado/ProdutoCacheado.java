package com.jproxy.app.ProdutoCacheado;

import java.util.ArrayList;
import java.util.List;

public class ProdutoCacheado {
	private static ProdutoCacheado instance;
	private List<ProdutoTimestamp> produtos;
	private ProdutoCacheado() {
		setProdutos(new ArrayList<>());
	}
	public static ProdutoCacheado getInstance() {
		if(instance==null) {
			instance=new ProdutoCacheado();
		}
		return instance;
	}
	public ProdutoTimestamp getById(int id) {
		for(int i = 0; i<produtos.size();i++) {
			if(produtos.get(i).getProduto().id==id) {
				return produtos.get(i);
			}
		}
		return null;
	}
	public List<ProdutoTimestamp> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<ProdutoTimestamp> produtos) {
		this.produtos = produtos;
	}
}