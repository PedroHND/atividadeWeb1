package com.entregas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entregas.dao.UsuarioDao;
import com.entregas.model.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		System.out.println("login realizado" + login);
		
		UsuarioDao userDao = new UsuarioDao();
		Usuario user = userDao.consultarPorId(login, senha);
		
		if (user!=null ) {
			System.out.println("login aprovado");
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", user);
			return "redirect:entregas?acao=FazerPedido"; //completar
		}
		else{
			return "redirect:entregas?acao=FormLogin";
		}
	}
}
