package com.entregas.control;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/entregas")
public class AutorizacaoFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("acao");
		System.out.println("acao: " + paramAcao);		
		
		HttpSession sessao = request.getSession();
		boolean deslogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean protecao = !(paramAcao.equals("Login") 
							|| paramAcao.equals("FormLogin") 
							|| paramAcao.equals("CadUsuario")
							|| paramAcao.equals("PassandoDados")
							|| paramAcao.equals("FormCadastro"));	
		
		
		if (protecao && deslogado) {
			
			response.sendRedirect("entregas?acao=FormLogin");
			return;
		}


        chain.doFilter(request, response);

    }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {	
	}

	@Override
	public void destroy() {
	}

}