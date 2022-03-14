package climatempo.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import climatempo.acao.Acao;
@WebServlet("/clima")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Passando pelo service");
		String paramAcao = request.getParameter("acao");
		System.out.println("acao: " + paramAcao);		
		
	
		String nomeDaClasse = "climatempo.acao." + paramAcao;
		System.out.println(nomeDaClasse);
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.out.println("pegando uma excecao servlet");
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
