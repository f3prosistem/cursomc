package com.f3pro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.f3pro.cursomc.domain.Categoria;
import com.f3pro.cursomc.repositories.CategoriaRepository;
import com.f3pro.cursomc.services.exeptions.DataIntegrityException;
import com.f3pro.cursomc.services.exeptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
// servico de consulta por  ID

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);// garantindo que vai ser um novo objeto inserido
		return repository.save(obj);
	}

	// atualizar a categoria
	public Categoria update(Categoria obj) {
		find(obj.getId());// valindado se existe a Id categoria
		return repository.save(obj);
	}

	// serviço para deletar
	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}

}
