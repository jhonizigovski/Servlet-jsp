package br.edu.ifms.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifms.dao.CarroDAO;
import br.edu.ifms.modelo.Carro;

/**
 * Servlet implementation class AdminControle
 */
@WebServlet("/auth/admin")
public class AdminControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CarroDAO carroDao;
	
    public AdminControle() {
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
			case "listar":
				listarCarro(request, response);
				break;
			case "apagar":
				apagarCarro(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		
	}

	private void listarCarro(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		List<Carro> carros = carroDao.listarTodosCarros();
		
		request.setAttribute("listaCarros", carros);
		
		String path =  request.getServletPath() + "/admin-listar-carro.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		
		dispatcher.forward(request, response);

	}
	
	private void apagarCarro(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		Carro carro = new Carro();
		carro.setId(id);
		carroDao.apagarCarro(carro);
		
		String path = request.getContextPath() + request.getServletPath() + "?acao=listar";
		response.sendRedirect(path);


	}

}
