package com.f3pro.cursomc;

import com.f3pro.cursomc.domain.Categoria;
import com.f3pro.cursomc.domain.Cidade;
import com.f3pro.cursomc.domain.Cliente;
import com.f3pro.cursomc.domain.Endereco;
import com.f3pro.cursomc.domain.Estado;
import com.f3pro.cursomc.domain.Produto;
import com.f3pro.cursomc.domain.enums.TipoCliente;
import com.f3pro.cursomc.repositories.CategoriaRepository;
import com.f3pro.cursomc.repositories.CidadeRepository;
import com.f3pro.cursomc.repositories.ClienteRepository;
import com.f3pro.cursomc.repositories.EnderecoRepository;
import com.f3pro.cursomc.repositories.EstadoRepository;
import com.f3pro.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		//Populando Categoria e Produto 
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		Cidade c4 = new Cidade(null, "Vargem Grande Paulista", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		//Populando Estado e cidade 
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

		Cliente cli1 = new Cliente(null, "Francivaldo Alves", "francivaldo.sza@hotmail.com", "021.668.381-54",
				TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("95156730", "45151325"));
		
		
		Endereco e1 = new Endereco(null, "Rua João XXIII", "935", "casa 4", "São Judas", "06730-000", cli1, c4);
		Endereco e2 = new Endereco(null, "Rua das Flores", "10", "torre 2", "bairro judas", "06730-000", cli1, c1);
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		//Salvando Cliente e Endereço
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));

	}

}
