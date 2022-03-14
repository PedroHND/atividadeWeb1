package com.entregas.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entregas.dao.PedidoDao;
import com.entregas.model.Pedido;
import com.google.gson.Gson;

@WebServlet("/entregasJson")
public class PrincipalServletJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private Gson gson = new Gson();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PedidoDao pedidoDao = new PedidoDao();
		
		String id = request.getParameter("id");
		Long ident = Long.parseLong(id);
		
		Pedido pedido = pedidoDao.consultarPorId(ident);
		
		String pedidoJson = this.gson.toJson(pedido);
		PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(pedidoJson);
        out.flush();
		
		
	}
	
}
