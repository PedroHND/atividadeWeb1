package climatempo.acao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cliente {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException, ServletException {

		String nomeCidade = request.getParameter("nome");
		String uf = request.getParameter("UF");
		String nome = nomeCidade.replaceAll("", " ");
		
		
		String sti = "https://api.hgbrasil.com/weather?key=5cadf7d9&city_name="+nome +","+uf;
		URL url = new URL(sti);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("GET");
		BufferedReader buf = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String output = new String(buf.readLine().getBytes("UTF-8"));
		con.disconnect();

		return output;

	}
}
