package com.entregas.util;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.entregas.control.JPAUtil;
import com.entregas.dao.EnderecoDao;
import com.entregas.dao.EstadoDao;
import com.entregas.dao.ProdutoDao;
import com.entregas.dao.UsuarioDao;
import com.entregas.model.Endereco;
import com.entregas.model.Estado;
import com.entregas.model.Produto;
import com.entregas.model.Usuario;

public class AddDadosBD {

	public void addEstados() {
		
		EstadoDao estadoDAO = new EstadoDao();

		EntityManager em = JPAUtil.getEntityManager();
		
		Estado ac = new Estado("AC", "Acre", "Norte");
		Estado al = new Estado("AL", "Alagoas", "Nordeste");
		Estado ap = new Estado("AP", "Amapa", "Norte");
		Estado am = new Estado("AM", "Amazonas", "Norte");
		Estado ba = new Estado("BA", "Bahia", "Nordeste");
		Estado ce = new Estado("CE", "Ceara", "Nordetes");
		Estado df = new Estado("DF", "Distrito Federal", "Centro Oeste");
		Estado es = new Estado("ES", "Espirito Santo", "Sudeste");
		Estado go = new Estado("GO", "Goias", "Centro Oeste");
		Estado ma = new Estado("MA", "Maranhao", "Nordeste");
		Estado mt = new Estado("MT", "Mato Grosso", "Centro Oeste");
		Estado ms = new Estado("MS", "Mato Grosso do Sul", "Sul");
		Estado mg = new Estado("MG", "Minas Gerais", "Sudeste");
		Estado pa = new Estado("PA", "Para", "Norte");
		Estado pb = new Estado("PB", "Paraiba", "Nordeste");
		Estado pr = new Estado("PR", "Parana", "Sul");
		Estado pe = new Estado("PE", "Pernambuco", "Nordeste");
		Estado pi = new Estado("PI", "Piaui", "Nordeste");
		Estado rj = new Estado("RJ", "Rio de Janeiro", "Sudeste");
		Estado rn = new Estado("RN", "Rio Grande do Norte", "Nordeste");
		Estado rs = new Estado("RS", "Rio Grande do Sul", "Sul");
		Estado ro = new Estado("RO", "Rondonia", "Norte");
		Estado rr = new Estado("RR", "Roraima", "Norte");
		Estado sc = new Estado("SC", "Santa Catarina", "Sul");
		Estado sp = new Estado("SP", "Sao Paulo", "Sudeste");
		Estado se = new Estado("SE", "Sergipe", "Nordeste");
		Estado to = new Estado("TO", "Tocantins", "Norte");

		em.getTransaction().begin();
		estadoDAO.cadastrar(ac);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(al);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(ap);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(am);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(ba);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(ce);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(df);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(es);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(go);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(ma);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(mt);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(ms);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(ba);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(mg);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(pa);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(pb);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(pr);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(pe);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(pi);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(rj);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(rn);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(rs);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(ro);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(rr);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(sc);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(sp);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(se);
		System.out.println("cadastrando" + estadoDAO);
		estadoDAO.cadastrar(to);
		System.out.println("cadastrando" + estadoDAO);
		System.out.println("Estados cadastrados");
		em.getTransaction().commit();
		
		//add dados para testes
		Endereco endereco = new Endereco("Jose Rosa Machado", es, 19, "Apto. 302", "29308-815", "Alto Novo Parque", "Cachoeiro de Itapemirim");
		Usuario user = new Usuario("Pedro", "2019", endereco);
		EnderecoDao ed = new EnderecoDao();
		ed.cadastrar(endereco);
		UsuarioDao ud = new UsuarioDao();
		ud.cadastrar(user);
		Endereco endereco2 = new Endereco("Jose Rosa Machado", rj, 9, null, "29308-815", "Alto Novo Parque", "Cachoeiro de Itapemirim");
		Usuario user2 = new Usuario("Julia", "2019", endereco2);
		ed.cadastrar(endereco2);
		ud.cadastrar(user2);
		
		ProdutoDao pd = new ProdutoDao();
		Produto pro1 = new Produto("Notebook Dell", new BigDecimal("2000.0"));
		pd.cadastrar(pro1);
		Produto pro2 = new Produto("Notebook Lenovo", new BigDecimal("1900.0"));
		pd.cadastrar(pro2);
		Produto pro3 = new Produto("SSD 250GB", new BigDecimal("200.0"));
		pd.cadastrar(pro3);
		Produto pro4 = new Produto("Celular Xiaomi", new BigDecimal("1100.0"));
		pd.cadastrar(pro4);
		Produto pro5 = new Produto("Placa de video Nvidia", new BigDecimal("1499.0"));
		pd.cadastrar(pro5);
	}
}
