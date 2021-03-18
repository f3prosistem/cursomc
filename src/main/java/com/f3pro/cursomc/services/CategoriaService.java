package com.f3pro.cursomc.services;

import com.f3pro.cursomc.domain.Categoria;
import com.f3pro.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;
// servico de consulta por  ID
    public Categoria buscar(Integer id){
        Optional<Categoria> obj =repository.findById(id);
        return obj.orElse(null);
    }

}
