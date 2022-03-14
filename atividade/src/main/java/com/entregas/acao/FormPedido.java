package com.entregas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entregas.dao.PedidoDao;
import com.entregas.model.Pedido;

public class FormPedido implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return "forward:fazerPedido.jsp";
	}

	
}
