package com.jproxy.app.ProdutoCacheado;

import com.google.protobuf.Timestamp;
import com.jproxy.app.Controller.JProxyController;
import com.jproxy.app.Entity.Produto;

import java.time.Instant;

public class ProdutoTimestamp {
    private Timestamp timestamp;
    private Produto produto;
    private int ocorrencia;
    public ProdutoTimestamp(Produto produto) {
        this.produto = produto;
        this.timestamp = getCurrentTimestamp();
        this.ocorrencia=1;
    }
    public void atualizar(Produto prod) {
        this.produto = prod;
        this.timestamp = getCurrentTimestamp();
        this.ocorrencia=1;
    }
    public void atualizar() {
        this.produto = new JProxyController().getProduto(produto.id);
        this.timestamp = getCurrentTimestamp();
        this.ocorrencia=1;
    }
    private Timestamp getCurrentTimestamp() {
        Instant now = Instant.now();
        return Timestamp.newBuilder()
                .setSeconds(now.getEpochSecond())
                .setNanos(now.getNano())
                .build();
    }
    public boolean manter() {
    	return ocorrencia>-2;
    }
    public void incrementarOcorrencia() {
    	this.ocorrencia=1;
    }
    public void desincrementarOcorrencia() {
    	this.ocorrencia--;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
	public int getOcorrencia() {
		return ocorrencia;
	}
	public void setOcorrencia(int ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
}
