package com.entregas.acao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entregas.control.JPAUtil;
import com.entregas.dao.EnderecoDao;
import com.entregas.dao.UsuarioDao;
import com.entregas.model.Endereco;
import com.entregas.model.Estado;
import com.entregas.model.Usuario;

public class CadUsuario implements Acao{

@Override
public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Cadastrando novo usuario");
		
		String paramNomeUser = request.getParameter("nome");
		System.out.println(paramNomeUser);
		String paramSenha = request.getParameter("senha");
		System.out.println(paramSenha);
		String paramCepEndereco = request.getParameter("cep");
		System.out.println(paramCepEndereco);
		String paramRuaEndereco = request.getParameter("rua");
		System.out.println(paramRuaEndereco);
		String paramBairroEndereco = request.getParameter("bairro");
		System.out.println(paramBairroEndereco);
		String paramEstadoEndereco = request.getParameter("estado");	
		System.out.println(paramEstadoEndereco);
		String paramMunicipio = request.getParameter("municipio");
		System.out.println(paramMunicipio);
		String paramNumeroEndereco = request.getParameter("numero");
		System.out.println(paramNumeroEndereco + "   String");
		String paramComplementoEndereco = request.getParameter("complemento");
		System.out.println(paramComplementoEndereco);

		Estado estado = new Estado(paramEstadoEndereco);
		Integer numeroEndereco = 0;
		numeroEndereco = Integer.parseInt(paramNumeroEndereco);
		
		Endereco endereco = new Endereco(paramRuaEndereco, estado, numeroEndereco, paramComplementoEndereco, paramCepEndereco, paramBairroEndereco, paramMunicipio);
		Usuario user = new Usuario(paramNomeUser, paramSenha,endereco);
		
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDao usuarioDao = new  UsuarioDao();
		EnderecoDao enderecoDao = new EnderecoDao();
		enderecoDao.cadastrar(endereco);
		usuarioDao.cadastrar(user);
		
		
		request.setAttribute("usuario", user.getNome());
		
		return "redirect:entregas?acao=FormLogin";
	
	}
}
	

