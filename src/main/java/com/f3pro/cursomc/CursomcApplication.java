package com.f3pro.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.f3pro.cursomc.domain.Categoria;
import com.f3pro.cursomc.domain.Cidade;
import com.f3pro.cursomc.domain.Cliente;
import com.f3pro.cursomc.domain.Endereco;
import com.f3pro.cursomc.domain.Estado;
import com.f3pro.cursomc.domain.ItemPedido;
import com.f3pro.cursomc.domain.Pagamento;
import com.f3pro.cursomc.domain.PagamentoComBoleto;
import com.f3pro.cursomc.domain.PagamentoComCartao;
import com.f3pro.cursomc.domain.Pedido;
import com.f3pro.cursomc.domain.Produto;
import com.f3pro.cursomc.domain.enums.EstadoPagamento;
import com.f3pro.cursomc.domain.enums.TipoCliente;
import com.f3pro.cursomc.repositories.CategoriaRepository;
import com.f3pro.cursomc.repositories.CidadeRepository;
import com.f3pro.cursomc.repositories.ClienteRepository;
import com.f3pro.cursomc.repositories.EnderecoRepository;
import com.f3pro.cursomc.repositories.EstadoRepository;
import com.f3pro.cursomc.repositories.ItemPedidoRepository;
import com.f3pro.cursomc.repositories.PagamentoRepository;
import com.f3pro.cursomc.repositories.PedidoRepository;
import com.f3pro.cursomc.repositories.ProdutoRepository;

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

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4= new Categoria(null, "jardinagem");
		Categoria cat5 = new Categoria(null, "Decoração");
		Categoria cat6 = new Categoria(null, "eletronicos");
		Categoria cat7 = new Categoria(null, "Pefumes");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		// Populando Categoria e Produto
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3,cat4,cat5,cat6,cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		Cidade c4 = new Cidade(null, "Vargem Grande Paulista", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		// Populando Estado e cidade
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

		Cliente cli1 = new Cliente(null, "Francivaldo Alves", "francivaldo.sza@hotmail.com", "021.668.381-54",
				TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("95156730", "45151325"));

		Endereco e1 = new Endereco(null, "Rua João XXIII", "935", "casa 4", "São Judas", "06730-000", cli1, c4);
		Endereco e2 = new Endereco(null, "Rua das Flores", "10", "torre 2", "bairro judas", "06730-000", cli1, c1);
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		// Salvando Cliente e Endereço
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("21/03/2019 18:34"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("20/03/2021 18:00"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/03/2021 00:00"),
				null);
		ped2.setPagamento(pagto2);
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2 ));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
	}
}
