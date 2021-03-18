package com.f3pro.cursomc;

import com.f3pro.cursomc.domain.Categoria;
import com.f3pro.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1= new Categoria(null,"Informatica");
		Categoria cat2= new Categoria(null,"Escritorio");
		Categoria cat3= new Categoria(null,"Livros");


		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

	}
}
