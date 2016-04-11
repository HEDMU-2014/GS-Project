package gs.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import domain.User;

/**
 * Servlet implementation class TestRest
 */
@WebServlet("/TestRest")
public class TestRest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PATH = "http://bjorn-dell:8080/gs.ws/rest/user/";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Client client = ClientBuilder.newClient();
		List<User> list = client.target(PATH + "search/b").request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<User>>() {
				});
		response.getOutputStream().println("list = " + list.size());
		for (User parameter : list) {
			response.getOutputStream().println("* parameter = " + parameter);
		}
		User parameter = new User(); // .setKey("test").setValue("Test");
		Boolean b = client.target(PATH).request(MediaType.APPLICATION_JSON).post(Entity.json(parameter), Boolean.class);
		response.getOutputStream().println("Boolean = " + b);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
