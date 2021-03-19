package com.f3pro.cursomc.repositories;

import com.f3pro.cursomc.domain.Categoria;
import com.f3pro.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
}
