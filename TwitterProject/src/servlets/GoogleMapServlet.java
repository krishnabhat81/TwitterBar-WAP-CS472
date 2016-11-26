package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.ModelTwitter;
import twitter4j.Trend;

/**
 * Servlet implementation class GoogleMapServlet
 */
@WebServlet("/googleMapServlet.ajax")
public class GoogleMapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoogleMapServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lat = request.getParameter("lat");//"41.018132";
		String lng = request.getParameter("lng");//"-91.966760";//
		
		ModelTwitter twitterModel = new ModelTwitter();
		List<Trend> list = twitterModel.fetchTrends(lat, lng);
		
		response.setCharacterEncoding("utf-8");//character encoding capable of encoding all possible characters  || removes ???????
        response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(list));//nearby trends
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
