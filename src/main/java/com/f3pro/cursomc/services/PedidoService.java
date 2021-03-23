package com.f3pro.cursomc.services;

import com.f3pro.cursomc.domain.Pedido;
import com.f3pro.cursomc.repositories.PedidoRepository;
import com.f3pro.cursomc.services.exeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;
// servico de consulta por  ID

    public Pedido find(Integer id) {
        Optional<Pedido> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }

}
