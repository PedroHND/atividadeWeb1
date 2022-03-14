package com.entregas.acao;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entregas.dao.EstadoDao;
import com.entregas.dao.PedidoDao;
import com.entregas.dao.UsuarioDao;
import com.entregas.model.Endereco;
import com.entregas.model.Estado;
import com.entregas.model.Pedido;
import com.entregas.model.Usuario;

public class CalcularFrete implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		String idPedido = request.getParameter("id");
		String idUsuario = request.getParameter("idUser");
		
		Long numPedido = Long.parseLong(idPedido);
		Long numUsuario = Long.parseLong(idUsuario);
		
		PedidoDao pDao = new PedidoDao();
		Pedido p = pDao.consultarPorId(numPedido);
		
		UsuarioDao uDao = new UsuarioDao();
		Usuario u = uDao.consultarId(numUsuario);
		
		Endereco end = new Endereco();
		end = u.getEndereco();
		
		EstadoDao estDao = new EstadoDao();
		Estado est = new Estado();
		
		est = estDao.consultarId(end.getEstado());
		
		if ( ( (est.getSigla() == "ES") || (est.getSigla() == "SP") || (est.getSigla() == "RS") ) ) {
			p.setPrazo(3);
			p.getPrazo();
			p.setFrete(new BigDecimal("0.0"));
			p.getFrete();
		} else if( est.getRegiao() == "Nordeste" ){
			p.setPrazo(20);
			p.getPrazo();
			p.setFrete(new BigDecimal("45.0"));
			p.getFrete();
		} else if( est.getRegiao() == "Sudeste" ){
			p.setPrazo(8);
			p.getPrazo();
			p.setFrete(new BigDecimal("20.0"));
			p.getFrete();
		}else if( est.getRegiao() == "Sul" ){
			p.setPrazo(6);
			p.getPrazo();
			p.setFrete(new BigDecimal("25.0"));
			p.getFrete();
		}else if( est.getRegiao() == "Centro Oeste" ){
			p.setPrazo(12);
			p.getPrazo();
			p.setFrete(new BigDecimal("57.0"));
			p.getFrete();
		}else if( est.getRegiao() == "Norte" ){
			p.setPrazo(18);
			p.getPrazo();
			p.setFrete(new BigDecimal("32.0"));
			p.getFrete();
		}else {
			p.setPrazo(30);
			p.getPrazo();
			p.setFrete(new BigDecimal("75.0"));
			p.getFrete();
		}
		
		sessao.setAttribute("pedidoUsuario", p);
		sessao.setAttribute("estadoEntrega", est);
		
		return "redirect:entregas?acao=ImprimeRelatorio";
	}

}
