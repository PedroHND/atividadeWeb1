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

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		System.out.println("login realizado: " + login);
		
		UsuarioDao userDao = new UsuarioDao();
		Usuario user = userDao.consultarLogin(login, senha);
		
		if (user!=null ) {
			System.out.println("login aprovado");
			
			HttpSession sessao = request.getSession();
			
			sessao.setAttribute("usuarioLogado", user);
			
			PedidoDao pd= new PedidoDao();
			Pedido pedido = new Pedido();
			pd.cadastrar(pedido);
			sessao.setAttribute("pedidoUsuario", pedido);
			System.out.println(pd + "\n" + pedido);
			ProdutoDao pod = new ProdutoDao();
	    	List<Produto> produto = pod.imprimeCatalogo();
	    	System.out.println(produto);
	    	
	    	sessao.setAttribute("produtos", produto);
			return "redirect:entregas?acao=FormPedido&id=" + pedido.getId(); 
		}
		else{
			return "redirect:entregas?acao=FormLogin";
		}
	}
}
