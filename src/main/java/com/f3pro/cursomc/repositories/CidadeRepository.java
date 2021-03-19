package com.f3pro.cursomc.repositories;

import com.f3pro.cursomc.domain.Categoria;
import com.f3pro.cursomc.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Integer> {
}
