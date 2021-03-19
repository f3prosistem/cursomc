package com.f3pro.cursomc.repositories;

import com.f3pro.cursomc.domain.Categoria;
import com.f3pro.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer> {
}
