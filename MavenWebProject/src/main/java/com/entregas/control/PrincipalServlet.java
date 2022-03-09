package com.entregas.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entregas.acao.Acao;

@WebServlet("/entregas")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Passando pelo service");
		String paramAcao = request.getParameter("acao");
		System.out.println("pegando a acao" + paramAcao);
		HttpSession sessao = request.getSession();
		boolean deslogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean protecao = !(paramAcao.equals("Login") || paramAcao.equals("FormLogin"));
		if (protecao & deslogado) {
			response.sendRedirect("entregas?acao=FormLogin");
			return;
		}

		String nomeDaClasse = "com.entregas.acao." + paramAcao;

		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);// carrega a classe com o nome
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] entrada = nome.split(":");
		if (entrada[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + entrada[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(entrada[1]);
		}

	}
}
