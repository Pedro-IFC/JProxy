package com.jproxy.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jproxy.app.Entity.Produto;

public interface ProdutoRepo extends JpaRepository<Produto, Integer>{

}
