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

public class CadUsuario {

public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Cadastrando novo usuário");
		
		String paramNomeUser = request.getParameter("nome");
		String paramSenha = request.getParameter("senha");
		String paramCepEndereco = request.getParameter("cep");
		String paramRuaEndereco = request.getParameter("rua");
		String paramBairroEndereco = request.getParameter("bairro");
		String paramEstadoEndereco = request.getParameter("estado");		
		String paramMunicipio = request.getParameter("municipio");
		String paramNumeroEndereco = request.getParameter("numero");
		String paramComplementoEndereco = request.getParameter("complemento");				

		Estado estado = new Estado(paramEstadoEndereco);
		
		Long numeroEndereco = Long.parseLong(paramNumeroEndereco);
		
		Endereco endereco = new Endereco(paramRuaEndereco, estado, numeroEndereco, paramComplementoEndereco, paramCepEndereco, paramBairroEndereco,
				paramMunicipio);
		Usuario user = new Usuario(paramNomeUser, paramSenha,endereco);
		
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDao usuarioDao = new  UsuarioDao();
		EnderecoDao enderecoDao = new EnderecoDao();
		enderecoDao.cadastrar(endereco);
		usuarioDao.cadastrar(user);
		
		
		request.setAttribute("usuario", user.getNome());
		
		return "redirect:entregas?acao=Login";
	
	}
}
	

