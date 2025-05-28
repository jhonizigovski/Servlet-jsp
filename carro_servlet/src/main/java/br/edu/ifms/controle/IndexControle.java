package br.edu.ifms.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifms.controle.util.ManipulacaoData;
import br.edu.ifms.dao.CarroDAO;
import br.edu.ifms.modelo.Carro;



@WebServlet("/publica")
public class IndexControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CarroDAO carroDao;
	
    public IndexControle() {
        super();
    }
    
    public void init() {
    	carroDao = new CarroDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}
	
	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		try {
			switch (acao) {
			case "novo":
				novoCarro(request, response);
				break;
			case "inserir":
				gravarCarro(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		
	}
	
	private void novoCarro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publica-novo-carro.jsp");
		dispatcher.forward(request, response);
	}
	
	private void gravarCarro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {		
	
		String marca = request.getParameter("marca");
		String nome = request.getParameter("nome");
		String modelo = request.getParameter("modelo");
		String cor = request.getParameter("cor");
		String data = request.getParameter("fabricacao");
		String chassi = request.getParameter("chassi");
		
		ManipulacaoData manipulacaoData = new ManipulacaoData();
		Date dataFabricacao = manipulacaoData.converterStringData(data);
		
		Carro carro = new Carro(marca, nome, modelo, cor, dataFabricacao, chassi, false);
		
		Carro carroGravado = carroDao.inserirCarro(carro);
		request.setAttribute("carroGravado", carroGravado);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publica-lista-carro-cadastrado.jsp");
		request.setAttribute("mensagem", "Carro cadastrado com sucesso");
		dispatcher.forward(request, response);

	}

}
