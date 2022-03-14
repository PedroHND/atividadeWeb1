package com.entregas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entregas.util.AddDadosBD;

public class PassandoDados implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AddDadosBD ad = new AddDadosBD();
		ad.addEstados();
		
		return "redirect:HomePage.jsp";
	}

}
