package com.jproxy.app.Tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jproxy.app.ProdutoCacheado.ProdutoCacheado;

@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 20000)
    public void manterCacheado() {
    	for(int i=0; i<ProdutoCacheado.getInstance().getProdutos().size();i++) {
    		if(!ProdutoCacheado.getInstance().getProdutos().get(i).manter()) {
    			System.out.println("Saiu do cache: " + ProdutoCacheado.getInstance().getProdutos().get(i).getProduto().toString());
    			ProdutoCacheado.getInstance().getProdutos().remove(i);
    			i--;
    		}else {
//    			ProdutoCacheado.getInstance().getProdutos().get(i).atualizar();
    		}
    	}
    }
}
