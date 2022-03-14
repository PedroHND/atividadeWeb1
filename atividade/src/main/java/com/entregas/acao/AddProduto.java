package com.entregas.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entregas.dao.PedidoDao;
import com.entregas.dao.ProdutoDao;
import com.entregas.dao.UsuarioDao;
import com.entregas.model.Pedido;
import com.entregas.model.Produto;
import com.entregas.model.Usuario;

public class AddProduto implements Acao {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		UsuarioDao userDao = new UsuarioDao();
		PedidoDao pedidoDao = new PedidoDao();
		ProdutoDao produtoDao = new ProdutoDao();
		
		String login = request.getParameter("idUser");
		System.out.println(login);
		String id = request.getParameter("id");
		String po = request.getParameter("produto");
				
		Long ident = Long.parseLong(id);
		Pedido pedido = pedidoDao.consultarPorId(ident);
		Long poId = Long.parseLong(po);
		Produto produto= produtoDao.consultarPorId(poId);
		
		System.out.println("Atualizou");
		Long userId = Long.parseLong(login);
		if(pedido.getValor() == null) {
			pedido.setValor(produto.getPreco());
			;
		}else {
			pedido.setValor(pedido.getValor().add(produto.getPreco()));
		}

		pedido.addProduto(produto);
		
		pedidoDao.atualizar(pedido);
		
		ProdutoDao pod = new ProdutoDao();
    	List<Produto> prod = pod.imprimeCatalogo();
		
    	
		Usuario user = userDao.consultarId(userId);
		
		sessao.setAttribute("usuarioLogado", user);
		sessao.setAttribute("pedidoUsuario", pedido);
		sessao.setAttribute("produtos", prod);
		return "redirect:entregas?acao=FormPedido&id=" + pedido.getId();

	}
}
