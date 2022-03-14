package com.entregas.acao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entregas.dao.EstadoDao;
import com.entregas.model.Estado;

public class FormCadastro  implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	HttpSession sessao= request.getSession();
    	EstadoDao ed = new EstadoDao();
    	List<Estado> estado = ed.imprimeSiglas();
    	System.out.println(estado);
    	
    	sessao.setAttribute("estados", estado);
    	
        return "forward:CadastroUser.jsp";
    }
}
